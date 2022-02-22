package com.caito.invitations.invitationsbe.service.contract;

import com.caito.invitations.invitationsbe.dto.PeopleRequest;
import com.caito.invitations.invitationsbe.dto.PeopleResponse;
import javassist.NotFoundException;

import java.util.List;

public interface PeopleDAO {

    PeopleResponse save(PeopleRequest request);
    List<PeopleResponse> getAll();
    PeopleResponse update(Long id, PeopleRequest request) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
