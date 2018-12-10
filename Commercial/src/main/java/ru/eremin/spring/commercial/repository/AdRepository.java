package ru.eremin.spring.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.eremin.spring.commercial.entity.Ad;
import ru.eremin.spring.commercial.entity.Category;
import ru.eremin.spring.commercial.entity.Company;

import java.util.List;

@Repository(AdRepository.NAME)
public interface AdRepository extends JpaRepository<Ad, String> {

    String NAME = "adRepository";

    Ad findAdById(String id);

    List<Ad> findAll();

    Ad findAdByName(String name);

    List<Ad> findAdsByCategory(Category category);

    @Query(value = "SELECT e.company FROM Ad e WHERE e.id = :id")
    Company getCompany(@Param("id") String id);

}
