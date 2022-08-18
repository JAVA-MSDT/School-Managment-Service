package com.bebestlang.bebest.modal.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
public class Address {

    @Id
    private String id;

    private String country;

    private String provenance;

    private String city;

    private String street;

    private String building;

    private String zipCode;

}
