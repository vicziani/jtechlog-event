package jtechlog.event.service;

public class StatusEvent {

    private String status;

    public StatusEvent(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
