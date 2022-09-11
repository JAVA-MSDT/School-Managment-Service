package com.bebestlang.bebest.modal.common;

import java.util.Set;

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
@Document(collection = "image")
public class Image {

    @Id
    private String id;

    private String title;

    private String alt;

    private String url;

    private byte[] image;

    private FileStatus fileStatus;

    private Set<PurposeOfUse> purposeOfUses;

    private Set<Integer> placesOfUsed;

}
