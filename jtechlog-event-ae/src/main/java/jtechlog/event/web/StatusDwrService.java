package jtechlog.event.web;

import jtechlog.event.service.StatusService;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy(name="statusDwrService")
public class StatusDwrService {

    @Autowired
    private StatusService statusService;

    @SuppressWarnings("unused")
    @RemoteMethod
    public void postStatus(String status) {
        statusService.postStatus(status);
    }

}
