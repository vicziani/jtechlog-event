package jtechlog.event.service;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

@Service
public class StatusEventSender implements ApplicationListener<StatusEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusEventSender.class);

    @Override
    public void onApplicationEvent(StatusEvent statusEvent) {
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
