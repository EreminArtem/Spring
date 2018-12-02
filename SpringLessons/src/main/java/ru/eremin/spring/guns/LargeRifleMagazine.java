package ru.eremin.spring.guns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("large_rifle_magazine")
public class LargeRifleMagazine implements Magazine {

    @Value("11")
    private int capacity;

    @Override
    public void bulletDecrement() {
        this.capacity--;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}
