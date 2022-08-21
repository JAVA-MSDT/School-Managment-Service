package com.bebestlang.bebest.dto.training;

import java.util.Map;

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

    @ApiModelProperty(value = "Subject description", example = "\"description\": {\n" +
            "\"EN\": \"English Description\",\n" +
            "\"PL\": \"Polish Description\"\n" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the description in that language ")
    private Map<String, String> description;
}
