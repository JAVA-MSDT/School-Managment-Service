package com.bebestlang.bebest.dto.subject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Subject Dto object")
public class SubjectDto {

    @ApiModelProperty(value = "Subject id", example = "UUID4")
    private String id;

    @ApiModelProperty(value = "Subject", example = "Arabic, Polish, English, etc")
    private String subject;

    @ApiModelProperty(value = "Subject description", example = "Arabic is a language mostly spoken in Middle East, but not only,,,,,")
    private String description;
}
