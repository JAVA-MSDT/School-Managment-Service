package com.school.resource.model.image;

import com.school.management.modal.common.FileStatus;
import com.school.management.modal.common.PurposeOfUse;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String extension;
    private String originalName;
    private String contentType;

    @ElementCollection
    private Map<String, String> alt = new HashMap<>();

    @ElementCollection
    private Map<String, String> description = new HashMap<>();
    @Column(name = "url")
    private String url;
    @Enumerated(EnumType.STRING)
    private FileStatus fileStatus;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PurposeOfUse", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private Set<PurposeOfUse> purposeOfUses = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "placesOfUsed", joinColumns = @JoinColumn(name = "id"))
    private Set<Integer> placesOfUsed = new HashSet<>();
    @Lob
    private byte[] image;
}
