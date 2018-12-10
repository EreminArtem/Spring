package ru.eremin.spring.commercial.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(id, ad.id) &&
                Objects.equals(name, ad.name) &&
                Objects.equals(adText, ad.adText) &&
                Objects.equals(phoneNumber, ad.phoneNumber) &&
                Objects.equals(category, ad.category) &&
                Objects.equals(company, ad.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adText, phoneNumber, category, company);
    }
}
