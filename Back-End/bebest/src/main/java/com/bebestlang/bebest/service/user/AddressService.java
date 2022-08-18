package com.bebestlang.bebest.service.user;

import com.bebestlang.bebest.repository.user.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
}
