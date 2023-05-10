package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Image;
import com.backend.palmbooking.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getImage() {
        return imageRepository.findAll();
    }

    public Optional<Image> getImageByID(Long id) {
        return imageRepository.findById(id);
    }

    public void addImage(Image image) {
        imageRepository.save(image);
    }

    public Image editImage(Image image) {
        Optional<Image> editImage = imageRepository.findById(image.getId());

        if (editImage.isPresent()) {
            return imageRepository.save(image);
        } else {
            System.out.println("No se encontro el producto");
        }
        return image;
    }

    public void deleteImageByID(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            imageRepository.deleteById(id);
        }
    }
}
