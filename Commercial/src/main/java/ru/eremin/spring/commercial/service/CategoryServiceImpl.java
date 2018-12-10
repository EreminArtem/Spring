package ru.eremin.spring.commercial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eremin.spring.commercial.entity.Category;
import ru.eremin.spring.commercial.repository.CategoryRepository;

import java.util.List;

@Service(CategoryServiceImpl.NAME)
public class CategoryServiceImpl implements CategoryService {

    public static final String NAME = "categoryServiceImpl";

    @Autowired
    @Qualifier(CategoryRepository.NAME)
    private CategoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return repository.findCategoryById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Category findByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        return repository.findCategoryByName(name);
    }

    @Override
    @Transactional
    public void insert(final Category category) {
        if (category != null) repository.save(category);
    }

    @Override
    @Transactional
    public void deleteById(final String id) {
        if (id != null || !id.isEmpty()) repository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(final Category category) {
        if (category != null) repository.delete(category);
    }

    @Override
    @Transactional
    public void update(final Category category) {
        if (category == null) return;
        final Category categoryTmp = findById(category.getId());
        if (categoryTmp == null) return;
        repository.save(category);
    }

    @Override
    @Transactional
    public void merge(final Category category) {
        if (category != null) repository.save(category);
    }

}
