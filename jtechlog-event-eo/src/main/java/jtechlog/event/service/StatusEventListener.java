package jtechlog.event.service;

import java.util.EventListener;

public interface StatusEventListener extends EventListener {

    void onStatusEvent(StatusEvent statusEvent);
}
