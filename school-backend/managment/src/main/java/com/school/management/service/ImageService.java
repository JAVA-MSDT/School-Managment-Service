package com.school.management.service;

import java.util.List;

import com.school.management.modal.common.Image;
import com.school.management.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }
}
