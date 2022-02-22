package com.caito.invitations.invitationsbe.dto;

import com.caito.invitations.invitationsbe.constant.SwaggerConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = SwaggerConstants.SWG_RSP_MODEL)
public class PeopleResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "name", example = "name")
    private String name;
    @ApiModelProperty(name = "surname", example = "surname")
    private String surname;
    @ApiModelProperty(name = "dateOfBird", example = "2001-01-01")
    private String dateOfBird;
    @ApiModelProperty(name = "dni", example = "11111111")
    private String dni;
}
