package ru.eremin.spring.commercial.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "company_table")
public class Company {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "company_name", nullable = false)
    private String name;

    @Column(name = "company_description")
    private String description;

    @Column(name = "company_address")
    private String address;
}
