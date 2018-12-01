package ru.eremin.spring.guns;

public interface Magazine {

    void bulletDecrement();

    void setCapacity(int capacity);

    int getCapacity();
}
