package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalException;
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

    public Image getImageByID(Long id) throws GlobalException {
        Optional<Image> searchImage = imageRepository.findById(id);
        if (searchImage.isPresent()){
            return searchImage.get();
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }

    public void addImage(Image image) {
        imageRepository.save(image);
    }

    public Image editImage(Image image) throws GlobalException {
        Optional<Image> editImage = imageRepository.findById(image.getId());
        if (editImage.isPresent()) {
            return imageRepository.save(image);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }

    }

    public void deleteImageByID(Long id) throws GlobalException {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            imageRepository.deleteById(id);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }

//    GET Images by ProductID

    public List<Image> findImagesByProductID(Long id){
        return imageRepository.findImagesByProductID(id);
    }
}
