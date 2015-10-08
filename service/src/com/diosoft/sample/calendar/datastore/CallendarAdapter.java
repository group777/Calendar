package com.diosoft.sample.calendar.datastore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class CallendarAdapter {

    @XmlElementWrapper(name = "events")
    @XmlElement(name = "event")
    private List<EventAdapter> events;

    public CallendarAdapter() {
    }

    public List<EventAdapter> getEvents() {
        return events;
    }


    public void setEvents(List<EventAdapter> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallendarAdapter that = (CallendarAdapter) o;

        if (events != null ? !events.equals(that.events) : that.events != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return events != null ? events.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CallendarAdapter{");
        sb.append("events=").append(events);
        sb.append('}');
        return sb.toString();
    }
}
