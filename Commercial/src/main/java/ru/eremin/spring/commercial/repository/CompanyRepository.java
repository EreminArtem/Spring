package ru.eremin.spring.commercial.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.eremin.spring.commercial.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> findAll() {
        return entityManager.createQuery("SELECT e FROM Company e", Company.class).getResultList();
    }

    public void insert(final Company company) {
        if (company != null) entityManager.persist(company);
    }

    public Company findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return entityManager.find(Company.class, id);
    }

    public void update(final Company company) {
        if (company == null) entityManager.merge(company);
    }

    public void delete(final String id) {
        if (id == null || id.isEmpty()) return;
        final Company company = entityManager.find(Company.class, id);
        if (company != null) entityManager.remove(company);
    }
}
