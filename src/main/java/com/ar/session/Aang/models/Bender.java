package com.ar.session.Aang.models;

import com.ar.session.Aang.commons.Powers;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Table(name = "Benders")
@Entity
public class Bender implements Powers<Bender> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "nation")
    private String nation;

    @Column(name = "level")
    private Integer level;

    @Column(name = "dayBorn")
    private LocalDate dayBorn;

    @Column(name = "deadDay")
    private LocalDate deadDay;

    @Column(name = "enable")
    private boolean enable;

    @Column(name = "bending")
    private String power;

    public Bender(Integer id, String name, String nation, LocalDate dayBorn) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.dayBorn = dayBorn;
        this.enable = true;
    }

    public Bender() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public LocalDate getDayBorn() {
        return dayBorn;
    }

    public void setDayBorn(LocalDate dayBorn) {
        this.dayBorn = dayBorn;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public LocalDate getDeadDay() {
        return deadDay;
    }

    public void setDeadDay(LocalDate deadDay) {
        this.deadDay = deadDay;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public void setLevelRandomAndEnable(){
        Random random = new Random();
        this.level = random.nextInt(10+1)+1;
        this.enable = true;
    }

    @Override
    public void unablePower(LocalDate date){
        this.deadDay = date;
        this.enable = false;
    }

    @Override
    public String toString() {
        return "Bender{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", level=" + level +
                ", dayBorn=" + dayBorn +
                ", deadDay=" + deadDay +
                ", enable=" + enable +
                ", bending='" + power + '\'' +
                '}';
    }
}
