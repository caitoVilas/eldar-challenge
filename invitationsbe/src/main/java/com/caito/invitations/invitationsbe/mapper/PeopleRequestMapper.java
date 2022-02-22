package com.caito.invitations.invitationsbe.mapper;

import com.caito.invitations.invitationsbe.dto.PeopleRequest;
import com.caito.invitations.invitationsbe.entity.People;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeopleRequestMapper {

    People requestToPeople(PeopleRequest request);
    List<People> requestListToPeopleList(List<PeopleRequest> peopleRequests);
}
