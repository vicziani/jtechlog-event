package jtechlog.event.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

    private List<StatusEventListener> statusEventListeners = new ArrayList<StatusEventListener>();

    public void postStatus(String status) {
        LOGGER.debug("Status: {}", status);
        for (StatusEventListener statusEventListener: statusEventListeners) {
            statusEventListener.onStatusEvent(new StatusEvent(this, status));
        }
    }

    public void addStatusEventListener(StatusEventListener statusEventListener) {
        statusEventListeners.add(statusEventListener);
    }

}
