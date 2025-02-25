package com.bebestlang.bebest.mapper.common;

import com.bebestlang.bebest.dto.common.PublicInfoDto;
import com.bebestlang.bebest.modal.common.PublicInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicInfoMapper {

    PublicInfo toPublicInfo(PublicInfoDto publicInfoDto);

    PublicInfoDto toPublicInfoDto(PublicInfo publicInfo);
}
