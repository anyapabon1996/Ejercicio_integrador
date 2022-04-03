package com.ar.session.Aang.service;

import com.ar.session.Aang.domain.BenderPayload;
import com.ar.session.Aang.domain.Bending;
import com.ar.session.Aang.domain.CharacterPayload;
import com.ar.session.Aang.exception.EnableException;
import com.ar.session.Aang.exception.NotFoundException;
import com.ar.session.Aang.models.Bender;
import com.ar.session.Aang.repository.BenderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BenderService {

    private final BenderRepository benderRepository;

    private final boolean goDown = false;

    public BenderService(BenderRepository benderRepository){
        this.benderRepository = benderRepository;
    }

    private final String water = "water";
    private final String fire = "fire";
    private final String air = "air";
    private final String earth = "earth";

    @Transactional
    public Bender createCharacter(CharacterPayload characterPayload){
        Bender bender  = new Bender();
        bender.setDayBorn(characterPayload.getDayBorn());
        bender.setName(characterPayload.getName());
        bender.setNation(characterPayload.getNation());
        bender.setLevelRandomAndEnable();

        if(characterPayload.getNation().toLowerCase().contains(water)) {
            bender.setPower(Bending.WATER_BENDER.name());
        } else if(characterPayload.getNation().toLowerCase().contains(fire)) {
            bender.setPower(Bending.FIRE_BENDER.name());
        } else if (characterPayload.getNation().toLowerCase().contains(air)) {
            bender.setPower(Bending.AIR_BENDER.name());
        } else if  (characterPayload.getNation().toLowerCase().contains(earth)) {
            bender.setPower(Bending.EARTH_BENDER.name());
        } else bender.setPower(Bending.NON_BENDER.name());

        return this.benderRepository.saveAndFlush(bender);
    }

    @Transactional
    public Bender updateBender(BenderPayload benderPayload) throws NotFoundException, EnableException {
        Bender bender = this.benderRepository.findById(benderPayload.getId())
                            .orElseThrow(() -> new NotFoundException("Error looking this source"));

        if (!bender.isEnable()) {
             throw new EnableException("This bender is not enable");
        }

        if (benderPayload.getName() != "") {
            bender.setName(benderPayload.getName());
        }
        bender.setLevel(benderPayload.getLevel());
        if (benderPayload.getDeadDay() != null) {
            bender.unablePower(benderPayload.getDeadDay());
        }

        return this.benderRepository.saveAndFlush(bender);
    }

    @Transactional
    public void deleteBender(Integer id) throws NotFoundException, EnableException {
        Bender bender = this.benderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Error looking this source"));

        if (!bender.isEnable()) {
            throw new EnableException("This bender is not enable");
        }

        bender.setEnable(goDown);

        this.benderRepository.saveAndFlush(bender);
    }

    public Page<Bender> lookAllBender(){
        return this.benderRepository.findAll(Pageable.ofSize(1));
    }

}