package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Politics;
import com.backend.palmbooking.Repository.PoliticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliticsService {

    @Autowired
    private PoliticsRepository politicsRepository;

    public List<Politics> getPolicy() {
        return politicsRepository.findAll();
    }

    public Optional<Politics> getPolicyByID(Long id) {
        return politicsRepository.findById(id);
    }

    public void addPolicy(Politics politics) {
        politicsRepository.save(politics);
    }

    public Politics editPolicy(Politics politics) {
        Optional<Politics> editPolicy = politicsRepository.findById(politics.getId());

        if (editPolicy.isPresent()) {
            return politicsRepository.save(politics);
        } else {
            System.out.println("No se encontro el producto");
        }
        return politics;
    }

    public void deletePolicyByID(Long id) {
        Optional<Politics> politics = politicsRepository.findById(id);
        if (politics.isPresent()) {
            politicsRepository.deleteById(id);
        }
    }
}
