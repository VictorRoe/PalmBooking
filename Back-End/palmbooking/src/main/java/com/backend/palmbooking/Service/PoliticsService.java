package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalException;
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

    public Politics getPolicyID(Long id) throws GlobalException {
        Optional<Politics> searchPolicy = politicsRepository.findById(id);
        if (searchPolicy.isPresent()){
            return searchPolicy.get();
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }

    public void addPolicy(Politics politics) {
        politicsRepository.save(politics);
    }

    public Politics editPolicy(Politics politics) throws GlobalException {
        Optional<Politics> editPolicy = politicsRepository.findById(politics.getId());
        if (editPolicy.isPresent()) {
            return politicsRepository.save(politics);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }

    }

    public void deletePolicyByID(Long id) throws GlobalException {
        Optional<Politics> politics = politicsRepository.findById(id);
        if (politics.isPresent()) {
            politicsRepository.deleteById(id);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }

    //    GET (policy by product ID)

    public List<Politics> getPoliticsByProductID(Long id){
        return politicsRepository.findPoliticsByProductID(id);
    }
}
