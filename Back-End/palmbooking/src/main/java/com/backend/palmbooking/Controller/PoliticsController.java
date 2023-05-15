package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.Politics;
import com.backend.palmbooking.Service.PoliticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Policy")
public class PoliticsController {

    @Autowired
    private PoliticsService politicsService;

    @GetMapping
    public List<Politics> getPolicy() {
        return politicsService.getPolicy();
    }

    @GetMapping("/{id}")
    public Optional<Politics> getPolicyByID(@PathVariable Long id){
        return politicsService.getPolicyByID(id);
    }

    @PostMapping
    public void addPolicy(@RequestBody Politics politics){
        politicsService.addPolicy(politics);
    }

    @PutMapping
    public ResponseEntity<Void> editPolicy(@RequestBody Politics politics) {
        Optional<Politics> searchPolicy = politicsService.getPolicyByID(politics.getId());

        if (searchPolicy.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        politicsService.editPolicy(politics);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicyByID(@PathVariable Long id) {
        Optional<Politics> searchPolicy = politicsService.getPolicyByID(id);

        if (searchPolicy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        politicsService.deletePolicyByID(id);
        return ResponseEntity.status(204).build();
    }
}
