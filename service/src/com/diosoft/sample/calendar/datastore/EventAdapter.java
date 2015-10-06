package com.diosoft.sample.calendar.datastore;

import com.diosoft.sample.calendar.common.Event;
import com.diosoft.sample.calendar.common.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@XmlRootElement
@XmlType(name = "event")
public class EventAdapter implements Serializable {

    private String name;
    private String description;
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;

    private List<PersonAdapter> attenders;

    public EventAdapter() {
    }

    public EventAdapter(Event event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.startTime = event.getStartTime();
        this.endTime = event.getEndTime();

        this.attenders = new ArrayList<>();
        if (event.getAttenders() != null ) {
            for (Person person : event.getAttenders()) {
                this.attenders.add(new PersonAdapter(person));
            }

        }
    }

    @XmlElement(name = "person")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public void setStartTime(GregorianCalendar startTime) {
        this.startTime = startTime;
    }

    public GregorianCalendar getEndTime() {
        return endTime;
    }

    public void setEndTime(GregorianCalendar endTime) {
        this.endTime = endTime;
    }

    public List<PersonAdapter> getAttenders() {
        return attenders;
    }

    public void setAttenders(List<PersonAdapter> attenders) {
        this.attenders = attenders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventAdapter that = (EventAdapter) o;

        if (attenders != null ? !attenders.equals(that.attenders) : that.attenders != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventAdapter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", attenders=").append(attenders);
        sb.append('}');
        return sb.toString();
    }
}