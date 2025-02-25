package com.school.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.management.modal.common.FileStatus;
import com.school.management.modal.common.PurposeOfUse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Image Dto object")
public class ImageDto {

    @ApiModelProperty(value = "Image id", example = "UUID4")
    private Long id;

    @ApiModelProperty(value = "Image title", example = "mountain", notes = "Will be used for rename image")
    @JsonIgnore
    private String title;

    @ApiModelProperty(value = "Image alt", example = "alt: {" +
            "EN: English alt," +
            "PL: Polish alt" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the alt in that language ")
    private Map<String, String> alt;

    @ApiModelProperty(value = "Image description", example = "description: {" +
            "EN: English alt," +
            "PL: Polish alt" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the description in that language ")
    private Map<String, String> description;

    @ApiModelProperty(value = "Image extension", example = "JPG, PNG, JPEG,,, ETC")
    private String extension;

    @ApiModelProperty(value = "Image url", example = "local/mountain.jpg")
    private String url;

    @ApiModelProperty(value = "Image in Base64", example = "Image object",
            notes = "You can upload image maxsize is 5MB using file part, " +
                    "than it will be convert it to Base64")
    private String imageBase64;

    @ApiModelProperty(value = "Image status", example = "PRIVATE or PUBLIC")
    private FileStatus fileStatus;

    @ApiModelProperty(value = "Image Purpose Of Use", example = "BANNER, CAROUSEL, GALLERY, ALBUM or UTIL")
    private Set<PurposeOfUse> purposeOfUses;

    @ApiModelProperty(value = "Image Place of used",
            example = "[number of folder used to retrieve images belong to specific group]",
            notes = "Number of items from the purposeOfUses option")
    private Set<Integer> placesOfUsed;

}
