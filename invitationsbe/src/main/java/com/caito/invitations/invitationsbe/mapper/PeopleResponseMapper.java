package com.caito.invitations.invitationsbe.mapper;

import com.caito.invitations.invitationsbe.dto.PeopleResponse;
import com.caito.invitations.invitationsbe.entity.People;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeopleResponseMapper {

    PeopleResponse peopleToResponse(People people);
    List<PeopleResponse> peopleListToResponseList(List<People> peopleList);
}
