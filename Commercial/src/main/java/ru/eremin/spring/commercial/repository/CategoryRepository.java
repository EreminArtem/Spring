package ru.eremin.spring.commercial.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.eremin.spring.commercial.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findAll() {
        return entityManager.createQuery("SELECT e FROM Category e", Category.class).getResultList();
    }

    public void insert(final Category category) {
        if (category != null) entityManager.persist(category);
    }

    public Category findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return entityManager.find(Category.class, id);
    }

    public void update(final Category category) {
        if (category != null) entityManager.merge(category);
    }

    public void delete(final String id) {
        if (id == null || id.isEmpty()) return;
        final Category category = entityManager.find(Category.class, id);
        if (category != null) entityManager.remove(category);
    }
}
