package ru.eremin.spring.commercial.service;

import ru.eremin.spring.commercial.entity.Ad;
import ru.eremin.spring.commercial.entity.Category;
import ru.eremin.spring.commercial.entity.Company;

import java.util.List;

public interface AdService extends AbstractService<Ad> {

    Company getAdCompany(final String id);

    List<Ad> getAdsFromCategory(final Category category);

}
