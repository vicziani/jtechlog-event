package jtechlog.event.service;

import org.springframework.context.ApplicationEvent;

public class StatusEvent extends ApplicationEvent {

    private String status;

    public StatusEvent(Object source, String status) {
        super(source);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
