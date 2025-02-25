package com.school.management.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Address Dto Object")
public class AddressDto {

    @ApiModelProperty(value = "Address Id", example = "UUID4")
    private Long id;

    @ApiModelProperty(value = "Address Country", example = "Egypt")
    @NotBlank(message = "Country is required & can't be Null or empty")
    private String country;

    @ApiModelProperty(value = "Address provenance", example = "South sinai")
    private String provenance;

    @ApiModelProperty(value = "Address City", example = "Sharm El-Sheikh")
    @NotBlank(message = "City is required & can't be Null or empty")
    private String city;

    @ApiModelProperty(value = "Address street", example = "Red Sea Street")
    private String street;

    @ApiModelProperty(value = "Address Building", example = "4")
    private String building;

    @ApiModelProperty(value = "Address Apartment", example = "8C")
    private String apartment;

    @ApiModelProperty(value = "Address Postal Zipcode", example = "4444")
    private String zipCode;

}
