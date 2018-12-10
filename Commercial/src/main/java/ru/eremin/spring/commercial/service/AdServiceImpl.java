package ru.eremin.spring.commercial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eremin.spring.commercial.entity.Ad;
import ru.eremin.spring.commercial.entity.Category;
import ru.eremin.spring.commercial.entity.Company;
import ru.eremin.spring.commercial.repository.AdRepository;

import java.util.List;

@Service(AdServiceImpl.NAME)
public class AdServiceImpl implements AdService {

    public static final String NAME = "adServiceImpl";

    @Autowired
    @Qualifier(AdRepository.NAME)
    private AdRepository repository;

    @Autowired
    @Qualifier(CompanyServiceImpl.NAME)
    private CompanyService companyService;

    @Autowired
    @Qualifier(CategoryServiceImpl.NAME)
    private CategoryService categoryService;

    @Override
    @Transactional(readOnly = true)
    public List<Ad> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> findAll(final int page, final int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public Ad findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return repository.findAdById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Ad findByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return repository.findAdByName(name);
    }

    @Override
    @Transactional
    public void insert(final Ad ad) {
        if (ad == null) return;
        if (checkCategory(ad.getCategory()) && checkCompany(ad.getCompany())) {
            repository.save(ad);
        }
    }

    private boolean checkCompany(final Company company) {
        if (company == null) return false;
        if (companyService.findById(company.getId()) == null) return false;
        return true;
    }

    private boolean checkCategory(final Category category) {
        if (category == null) return false;
        if (categoryService.findById(category.getId()) == null) return false;
        return true;
    }

    @Override
    @Transactional
    public void deleteById(final String id) {
        if (id != null || !id.isEmpty()) repository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(final Ad ad) {
        if (ad != null) {
            repository.delete(ad);
        }
    }

    @Override
    @Transactional
    public void update(final Ad ad) {
        if (ad == null) return;
        if (!checkCategory(ad.getCategory()) || !checkCompany(ad.getCompany())) return;
        final Ad adTmp = findById(ad.getId());
        if (adTmp == null) return;
        repository.save(ad);
    }

    @Override
    @Transactional
    public void merge(final Ad ad) {
        if (ad == null) return;
        if (!checkCategory(ad.getCategory()) || !checkCompany(ad.getCompany())) return;
        repository.save(ad);
    }

    @Override
    @Transactional(readOnly = true)
    public Company getAdCompany(final String id) {
        if (id == null || id.isEmpty()) return null;
        return repository.getCompany(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ad> getAdsFromCategory(final Category category) {
        if (category == null) return null;
        return repository.findAdsByCategory(category);
    }

}
