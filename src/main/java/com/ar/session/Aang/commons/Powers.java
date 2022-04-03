package com.ar.session.Aang.commons;

import com.ar.session.Aang.domain.CharacterPayload;
import com.ar.session.Aang.models.Bender;

import java.time.LocalDate;

public interface Powers <T>{

    void setLevelRandomAndEnable();

    void unablePower(LocalDate date);
}
