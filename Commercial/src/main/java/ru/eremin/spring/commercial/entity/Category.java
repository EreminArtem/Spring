package ru.eremin.spring.commercial.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@Table(name = "category_name")
public class Category {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "category_name", nullable = false, unique = true)
    private String name;
}
