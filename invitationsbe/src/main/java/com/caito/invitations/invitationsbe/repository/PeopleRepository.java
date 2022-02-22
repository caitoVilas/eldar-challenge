package com.caito.invitations.invitationsbe.repository;

import com.caito.invitations.invitationsbe.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    boolean existsByDni(String dni);
}
