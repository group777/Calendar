package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;
import com.diosoft.sample.calendar.common.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class CalendarDataStoreImplTest {

    @Test
    public void testAddEvent() throws Exception {
        // initialize variable inputs
        GregorianCalendar inputStartDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        GregorianCalendar inputEndDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        String inputName = "sampleEvent";
        String inputDescription = "sampleEventDescription";
        List<Person> attenders = Arrays.asList(new Person.Builder().firstName("aName").build());

        Event expectedEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(attenders)
                .build();

        // initialize mocks

        // initialize class to test
        CalendarDataStore dataStore =new CalendarDataStoreImpl();

        // invoke method on class to test
        dataStore.publish(expectedEvent);

        // assert return value
       Event returnedValue = dataStore.getEvent(inputName);

        assertEquals(expectedEvent, returnedValue);

        // verify mock expectations
    }

    @Test
    public void testRemove() throws Exception {
        // initialize variable inputs
        GregorianCalendar inputStartDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        GregorianCalendar inputEndDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        String inputName = "sampleEvent";
        String inputDescription = "sampleEventDescription";
        List<Person> attenders = Arrays.asList(new Person.Builder().firstName("aName").build());

        Event expectedEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(attenders)
                .build();

        // initialize mocks

        // initialize class to test
        CalendarDataStore dataStore =new CalendarDataStoreImpl();
        dataStore.publish(expectedEvent);

        // invoke method on class to test
        Event returnedValue = dataStore.remove(inputName);

        // assert return value
        Event returnedEmptyValue = dataStore.remove(inputName);

        assertEquals(expectedEvent, returnedValue);
        assertNull(returnedEmptyValue);

        // verify mock expectations
    }
}
