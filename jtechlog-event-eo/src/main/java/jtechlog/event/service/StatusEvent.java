package jtechlog.event.service;

import java.util.EventObject;

public class StatusEvent extends EventObject {

    private String status;

    public StatusEvent(Object source, String status) {
        super(source);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
