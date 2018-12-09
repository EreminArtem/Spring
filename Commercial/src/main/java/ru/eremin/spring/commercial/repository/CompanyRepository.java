package ru.eremin.spring.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eremin.spring.commercial.entity.Company;

import java.util.List;

@Repository(CompanyRepository.NAME)
public interface CompanyRepository extends JpaRepository<Company, String> {

    public static final String NAME = "companyRepository";

    Company findCompaniesById(String id);

    List<Company> findAll();

    Company findCompaniesByName(String name);

}
