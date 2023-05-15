package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Characteristic;
import com.backend.palmbooking.Service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/characteristic")
public class CharacteristicController {

    @Autowired
    private CharacteristicService characteristicService;

    @GetMapping
    public List<Characteristic> getCharacteristic() {
        return characteristicService.getCharacteristic();
    }

    @GetMapping("/{id}")
    public Optional<Characteristic> getCharacteristicByID(@PathVariable Long id) {
        return characteristicService.getCharacteristicByID(id);
    }

    @PostMapping
    public void addCharacteristic(@RequestBody Characteristic characteristic) {
        characteristicService.addCharacteristic(characteristic);
    }

    @PutMapping
    public ResponseEntity<Void> editCharacteristic(@RequestBody Characteristic characteristic) {
        Optional<Characteristic> searchCharacteristic = characteristicService.getCharacteristicByID(characteristic.getId());

        if (searchCharacteristic.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        characteristicService.editCharacteristic(characteristic);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacteristicByID(@PathVariable Long id) {
        Optional<Characteristic> searchCharacteristic = characteristicService.getCharacteristicByID(id);

        if (searchCharacteristic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        characteristicService.deleteCharacteristicByID(id);
        return ResponseEntity.status(204).build();
    }
}
