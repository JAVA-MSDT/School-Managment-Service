package com.bebestlang.bebest.mapper.user;

import com.bebestlang.bebest.dto.user.AddressDto;
import com.bebestlang.bebest.modal.user.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressDto addressDto);

    AddressDto toAddressDto(Address address);
}
