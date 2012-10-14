package jtechlog.event.web;

import jtechlog.event.service.StatusEvent;
import jtechlog.event.service.StatusEventListener;
import jtechlog.event.service.StatusService;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Iterator;

@Service
@SuppressWarnings("unused")
public class StatusEventSender implements StatusEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusEventSender.class);

    @Autowired
    private StatusService statusService;

    @PostConstruct
    private void register() {
        statusService.addStatusEventListener(this);
    }

    @Override
    public void onStatusEvent(StatusEvent statusEvent) {
        ScriptBuffer scriptBuffer = new ScriptBuffer();
        scriptBuffer.appendCall("showStatus", statusEvent.getStatus());
        WebContext webContext = WebContextFactory.get();
        String currentPage = webContext.getCurrentPage();
        Collection sessions = webContext.getScriptSessionsByPage(currentPage);
        LOGGER.debug("Call JavaScript, page: {}", currentPage);
        for (Iterator i = sessions.iterator(); i.hasNext(); ) {
            LOGGER.debug("Session");
            ScriptSession session = (ScriptSession) i.next();
            session.addScript(scriptBuffer);
        }
    }

}
