package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.*;

import static java.util.Arrays.asList;

public class CalendarDataStoreImpl implements CalendarDataStore {

    private final Map<UUID, Event> eventStore = new HashMap<>();
    private final Map<String, List<UUID>> nameStore = new HashMap<>();

    //    private final Map<Event,List<UUID>> store2 = new HashMap<>();
    @Override
    public void publish(Event event) {
        UUID uuid = UUID.randomUUID();
        eventStore.put(uuid, event);
        List<UUID> existingEvents = nameStore.get(event.getName());
        if (existingEvents == null)
            nameStore.put(event.getName(), asList(uuid));
        else{
            ArrayList<UUID> uuids = new ArrayList<UUID>(existingEvents);
            uuids.add(uuid);
            nameStore.put(event.getName(), uuids);
        }
        persistEvent(event);
    }

    @Override
    public Event remove(String eventName) {
        Event event = eventStore.get(eventName);
        eventStore.remove(eventName);
        return event;
    }

    @Override
    public List<Event> getEvent(String name) {
        List<UUID> uuids = nameStore.get(name);
        List<Event> events = new ArrayList<>();
        for (UUID uuid : uuids) {
            events.add(eventStore.get(uuid));
        }
        return events;
    }

    private void persistEvent(Event expectedEvent) {

        JAXBContext context = null;

        EventAdapter eventAdapter = new EventAdapter(expectedEvent);
        try {
            context = JAXBContext.newInstance(EventAdapter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(eventAdapter, new File("./" + expectedEvent.getName() + ". xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}