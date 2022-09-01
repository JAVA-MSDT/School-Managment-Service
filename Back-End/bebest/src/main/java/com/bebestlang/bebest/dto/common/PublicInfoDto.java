package com.bebestlang.bebest.dto.common;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Public Info Dto object")
public class PublicInfoDto {

    @ApiModelProperty(value = "Public Info id", example = "UUID4")
    private String id;

    @ApiModelProperty(value = "Public Info Dto About Us Intro", example = "\"aboutUsIntro\": {\n" +
            "\"EN\": \"English About Us Intro\",\n" +
            "\"PL\": \"Polish About Us Intro\"\n" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the About Us Intro in that language ")
    private Map<String, String> aboutUsIntro;
}
