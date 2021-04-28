package com.cg.testing;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.participant.service.IParticipantService;
import com.cg.apps.surveyapp.participant.service.IParticipantServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IParticipantServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IParticipantServiceImplTest {

	@Autowired
	private IParticipantService participantService;
	@Autowired
	private EntityManager em;

	@Test
	void register() {
		Participant participant = new Participant("Shivam_111", "Shivam", "Sharma");
		Participant savedPart = participantService.register(participant);
		Assertions.assertEquals(participant.getFirstName(), savedPart.getFirstName());
		Assertions.assertEquals(participant.getLastName(), savedPart.getLastName());
		Assertions.assertEquals(participant.getUsername(), savedPart.getUsername());
	}

	@Test
	void update() {
		Participant participant = new Participant("Shivam_111", "Shivam", "Sharma");
		em.persist(participant);
		participant.setFirstName("Rahul");
		Participant updatePart = participantService.update(participant);
		em.persist(updatePart);
		assertEquals(participant, updatePart);
	}

	@Test
	void countParticipations() {
		Participant participant = new Participant("Shivam_111", "Shivam", "Sharma");
		em.persist(participant);
		int count = participantService.countParticipations(participant);
		assertEquals(0, count);

	}

}
