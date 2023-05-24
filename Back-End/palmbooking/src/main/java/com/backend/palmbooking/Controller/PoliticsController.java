package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalException;
import com.backend.palmbooking.Model.Politics;
import com.backend.palmbooking.Service.PoliticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Policy")
public class PoliticsController {

    @Autowired
    private PoliticsService politicsService;

    @GetMapping
    public List<Politics> getPolitics() {
        return politicsService.getPolicy();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Politics> getPoliticsByID(@PathVariable Long id) throws GlobalException {
        Politics politics = politicsService.getPolicyID(id);
        if (politics == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(politics);
        }
    }

    @PostMapping
    public void addPolitics(@RequestBody Politics politics) {
        politicsService.addPolicy(politics);
    }

    @PutMapping
    public ResponseEntity<Politics> editPolitics(@RequestBody Politics politics) throws GlobalException {
        Politics searchPolitics = politicsService.getPolicyID(politics.getId());
        if (searchPolitics == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(politicsService.editPolicy(politics));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoliticsByID(@PathVariable Long id) throws GlobalException {
        Politics searchPolitics = politicsService.getPolicyID(id);
        if (searchPolitics == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        politicsService.deletePolicyByID(id);
        return ResponseEntity.noContent().build();
    }
}
