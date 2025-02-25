package com.bebestlang.bebest.modal.common;

import java.util.Map;

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
@Document(collection = "public_info")
public class PublicInfo {

    @Id
    private String id;

    private Map<String, String> aboutUsIntro;
}
