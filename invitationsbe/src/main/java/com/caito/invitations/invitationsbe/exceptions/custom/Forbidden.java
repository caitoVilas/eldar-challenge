package com.caito.invitations.invitationsbe.exceptions.custom;

public class Forbidden extends RuntimeException{

    public Forbidden(String error){

        super(error);
    }
}
