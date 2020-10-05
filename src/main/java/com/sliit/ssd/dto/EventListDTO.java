package com.sliit.ssd.dto;

import com.sliit.ssd.model.CalendarEvent;
import lombok.Data;

import java.util.List;

/**
 * Domain class for event list
 */
@Data
public class EventListDTO {
    private List<CalendarEvent> calendarEventList;
}
