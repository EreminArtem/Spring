package ru.eremin.spring.commercial.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(description, company.description) &&
                Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, address);
    }
}
