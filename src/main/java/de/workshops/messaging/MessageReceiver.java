package de.workshops.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "inbox", containerFactory = "messagingFactory")
    public void receiveMessage(Message message) {
        logger.info("Received <" + message + ">");
    }
}
