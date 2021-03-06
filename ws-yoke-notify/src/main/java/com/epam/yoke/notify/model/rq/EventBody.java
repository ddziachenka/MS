package com.epam.yoke.notify.model.rq;

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
@ApiModel(description = "Body for create event")
public class EventBody {

    @NotNull(message = "EventId is mandatory")
    @ApiModelProperty(required = true, value = "Requested eventId")
    private String eventId;

    @ApiModelProperty(value = "Requested event description")
    private String description;
}
