package com.ar.session.Aang.controllers;

import com.ar.session.Aang.domain.BenderPayload;
import com.ar.session.Aang.domain.CharacterPayload;
import com.ar.session.Aang.exception.EnableException;
import com.ar.session.Aang.exception.NotFoundException;
import com.ar.session.Aang.models.Bender;
import com.ar.session.Aang.service.BenderService;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/api/avatar")
@Validated
public class OperationController {

    private static final Logger LOG = getLogger(OperationController.class);

    private final BenderService benderService;

    public OperationController(BenderService benderService){
        this.benderService = benderService;
    }

    @GetMapping("/")
    public String hello(Authentication authentication) {
        return "Hello, " + authentication.getName() + "!";
    }

    @PostMapping("/createbender")
    @ResponseStatus(HttpStatus.CREATED)
    public Bender createPerson(Authentication authentication, @Valid @RequestBody CharacterPayload character){
        LOG.info("Creating character with nation: {}, authorized by: {}", character.getNation(), authentication.getName());
        return benderService.createCharacter(character);
    }

    @PutMapping("/updatebender")
    @ResponseStatus(HttpStatus.OK)
    public Bender updateBender(Authentication authentication, @Valid @RequestBody BenderPayload benderPayload) throws EnableException, NotFoundException {
        LOG.info("Updating data from bender id: {}", benderPayload.getId());

        return this.benderService.updateBender(benderPayload);
    }

    @DeleteMapping("/deletebender/{id}")
    public void deleteBender(Authentication authentication, @PathVariable Integer id) throws NotFoundException, EnableException {
        LOG.info("Deleting bender by id: {}", id);
        this.benderService.deleteBender(id);
    }

    @GetMapping("/getall")
    public Page<Bender> getAll(Authentication authentication){
        LOG.info("Getting all bender");
        return this.benderService.lookAllBender();
    }
}
