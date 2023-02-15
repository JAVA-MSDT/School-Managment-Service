package com.school.management.modal.common;

import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "public_info")
@Entity
public class PublicInfo {

    @Id
    private Long id;
    @ElementCollection
    private Map<String, String> aboutUsIntro;
}
