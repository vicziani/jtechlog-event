package jtechlog.event.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements ApplicationEventPublisherAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

    private ApplicationEventPublisher applicationEventPublisher;

    public void postStatus(String status) {
        LOGGER.debug("Status: {}", status);
        applicationEventPublisher.publishEvent(new StatusEvent(this, status));
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
