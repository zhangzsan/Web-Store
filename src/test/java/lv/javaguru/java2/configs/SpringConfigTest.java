package lv.javaguru.java2.configs;

import lv.javaguru.java2.database.ProductDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Mansur on 03.05.2017.
 */
public class SpringConfigTest {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ProductDAO productDAO = context.getBean(ProductDAO.class);
        assertNotNull(productDAO);
    }

}