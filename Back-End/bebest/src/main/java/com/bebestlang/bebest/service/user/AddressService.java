package com.bebestlang.bebest.service.user;

import com.bebestlang.bebest.dto.user.AddressDto;
import com.bebestlang.bebest.exception.user.AddressException;
import com.bebestlang.bebest.mapper.user.AddressMapper;
import com.bebestlang.bebest.repository.user.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public Mono<AddressDto> findAddressById(String id) {
        return addressRepository.findById(id).switchIfEmpty(
                        Mono.error(new AddressException(String.format("Address with the id:: %s Not found", id))))
                .map(addressMapper::toAddressDto);
    }

    public Flux<AddressDto> findAllAddress() {
        return addressRepository.findAll().map(addressMapper::toAddressDto);
    }

    public Mono<AddressDto> saveAddress(AddressDto addressDto) {
        return addressRepository.save(addressMapper.toAddress(addressDto))
                .map(addressMapper::toAddressDto);
    }

    public Mono<AddressDto> updateAddress(AddressDto addressDto, String id) {
        return findAddressById(id)
                .flatMap(returnedAddressDto -> this.getValidAddressDto(returnedAddressDto, addressDto))
                .flatMap(this::saveAddress);
    }

    private Mono<AddressDto> getValidAddressDto(AddressDto returnedAddressDto, AddressDto addressDtoToUpdate) {
        if (returnedAddressDto.getId().equals(addressDtoToUpdate.getId())) {
            return Mono.just(addressDtoToUpdate);
        }
        throw new RuntimeException("Address to be Update & Address from DB are different");
    }

}
