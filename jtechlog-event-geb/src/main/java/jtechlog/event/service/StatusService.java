package jtechlog.event.service;

import com.google.common.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

    @Autowired
    private EventBus eventBus;

    public void postStatus(String status) {
        LOGGER.debug("Status: {}", status);
        eventBus.post(new StatusEvent(status));
    }

}
