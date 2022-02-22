package com.caito.invitations.invitationsbe.dto;

import com.caito.invitations.invitationsbe.constant.SwaggerConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel(description = SwaggerConstants.SWG_RQT_MODEL)
public class PeopleRequest {

    @ApiModelProperty(name = "name", required = true, example = "name")
    private String name;
    @ApiModelProperty(name = "surname", required = true, example = "surname")
    private String surname;
    @ApiModelProperty(name = "dateOfBird", example = "YYYY-MM-DD")
    private LocalDate dateOfBird;
    @ApiModelProperty(name = "dni", required = true, example = "11111111")
    private String dni;
}
