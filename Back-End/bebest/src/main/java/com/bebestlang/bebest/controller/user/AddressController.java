package com.bebestlang.bebest.controller.user;

import com.bebestlang.bebest.dto.user.AddressDto;
import com.bebestlang.bebest.service.user.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/addresses")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{id}")
    public Mono<AddressDto> findAddressById(@PathVariable("id") String id) {
        return addressService.findAddressById(id);
    }

    @GetMapping
    public Flux<AddressDto> findAllAddressDto() {
        return addressService.findAllAddress();
    }

    @PostMapping
    public Mono<AddressDto> saveAddress(@RequestBody AddressDto addressDto) {
        return addressService.saveAddress(addressDto);
    }

    @PutMapping("/{id}")
    public Mono<AddressDto> updateAddressDto(@RequestBody AddressDto addressDto, @PathVariable("id") String id) {
        return addressService.updateAddress(addressDto, id);
    }
}
