package com.bebestlang.bebest.dto.common;

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
@ApiModel(description = "Public Info Dto object")
public class PublicInfoDto {

    @ApiModelProperty(value = "Public Info id", example = "UUID4")
    private String id;

    @ApiModelProperty(value = "Public Info Dto About Us Intro", example = "aboutUsIntro: {" +
            "EN: \"English About Us Intro\"," +
            "PL: \"Polish About Us Intro\"" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the About Us Intro in that language ")
    private Map<String, String> aboutUsIntro;
}
