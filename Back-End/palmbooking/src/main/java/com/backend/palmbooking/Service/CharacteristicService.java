package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.Characteristic;
import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Repository.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacteristicService {


    @Autowired
    private CharacteristicRepository characteristicRepository;

    public List<Characteristic> getCharacteristic() {
        return characteristicRepository.findAll();
    }

    public Characteristic getCharacteristicByID(Long id) throws GlobalExcepction {
        Optional<Characteristic> searchCharacteristic = characteristicRepository.findById(id);
        if (searchCharacteristic.isPresent()){
            return searchCharacteristic.get();
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }

    public void addCharacteristic(Characteristic characteristic) {
        characteristicRepository.save(characteristic);
    }

    public Characteristic editCharacteristic(Characteristic characteristic) throws GlobalExcepction {
        Optional<Characteristic> editCharacteristic = characteristicRepository.findById(characteristic.getId());
        if (editCharacteristic.isPresent()) {
            return characteristicRepository.save(characteristic);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }

    }

    public void deleteCharacteristicByID(Long id) throws GlobalExcepction {
        Optional<Characteristic> characteristic = characteristicRepository.findById(id);
        if (characteristic.isPresent()) {
            characteristicRepository.deleteById(id);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }
}
