package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.Location;
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

    public Politics getPolicyID(Long id) throws GlobalExcepction {
        Optional<Politics> searchPolicy = politicsRepository.findById(id);
        if (searchPolicy.isPresent()){
            return searchPolicy.get();
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }

    public void addPolicy(Politics politics) {
        politicsRepository.save(politics);
    }

    public Politics editPolicy(Politics politics) throws GlobalExcepction {
        Optional<Politics> editPolicy = politicsRepository.findById(politics.getId());
        if (editPolicy.isPresent()) {
            return politicsRepository.save(politics);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }

    }

    public void deletePolicyByID(Long id) throws GlobalExcepction {
        Optional<Politics> politics = politicsRepository.findById(id);
        if (politics.isPresent()) {
            politicsRepository.deleteById(id);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }
}
