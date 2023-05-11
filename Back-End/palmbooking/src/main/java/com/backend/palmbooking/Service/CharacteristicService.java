package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Characteristic;
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

    public Optional<Characteristic> getCharacteristicByID(Long id) {
        return characteristicRepository.findById(id);
    }

    public void addCharacteristic(Characteristic characteristic) {
        characteristicRepository.save(characteristic);
    }

    public Characteristic editCharacteristic(Characteristic characteristic) {
        Optional<Characteristic> editCharacteristic = characteristicRepository.findById(characteristic.getId());

        if (editCharacteristic.isPresent()) {
            return characteristicRepository.save(characteristic);
        } else {
            System.out.println("No se encontro una id para editar");
        }
        return characteristic;
    }

    public void deleteCharacteristicByID(Long id) {
        Optional<Characteristic> characteristic = characteristicRepository.findById(id);
        if (characteristic.isPresent()) {
            characteristicRepository.deleteById(id);
        }
    }
}
