package com.bebestlang.bebest.mapper.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.modal.common.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    Image toImage(ImageDto imageDto);

    // @Mapping(target = "url", source = "image", qualifiedByName = "byteToUrl")
    ImageDto toImageDto(Image image);

    @Named(value = "byteToUrl")
    default String byteToUrl(byte[] image) {
        String path = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(image);
            BufferedImage bufferedImage = ImageIO.read(bis);
            ImageIO.write(bufferedImage, "jpg", new File("./images" + "/" + "Login1.jpg"));
            path = Paths.get("./images/Login1.jpg").toAbsolutePath().normalize().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
