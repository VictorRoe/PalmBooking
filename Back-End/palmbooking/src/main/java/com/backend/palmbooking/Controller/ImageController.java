package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.Image;
import com.backend.palmbooking.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Image> getImageByID(@PathVariable Long id) throws GlobalExcepction {
        Image image = imageService.getImageByID(id);
        if (image == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(image);
        }
    }

    @PostMapping
    public void addImage(@RequestBody Image image) {
        imageService.addImage(image);
    }

    @PutMapping
    public ResponseEntity<Image> editImage(@RequestBody Image image) throws GlobalExcepction {
        Image searchImage = imageService.getImageByID(image.getId());
        if (searchImage == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(searchImage);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageByID(@PathVariable Long id) throws GlobalExcepction {
        Image searchImage = imageService.getImageByID(id);
        if (searchImage == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        imageService.deleteImageByID(id);
        return ResponseEntity.noContent().build();
    }
}
