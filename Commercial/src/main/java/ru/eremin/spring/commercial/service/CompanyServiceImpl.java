package ru.eremin.spring.commercial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eremin.spring.commercial.entity.Company;
import ru.eremin.spring.commercial.repository.CompanyRepository;

import java.util.List;

@Service(CompanyServiceImpl.NAME)
public class CompanyServiceImpl implements CompanyService {

    public static final String NAME = "companyServiceImpl";

    @Autowired
    @Qualifier(CompanyRepository.NAME)
    private CompanyRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll(final int page, final int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public Company findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return repository.findCompaniesById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Company findByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return repository.findCompaniesByName(name);
    }

    @Override
    @Transactional
    public void insert(final Company company) {
        if (company != null) repository.save(company);
    }

    @Override
    @Transactional
    public void deleteById(final String id) {
        if (id != null || !id.isEmpty()) repository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(final Company company) {
        if (company != null) repository.delete(company);
    }

    @Override
    @Transactional
    public void update(final Company company) {
        if (company == null) return;
        final Company companyTmp = findById(company.getId());
        if (companyTmp == null) return;
        repository.save(company);
    }

    @Override
    @Transactional
    public void merge(final Company company) {
        if (company != null) repository.save(company);
    }

}
