/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisCitas.exception;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class StandarizedApiExceptionResponse {

    @ApiModelProperty(notes = "The unique uri identifier that categorizes the error", name = "type", required = true, example = "/errors/authentication/not-authorized")
    private String type = "/errors/uncategorized";

    @ApiModelProperty(notes = "A brief, human-readable message about the error", name = "title", required = true, example = "The user does not have autorization")
    private String title;

    @ApiModelProperty(notes = "The unique error code", name = "code", required = false, example = "192")
    private String code;

    @ApiModelProperty(notes = "A human-readable explanation of the error", name = "detail", required = true, example = "The user does not have the propertly persmissions to acces the " + "resource, please contact with ass https://digitalthinking.biz/es/ada-enterprise-core#contactus")
    private String detail;

    @ApiModelProperty(notes = "A URI that identifies the specific occurrence of the error", name = "detail", required = true, example = "/errors/authentication/not-authorized/01")
    private String instance = "/errors/uncategorized/bank";
}
