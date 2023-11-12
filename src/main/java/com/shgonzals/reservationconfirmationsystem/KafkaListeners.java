package com.shgonzals.reservationconfirmationsystem;

import com.shgonzals.reservationconfirmationsystem.commons.dto.Confirmation;
import com.shgonzals.reservationconfirmationsystem.resend.SendEmail;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

	private final SendEmail sendEmail;

	@KafkaListener(topics = "confirmation-topic",
			groupId = "groupId",
			containerFactory = "factory" //para deserializer custom
	)
	void listener(Confirmation data){
		try {
			sendEmail.resend(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
