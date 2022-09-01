package com.bebestlang.bebest.mapper.common;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.dto.common.PublicInfoDto;
import com.bebestlang.bebest.modal.common.Image;
import com.bebestlang.bebest.modal.common.PublicInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    Image toImage(ImageDto imageDto);

    ImageDto toImageDto(Image image);
}
