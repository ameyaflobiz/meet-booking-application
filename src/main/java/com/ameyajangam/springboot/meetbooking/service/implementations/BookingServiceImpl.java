package com.ameyajangam.springboot.meetbooking.service.implementations;


import com.ameyajangam.springboot.meetbooking.dto.CheckAvailabilityResponse;
import com.ameyajangam.springboot.meetbooking.model.Booking;
import com.ameyajangam.springboot.meetbooking.model.MeetingRoom;
import com.ameyajangam.springboot.meetbooking.model.TimeStamp;
import com.ameyajangam.springboot.meetbooking.model.User;
import com.ameyajangam.springboot.meetbooking.repository.BookingRepository;
import com.ameyajangam.springboot.meetbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ameyajangam.springboot.meetbooking.utils.Pair;

import static java.util.stream.Collectors.toList;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    @Override
    public List<Booking> viewBookings() {
        List<Booking> bookings = repository.findAll();
        return bookings;
    }

    @Override
    public Booking bookMeeting(String title, LocalDateTime startTime, LocalDateTime endTime, MeetingRoom room, User user, List<String> participantsList) {
        TimeStamp timeStamp = TimeStamp.builder().startTime(startTime).endTime(endTime).build();
        List<User> userList = new ArrayList<>();
        Booking booking = Booking.builder().title(title).bookedBy(user).meetingRoom(room).timeStamp(timeStamp).participantsList(userList).build();
        CheckAvailabilityResponse response = checkAvailability(room, startTime, endTime);
        if(response.getErrorCode() == null)
        {
            repository.save(booking);
        }
        else
        {
            return null;
        }
        return booking;
    }

    @Override
    public CheckAvailabilityResponse checkAvailability(MeetingRoom room, LocalDateTime startTime, LocalDateTime endTime) {

        List<Booking> bookings = room.getBookings();
        System.out.println("loading......");

        long durationInHours = startTime.until(endTime, ChronoUnit.HOURS);

        List<Pair> timeSlots = new ArrayList<>();

        for (Booking booking : bookings) {
            LocalDateTime bookingStartTime = booking.getTimeStamp().getStartTime();
            LocalDateTime bookingEndTime = booking.getTimeStamp().getEndTime();
            timeSlots.add(new Pair(bookingStartTime,bookingEndTime));
        }

        timeSlots = timeSlots.stream().sorted(Comparator.comparing(Pair::getFirst)).collect(toList());;
        boolean flag = true;
        for(Pair timeSlot: timeSlots){
            System.out.println(timeSlot.getFirst() + " , " + timeSlot.getSecond());
            LocalDateTime bookingStartTime = timeSlot.getFirst();
            LocalDateTime bookingEndTime = timeSlot.getSecond();

            if ( startTime.isEqual(bookingStartTime) || (startTime.isAfter(bookingStartTime) && startTime.isBefore(bookingEndTime)))
            {
                System.out.println("Cannot book the meeting");
                flag = false;
                break;
            }
        }
        CheckAvailabilityResponse response = new CheckAvailabilityResponse();
        if (flag)
        {
            response.setMessage("Booking available");
        }
        else
        {
            long requiredDuration =ChronoUnit.MINUTES.between(startTime, endTime);
            /*
            * Basically I am fetching the duration and I will calculate s2-e1 and
            * will pick that fits the duration or else I will say en+1 time*/

            List<Pair> slotSuggestions = new ArrayList<>();
            LocalDateTime firstOption = timeSlots.get(0).getFirst();
            LocalDateTime e1 = timeSlots.get(0).getSecond();

            slotSuggestions.add(new Pair(null,firstOption));

            for(int i = 1; i < timeSlots.size(); i++)
            {
                LocalDateTime s2 = timeSlots.get(i).getFirst();
                long tempDuration =ChronoUnit.MINUTES.between(e1, s2);
                if(tempDuration >= requiredDuration + 1)
                {
                    slotSuggestions.add(new Pair(e1.plusMinutes(1),s2.minusMinutes(requiredDuration)));
                }
                e1 = timeSlots.get(i).getSecond();
            }
            LocalDateTime lastOption = timeSlots.get(timeSlots.size()-1).getSecond().plusMinutes(1);
            slotSuggestions.add(new Pair(lastOption, null));
            response.setErrorCode("BK01");
            response.setMessage("Another meeting is in schedule, but we have some slot suggestions for you");
            response.setSlotSuggestions(slotSuggestions);
        }
        return response;
    }
}
