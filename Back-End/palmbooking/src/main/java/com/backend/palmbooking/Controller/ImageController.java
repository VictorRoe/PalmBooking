package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Image;
import com.backend.palmbooking.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/image")
public class ImageController {

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<Image> getImage() {
        return imageService.getImage();
    }

    @GetMapping("/{id}")
    public Optional<Image> getImageByID(@PathVariable Long id){
        return imageService.getImageByID(id);
    }

    @PostMapping
    public void addImage(@RequestBody Image image){
        imageService.addImage(image);
    }

    @PutMapping
    public ResponseEntity<Void> editImage(@RequestBody Image image) {
        Optional<Image> searchImage = imageService.getImageByID(image.getId());

        if (searchImage.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        imageService.editImage(image);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageByID(@PathVariable Long id) {
        Optional<Image> searchImage = imageService.getImageByID(id);

        if (searchImage.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        imageService.deleteImageByID(id);
        return ResponseEntity.status(204).build();
    }
}
