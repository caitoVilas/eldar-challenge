package com.caito.invitations.invitationsbe.exceptions.custom;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){

        super(error);
    }
}
