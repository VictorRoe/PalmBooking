package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalException;
import com.backend.palmbooking.Model.Characteristic;
import com.backend.palmbooking.Service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/characteristic")
public class CharacteristicController {

    @Autowired
    private CharacteristicService characteristicService;

    @GetMapping
    public List<Characteristic> getProduct() {
        return characteristicService.getCharacteristic();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Characteristic> getCharacteristicByID(@PathVariable Long id) throws GlobalException {
        Characteristic characteristic = characteristicService.getCharacteristicByID(id);
        if (characteristic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(characteristic);
        }
    }

    @PostMapping
    public void addCharacteristic(@RequestBody Characteristic characteristic) {
        characteristicService.addCharacteristic(characteristic);
    }

    @PutMapping
    public ResponseEntity<Characteristic> editCharacteristic(@RequestBody Characteristic characteristic) throws GlobalException {
        Characteristic searchCharacteristic = characteristicService.getCharacteristicByID(characteristic.getId());
        if (searchCharacteristic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(characteristicService.editCharacteristic(characteristic));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacteristicByID(@PathVariable Long id) throws GlobalException {
        Characteristic searchCharacteristic = characteristicService.getCharacteristicByID(id);
        if (searchCharacteristic == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        characteristicService.deleteCharacteristicByID(id);
        return ResponseEntity.noContent().build();
    }
}
