package com.sliit.ssd.controller;

import com.sliit.ssd.model.CalendarEvent;
import com.sliit.ssd.model.NewEvent;
import com.sliit.ssd.service.CalendarEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

/**
 * Controller Class to retrieve Google Calendar Data
 */

@RestController
@RequestMapping("/api/google/")
public class CalendarEventController {

    @Autowired
    private CalendarEventService calendarEventService;

    /**
     * Endpoint to get all the list of calendar events from google calendar.
     * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
     *
     * @return ResponseEntity<Object>
     * @throws IOException throws IOException
     */
    @GetMapping("/events") // get all events
    public ResponseEntity<Object> viewAllEvents() throws IOException {
        List<CalendarEvent> eventList = calendarEventService.viewAllEvents(true);
        System.out.println(eventList.toString());
        if (eventList.isEmpty()) {
            return new ResponseEntity<>("No Upcoming Events", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }

    @GetMapping("/all-events")// get all event include the past event
    public ResponseEntity<Object> viewAllEventsIncludingPastEvents() throws IOException {
        List<CalendarEvent> eventList = calendarEventService.viewAllEvents(false);

        if (eventList.isEmpty()) {
            return new ResponseEntity<>("No Upcoming Events", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(eventList, HttpStatus.OK);
    }

    @PostMapping(value = "/event")// add event to google calander
    public ResponseEntity<Object> addEvent(@Valid @NotNull @RequestParam String summary,
                                           @RequestParam String description, @RequestParam String startDate,
                                           @RequestParam String endDate, @RequestParam String startTime,
                                           @RequestParam String endTime) throws IOException {
        NewEvent newEvent = new NewEvent();//create event object using NewEvent class

        // add value for propeties in the object
        newEvent.setSummary(summary);
        newEvent.setDescription(description);
        newEvent.setStartDate(startDate);
        newEvent.setEndDate(endDate);
        newEvent.setStartTime(startTime);
        newEvent.setEndTime(endTime);
        System.out.println(newEvent.toString());
        return new ResponseEntity<>(calendarEventService.addEvent(newEvent), HttpStatus.CREATED);//call calendar service to update calendar
    }
}
