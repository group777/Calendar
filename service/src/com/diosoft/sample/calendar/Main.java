package com.diosoft.sample.calendar;

import com.diosoft.sample.calendar.service.CalendarServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws RemoteException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CalendarServiceImpl calendarService = context.getBean("calendarService", CalendarServiceImpl.class);
        calendarService.getEvent("Name");
        logger.info("Service started");


    }
}
