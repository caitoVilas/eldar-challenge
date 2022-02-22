package com.caito.invitations.invitationsbe.service.impl;

import com.caito.invitations.invitationsbe.constant.ErrorsConstants;
import com.caito.invitations.invitationsbe.dto.PeopleRequest;
import com.caito.invitations.invitationsbe.dto.PeopleResponse;
import com.caito.invitations.invitationsbe.entity.People;
import com.caito.invitations.invitationsbe.exceptions.custom.BadRequestException;
import com.caito.invitations.invitationsbe.mapper.PeopleRequestMapper;
import com.caito.invitations.invitationsbe.mapper.PeopleResponseMapper;
import com.caito.invitations.invitationsbe.repository.PeopleRepository;
import com.caito.invitations.invitationsbe.service.contract.PeopleDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService implements PeopleDAO {

    @Autowired
    private PeopleRepository repository;
    @Autowired
    private PeopleRequestMapper requestMapper;
    @Autowired
    private PeopleResponseMapper responseMapper;


    @Override
    @Transactional
    public PeopleResponse save(PeopleRequest request) {

        if (request.getName() == null || request.getName().isEmpty())
            throw new BadRequestException(ErrorsConstants.ERR_NAME_REQUIRED);
        if (request.getSurname() == null || request.getSurname().isEmpty())
            throw new BadRequestException(ErrorsConstants.ERR_SURNAME_REQUIRED);
        if (request.getDni() == null || request.getDni().isEmpty())
            throw new BadRequestException(ErrorsConstants.ERR_DNI_REQUIRED);
        if (repository.existsByDni(request.getDni()))
            throw new BadRequestException(ErrorsConstants.ERR_DNI_EXIST + request.getDni());

         People people = repository.save(requestMapper.requestToPeople(request));
        return responseMapper.peopleToResponse(people);
    }



    @Override
    @Transactional(readOnly = true)
    public List<PeopleResponse> getAll() {

        List<People> peopleList = repository.findAll();
        return responseMapper.peopleListToResponseList(peopleList);
    }

    @Override
    @Transactional
    public PeopleResponse update(Long id, PeopleRequest request) throws NotFoundException {

        People people = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorsConstants.ERR_ID_NOTFOUND + id));
        if (people.getName() !=  request.getName())
            people.setName(request.getName());
        if (people.getSurname() != request.getSurname())
            people.setSurname(request.getSurname());
        if (people.getDateOfBird() != request.getDateOfBird() )
            people.setDateOfBird(request.getDateOfBird());
        if (!people.getDni().equals(request.getDni()) ){
            if (repository.existsByDni(request.getDni()))
                throw new BadRequestException(ErrorsConstants.ERR_DNI_EXIST + request.getDni());
            people.setDni(request.getDni());
        }
        repository.save(people);
        return responseMapper.peopleToResponse(people);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {

        People people = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorsConstants.ERR_ID_NOTFOUND + id));
        repository.deleteById(id);
    }
}
