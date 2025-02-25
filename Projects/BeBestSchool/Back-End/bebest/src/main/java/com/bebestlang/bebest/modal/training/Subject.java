package com.bebestlang.bebest.modal.training;

import java.util.Map;
import java.util.Set;

import com.bebestlang.bebest.modal.common.SimpleImage;
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
@Document(collection = "subject")
public class Subject {

    @Id
    private String id;

    private String subject;

    private Map<String, String> description;

    private Map<String, String> additionalInfo;

    private Set<SimpleImage> simpleImages;

}
