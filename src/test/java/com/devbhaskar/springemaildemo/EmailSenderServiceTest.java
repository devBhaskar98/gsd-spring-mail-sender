package com.devbhaskar.springemaildemo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.devbhaskar.springemaildemo.EmailSenderService;

public class EmailSenderServiceTest {

	@Test
	void testSendSimpleEmail() {
		// Arrange
		JavaMailSender mailSender = mock(JavaMailSender.class);
		EmailSenderService service = new EmailSenderService();
		// Inject mock
		service = spy(service);
		service.mailSender = mailSender;

		String to = "test@example.com";
		String subject = "Test Subject";
		String body = "Test Body";

		// Act
		service.sendSimpleEmail(to, subject, body);

		// Assert (Verify mailSender.send() is called once)
		verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
	}
}
