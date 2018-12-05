package ru.eremin.spring.commercial.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.eremin.spring.commercial.entity.Ad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AdRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Ad> findAll() {
        return entityManager.createQuery("SELECT e FROM Ad e", Ad.class).getResultList();
    }

    public void insert(final Ad ad) {
        if (ad != null) entityManager.persist(ad);
    }

    public Ad findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return entityManager.find(Ad.class, id);
    }

    public void update(final Ad ad) {
        if (ad != null) entityManager.merge(ad);
    }

    public void delete(final String id) {
        if (id == null || id.isEmpty()) return;
        final Ad ad = entityManager.find(Ad.class, id);
        if (ad != null) entityManager.remove(ad);
    }
}
