import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.eremin.spring.commercial.entity.Category;
import ru.eremin.spring.commercial.entity.Company;
import ru.eremin.spring.commercial.service.*;
import ru.eremin.spring.commercial.configuration.AppConfiguration;
import ru.eremin.spring.commercial.entity.Ad;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdServiceImplTest {
    private static ApplicationContext context;
    private static AdService adService;
    private static CompanyService companyService;
    private static CategoryService categoryService;
    private static List<Ad> list;

    private static Company company;
    private static Category category;

    private static String companyName = "testCompany";
    private static String categoryName = "testCategory";

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        adService = context.getBean(AdServiceImpl.NAME, AdService.class);
        categoryService = context.getBean(CategoryServiceImpl.NAME, CategoryService.class);
        companyService = context.getBean(CompanyServiceImpl.NAME, CompanyService.class);

        company = new Company();
        company.setName(companyName);
        companyService.insert(company);

        category = new Category();
        category.setName(categoryName);
        categoryService.insert(category);

        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Ad ad = new Ad();
            ad.setName("ad" + i);
            ad.setAdText("test" + i);
            ad.setCompany(company);
            ad.setCategory(category);
            list.add(ad);
        }
    }

    @Test
    public void notNullTest() {
        assertNotNull(context);
        assertNotNull(adService);
    }

    @Test
    public void findAllTest() {
        assertNotNull(adService.findAll());
    }

    @Test()
    public void addTest1() {
        final int size = adService.findAll().size();
        for (final Ad ad : list) {
            adService.insert(ad);
        }
        assertEquals(size + list.size(), adService.findAll().size());
    }

    @Test
    public void negativeAddTest() {
        final Company testCompany = new Company();
        testCompany.setName("badCompany");
        final Category testCategory = new Category();
        testCategory.setName("badCategory");
        Ad ad = new Ad();

        ad.setName("badAd");
        ad.setAdText("text");

        adService.insert(ad);

        ad.setCompany(testCompany);
        adService.insert(ad);

        ad.setCategory(testCategory);
        adService.insert(ad);

        assertNull(adService.findById(ad.getId()));
    }

    @Test
    public void limitTest() {
        final int limit = 3;
        System.out.println(adService.findAll(0, limit));
        assertEquals(limit, adService.findAll(0, limit).size());
    }

    @Test
    public void findByIdTest() {
        final Ad ad = adService.findAll(0, 2).get(1);
        assertEquals(adService.findById(ad.getId()), ad);
    }

    @Test
    public void findByNameTest() {
        final Ad ad = adService.findByName(list.get(1).getName());
        assertEquals(list.get(1), ad);
    }

    @Test
    public void updateTest() {
        Ad ad = adService.findByName(list.get(1).getName());
        final String newName = "newAD";
        adService.update(ad);
        assertEquals(adService.findById(ad.getId()).getName(), ad.getName());
    }

    @Test
    public void negativeUpdateTest() {
        final Ad ad = new Ad();
        final String name = "negative";
        ad.setName(name);
        ad.setAdText("text");
        adService.update(ad);
        assertNotEquals(adService.findByName(name), ad);
    }

    @Test
    public void mergeTest() {
        final Ad ad = new Ad();
        final String name = "mergeAd";
        ad.setName(name);
        ad.setAdText("text");
        ad.setCategory(category);
        ad.setCompany(company);
        adService.merge(ad);
        list.add(ad);
        assertEquals(adService.findByName(name), ad);
    }

    @Test
    public void getCompanyTest() {
        assertEquals(company, adService.getAdCompany(list.get(1).getId()));
    }

    @Test
    public void getAdsFromCategoryTest() {
        assertEquals(list.size(), adService.getAdsFromCategory(category).size());
    }

    @Test
    public void zdeleteTest() {
        for (final Ad ad : list) {
            adService.delete(ad);
            assertNull(adService.findById(ad.getId()));
        }
    }

    @AfterClass
    public static void clean() {
        companyService.delete(company);
        categoryService.delete(category);
    }
}
