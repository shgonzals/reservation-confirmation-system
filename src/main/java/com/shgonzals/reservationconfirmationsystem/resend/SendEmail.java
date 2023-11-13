package com.shgonzals.reservationconfirmationsystem.resend;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.SendEmailRequest;
import com.resend.services.emails.model.SendEmailResponse;
import com.shgonzals.reservationconfirmationsystem.commons.dto.Confirmation;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

	Resend resend = new Resend("re_J61eBs2b_PEzhesG68cA7TkZKfxMJtxjV");

	public void resend(Confirmation confirmation){
		String fecha = confirmation.getDate().getDayOfMonth() + "-" + confirmation.getDate().getMonthValue()  + "-" +  confirmation.getDate().getYear();
		String fechaConfirmacion = confirmation.getDateReservation().getDayOfMonth() + "-" + confirmation.getDateReservation().getMonthValue()  + "-" +  confirmation.getDateReservation().getYear();

		SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
								.from("Reservation Confirmation System <send@shgonzals.es>")
								.to(confirmation.getEmail())
								.subject("Reserva confirmada " + confirmation.getRestaurant() + " " + fechaConfirmacion)
								.html("<div>\n"
									  + "<h2>Reserva confirmada</h2> \n"
									  + "<p>Su reserva en el restaurante "+ confirmation.getRestaurant() +" de "+confirmation.getCity() +" ha sido confirmada. </p>\n"
									  + "<p>Será para "+ confirmation.getPeople() +" personas el " + fecha
									  + " a las " + confirmation.getDate().getHour() + ":"+ confirmation.getDate().getMinute() +". </p>\n"
									  + "<p>Por favor no responda a este email.</p>"
									  + "</div>")
								.build();

		try {
			SendEmailResponse data = resend.emails().send(sendEmailRequest);
			System.out.println(data.getId());
		} catch (ResendException e) {
			e.printStackTrace();
		}
	}
}
