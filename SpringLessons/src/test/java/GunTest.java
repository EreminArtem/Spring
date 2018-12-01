import config.Config;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.eremin.spring.guns.Magazine;
import ru.eremin.spring.guns.Rifle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class GunTest {
    private ApplicationContext context;
    private Rifle rifle;
    private Magazine magazine;
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(Config.class);
        rifle = context.getBean("rifle", Rifle.class);
        magazine = context.getBean("rifle_magazine", Magazine.class);
    }

    @Test
    public void gunShootTest(){
        rifle.shoot();
        System.out.println(rifle.getMagazine().getCapacity());
    }

    @Test
    public void notNullTest(){
        assertNotNull(rifle);
        assertNotNull(magazine);
    }

    @Test
    public void scopeTest(){
        Rifle rifleTest = context.getBean("rifle", Rifle.class);
        Magazine magazineTest = context.getBean("rifle_magazine", Magazine.class);
        assertEquals(rifle, rifleTest);
        assertNotEquals(magazine, magazineTest);
    }

}
