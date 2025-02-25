package com.bebestlang.bebest.dto.training;

import java.util.Map;
import java.util.Set;

import com.bebestlang.bebest.modal.common.SimpleImage;
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

    @ApiModelProperty(value = "Subject description", example = "description: {" +
            "EN: English Description," +
            "PL: Polish Description" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the description in that language ")
    private Map<String, String> description;

    @ApiModelProperty(value = "Subject Additional Info", example = "additionalInfo: {" +
            "Info One: Your needed Info," +
            "Info Two: Your needed Info" +
            "}",
            notes = "Map object, Key is the the extra info shortcut & Value is the extra info in that language ")
    private Map<String, String> additionalInfo;

    @ApiModelProperty(value = "Subject Simple Image", example = "[SimpleImageOne, SimpleImageTwo]",
            notes = "optional to add background and profile image for the subject ")
    private Set<SimpleImage> simpleImages;
}
