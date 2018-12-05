package ru.eremin.spring.guns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.eremin.spring.guns.annotations.UnproducableMagazine;

@UnproducableMagazine(usingMagazine = LargeRifleMagazine.class)
@Component("rifle_magazine")
public class RifleMagazine implements Magazine {

    @Value("7")
    private int capacity;

    public void bulletDecrement() {
        this.capacity--;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
