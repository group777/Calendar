package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;

import java.util.List;

public interface CalendarDataStore {

    void publish(Event event);

    Event remove(String eventName);

    List<Event> getEvent(String name);
}
