package com.epam.yoke.event.service;

import com.epam.yoke.event.dao.NotifierDao;
import com.epam.yoke.event.mapper.EventMapper;
import com.epam.yoke.event.model.rq.NotifyEventBody;
import com.epam.yoke.event.model.rs.NotifyEvent;
import com.epam.yoke.event.model.rs.NotifyEventResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifyService {

    private static final Logger logger = LoggerFactory.getLogger(NotifyService.class);

    private NotifierDao notifierDao;
    private EventMapper eventMapper;

    @Autowired
    public NotifyService(NotifierDao notifierDao, EventMapper eventMapper) {
        this.notifierDao = notifierDao;
        this.eventMapper = eventMapper;
    }

    public NotifyEvent[] getEvents() {
        return notifierDao.retrieveNotifyEvents();
    }

    public void deleteEvent(String eventId) {
        notifierDao.deleteEvent(eventId);
    }

    public NotifyEventResponse createEvent(Long eventId, String description) {
        NotifyEventBody rq = new NotifyEventBody();
        rq.setEventId(String.valueOf(eventId));
        rq.setDescription(description);

        NotifyEventResponse res = notifierDao.createEvent(rq);
        logger.info("Created event for the notifier: {}", res);
        return res;
    }
}
