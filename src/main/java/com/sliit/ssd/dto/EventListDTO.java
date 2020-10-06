package com.sliit.ssd.dto;

import com.sliit.ssd.model.CalendarEvent;
import lombok.Data;

import java.util.List;

/**
 * Domain class for event list
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@Data
public class EventListDTO {
    private List<CalendarEvent> calendarEventList;
}
