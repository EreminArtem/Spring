package ru.eremin.spring.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eremin.spring.commercial.entity.Category;

import java.util.List;


@Repository(CategoryRepository.NAME)
public interface CategoryRepository extends JpaRepository<Category, String> {

    String NAME = "categoryRepository";

    Category findCategoryById(String id);

    List<Category> findAll();

    Category findCategoryByName(String name);

}
