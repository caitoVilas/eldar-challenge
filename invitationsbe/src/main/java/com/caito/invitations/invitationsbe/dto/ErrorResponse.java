package com.caito.invitations.invitationsbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {

    private Integer status;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}
