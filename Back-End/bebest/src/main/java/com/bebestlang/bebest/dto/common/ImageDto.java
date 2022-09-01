package com.bebestlang.bebest.dto.common;

import java.util.Set;

import com.bebestlang.bebest.modal.common.FileStatus;
import com.bebestlang.bebest.modal.common.PurposeOfUse;
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
@ApiModel(description = "Image Dto object")
public class ImageDto {

    @ApiModelProperty(value = "Image id", example = "UUID4")
    private String id;

    @ApiModelProperty(value = "Image title", example = "mountain")
    private String title;

    @ApiModelProperty(value = "Image alt", example = "Mountain of Everest")
    private String alt;

    @ApiModelProperty(value = "Image url", example = "local/mountain.jpg")
    private String url;

    @ApiModelProperty(value = "Image binary", example = "Image object")
    private byte[] image;

    @ApiModelProperty(value = "Image status", example = "PRIVATE or PUBLIC")
    private FileStatus fileStatus;

    @ApiModelProperty(value = "Image Purpose Of Use", example = "BANNER, CAROUSEL, GALLERY or ALBUM")
    private Set<PurposeOfUse> purposeOfUses;

    @ApiModelProperty(value = "Image Place of used", example = "[number of folder used to retrieve images belong to specific group]")
    private Set<Integer> placesOfUsed;

}
