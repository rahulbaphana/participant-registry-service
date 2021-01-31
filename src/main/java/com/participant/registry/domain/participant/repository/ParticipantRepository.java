package com.participant.registry.domain.participant.repository;

import com.participant.registry.domain.participant.entity.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    Participant findByReferenceNumber(String referenceNumber);
}
