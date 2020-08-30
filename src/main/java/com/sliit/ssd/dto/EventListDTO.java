package com.sliit.ssd.dto;

import com.sliit.ssd.model.CalendarEvent;
import lombok.Data;

import java.util.List;

@Data
public class EventListDTO {
    private List<CalendarEvent> calendarEventList;
}
