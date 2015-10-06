package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;

public interface CalendarDataStore {

    void publish(Event event);

    Event remove(String eventName);

    Event getEvent(String name);
}
