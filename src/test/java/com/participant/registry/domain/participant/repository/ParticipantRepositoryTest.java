package com.participant.registry.domain.participant.repository;

import com.participant.registry.BaseIntegrationTest;
import com.participant.registry.domain.participant.entity.Participant;
import com.participant.registry.support.DateUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParticipantRepositoryTest extends BaseIntegrationTest {
    @Test
    void should_save_participant() {
        // Given
        Participant johnDoe = Participant.builder()
            .referenceNumber("KFG-123")
            .name("John Doe")
            .dateOfBirth(DateUtil.dateOfBirthFormat("25-09-1987"))
            .address("AddressLine 1, USA - PostCode")
            .phoneNumber("0778956655")
            .build();

        // When
        participantRepository.save(johnDoe);
        Participant savedJohnDoeRecord = participantRepository.findByReferenceNumber(johnDoe.getReferenceNumber());

        // Then
        assertNotNull(savedJohnDoeRecord.getCreatedDate());
        assertNotNull(savedJohnDoeRecord.getModifiedDate());
        assertEquals("KFG-123", savedJohnDoeRecord.getReferenceNumber());
        assertEquals("John Doe", savedJohnDoeRecord.getName());
        assertEquals("0778956655", savedJohnDoeRecord.getPhoneNumber());
        assertEquals("25-09-1987", DateUtil.stringForDateOfBirthFormat(savedJohnDoeRecord.getDateOfBirth()));
    }
}
