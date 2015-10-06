package com.diosoft.sample.calendar;

import com.diosoft.sample.calendar.service.CalendarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;
import java.util.logging.Logger;

public class ClientMain {

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws RemoteException {

        ApplicationContext context = new ClassPathXmlApplicationContext("clientApplicationContext.xml");
        CalendarService service = (CalendarService) context.getBean("calendarService");

        String[] reservedCalendarNames = {"New Year", "Meeting10", "code review"};

        for (String name : reservedCalendarNames)
            service.addEvent2(name, name, null, null, null);

        for (String name : reservedCalendarNames)
            logger.info("Created event in data store: " + service.getEvent(name));

    }
}
