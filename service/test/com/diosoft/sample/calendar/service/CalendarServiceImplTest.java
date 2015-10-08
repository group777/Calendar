package com.diosoft.sample.calendar.service;

import com.diosoft.sample.calendar.common.Event;
import com.diosoft.sample.calendar.common.Person;
import com.diosoft.sample.calendar.datastore.CalendarDataStore;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

public class CalendarServiceImplTest {

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
        CalendarDataStore dataStore = mock(CalendarDataStore.class);

        // initialize class to test
        CalendarService service = new CalendarServiceImpl(dataStore);

        // invoke method on class to test
        service.addEvent2(inputName, inputDescription, inputStartDate, inputEndDate, attenders);

        // assert return value

        // verify mock expectations
        verify(dataStore).publish(expectedEvent);
    }

    @Test
    public void testRemoveEvent() throws Exception {
        // initialize variable inputs
        String inputName = "sampleEvent";

        Event expectedEvent = new Event.Builder()
                .name(inputName)
                .build();

        // initialize mocks
        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        when(dataStore.remove(inputName)).thenReturn(expectedEvent);

        // initialize class to test
        CalendarService service = new CalendarServiceImpl(dataStore);

        // invoke method on class to test
        Event returnedValue = service.removeEvent(inputName);

        // assert return value
        assertEquals(expectedEvent, returnedValue);

        // verify mock expectations
    }

    @Test
    public void testGetEvent() throws Exception {
        // initialize variable inputs
        String inputName = "sampleEvent";

        Event expectedEvent = new Event.Builder()
                .name(inputName)
                .build();

        // initialize mocks
        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        when(dataStore.getEvent(inputName)).thenReturn(expectedEvent);


        // initialize class to test
        CalendarService service = new CalendarServiceImpl(dataStore);

        // invoke method on class to test
        Event returnedValue = service.getEvent(inputName);

        // assert return value
        assertEquals(expectedEvent, returnedValue);

        // verify mock expectations
    }

    @Test
    public void testAddAttenderWithNull() throws Exception {
        // initialize variable inputs
        GregorianCalendar inputStartDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        GregorianCalendar inputEndDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        String inputName = "sampleEvent";
        String inputDescription = "sampleEventDescription";
        Person inputPerson = new Person.Builder().firstName("aName").build();
        Person inputNewPerson = new Person.Builder().firstName("aName2").build();
        List<Person> attenders = Arrays.asList(inputPerson);
        List<Person> newAttenders = Arrays.asList(inputPerson,inputNewPerson);


        Event expectedNewEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(newAttenders)
                .build();


        // initialize mocks
        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        when(dataStore.remove(inputName)).thenReturn(null);


        // initialize class to test
        CalendarService service = new CalendarServiceImpl(dataStore);

        // invoke method on class to test
        Event returnValue = service.addAttender(inputName, inputNewPerson);

        // assert return value
        assertNull(returnValue);

        // verify mock expectations
        verify(dataStore,times(0)).publish(expectedNewEvent);
    }

    @Test
    public void testAddAttender() throws Exception {
        // initialize variable inputs
        GregorianCalendar inputStartDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        GregorianCalendar inputEndDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        String inputName = "sampleEvent";
        String inputDescription = "sampleEventDescription";
        Person inputPerson = new Person.Builder().firstName("aName").build();
        Person inputNewPerson = new Person.Builder().firstName("aName2").build();
        List<Person> attenders = Arrays.asList(inputPerson);
        List<Person> newAttenders = Arrays.asList(inputPerson,inputNewPerson);

        Event expectedEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(attenders)
                .build();
        Event expectedNewEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(newAttenders)
                .build();


        // initialize mocks
        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        when(dataStore.remove(inputName)).thenReturn(expectedEvent);

        // initialize class to test
        CalendarService service = new CalendarServiceImpl(dataStore);

        // invoke method on class to test
        Event returnValue = service.addAttender(inputName, inputNewPerson);

        // assert return value
        assertEquals(expectedNewEvent, returnValue);

        // verify mock expectations
        verify(dataStore).publish(expectedNewEvent);
    }

    @Test
    public void testAddAttenderMulti() throws Exception {
        // initialize variable inputs
        GregorianCalendar inputStartDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        GregorianCalendar inputEndDate = new GregorianCalendar(2008, Calendar.APRIL,Calendar.TUESDAY,10, 12);
        String inputName = "sampleEvent";
        String inputDescription = "sampleEventDescription";
        Person inputPerson = new Person.Builder().firstName("aName").build();
        Person inputNewPerson = new Person.Builder().firstName("aName2").build();
        Person inputNewPerson2 = new Person.Builder().firstName("aName3").build();
        List<Person> attenders = Arrays.asList(inputPerson);
        List<Person> newAttenders = Arrays.asList(inputPerson,inputNewPerson,inputNewPerson2);

        Event expectedEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(attenders)
                .build();
        Event expectedNewEvent = new Event.Builder()
                .name(inputName)
                .description(inputDescription)
                .startTime(inputStartDate)
                .endTime(inputEndDate)
                .attenders(newAttenders)
                .build();


        // initialize mocks
        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        when(dataStore.remove(inputName)).thenReturn(expectedEvent);

        // initialize class to test
        CalendarService service = new CalendarServiceImpl(dataStore);

        // invoke method on class to test
        Event returnValue = service.addAttender(inputName, inputNewPerson, inputNewPerson2);

        // assert return value
        assertEquals(expectedNewEvent, returnValue);

        // verify mock expectations
        verify(dataStore).publish(expectedNewEvent);
    }
}
