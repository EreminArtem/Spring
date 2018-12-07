package ru.eremin.spring.commercial.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ad_table")
public class Ad {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "ad_name", nullable = false)
    private String name;

    @Column(name = "ad_text", nullable = false)
    private String adText;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;
}
