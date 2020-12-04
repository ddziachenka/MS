package com.epam.yoke.attender.model.rq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "Body for create attender")
public class AttenderBody {

    @NotNull(message = "Name is mandatory")
    @ApiModelProperty(required = true, value = "Requested name")
    private String name;

    @NotNull(message = "Email is mandatory")
    @ApiModelProperty(required = true, value = "Requested locationId")
    private String email;
}
