package com.ar.session.Aang.repository;

import com.ar.session.Aang.models.Bender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenderRepository extends JpaRepository<Bender, Integer> {
}
