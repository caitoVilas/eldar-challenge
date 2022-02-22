package com.caito.invitations.invitationsbe.controller;

import com.caito.invitations.invitationsbe.constant.SwaggerConstants;
import com.caito.invitations.invitationsbe.dto.PeopleRequest;
import com.caito.invitations.invitationsbe.dto.PeopleResponse;
import com.caito.invitations.invitationsbe.service.impl.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eldar/people")
@CrossOrigin
@Api
public class PeopleController {

    @Autowired
    private PeopleService service;

    @PostMapping
    @ApiOperation(value = SwaggerConstants.SWG_CTR_SAVE)
    @ApiResponses({
            @ApiResponse(code = 201, message = "author created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PeopleResponse> save(@RequestBody PeopleRequest request){

        return new ResponseEntity<PeopleResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = SwaggerConstants.SWG_CTR_GETALL)
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<PeopleResponse>> getAll(){

        return new ResponseEntity<List<PeopleResponse>>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = SwaggerConstants.SWG_CTR_UPDATE)
    @ApiResponses({
            @ApiResponse(code = 404, message = "person no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PeopleResponse> update(@PathVariable Long id, @RequestBody PeopleRequest request)
            throws NotFoundException {

        return new ResponseEntity<PeopleResponse>(service.update(id, request), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = SwaggerConstants.SWG_CTR_DELETE)
    @ApiResponses({
            @ApiResponse(code = 404, message = "person no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
