package com.bebestlang.bebest.modal.common;

import java.util.Map;
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

    private Map<String, String> alt;

    private Map<String, String> description;

    private String extension;

    private String url;

    private String imageBase64;

    private FileStatus fileStatus;

    private Set<PurposeOfUse> purposeOfUses;

    private Set<Integer> placesOfUsed;

}
