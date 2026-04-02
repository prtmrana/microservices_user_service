package com.example.demo.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.NotificationEventDto;

@Service
public class UserNotificationProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendUserRegisteredEvent(String email) {

        NotificationEventDto event = new NotificationEventDto();
        event.setEventType("USER_REGISTERED");
        event.setEmail(email);

        rabbitTemplate.convertAndSend(
            "notification_exchange",
            "user.registered",
            event
        );
    }
	
	
}
