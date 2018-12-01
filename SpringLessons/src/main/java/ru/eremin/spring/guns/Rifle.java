package ru.eremin.spring.guns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rifle")
public class Rifle implements Gun {

    @Autowired
    @Qualifier("rifle_magazine")
    private Magazine magazine;

    @Override
    public void shoot(){
        this.magazine.bulletDecrement();
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
}
