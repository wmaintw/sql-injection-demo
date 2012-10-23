package mymvc.dao;

import junit.framework.TestCase;
import mymvc.controller.CategoryController;
import mymvc.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JpaCategoryDaoTest extends TestCase {

    CategoryController controller;

    @Before
    public void setUp() throws Exception {
        controller = new CategoryController();
    }

    @Test
    public void testSave() throws Exception {
        Category givenCategory = new Category();
        givenCategory.setTitle("test title 2");
        givenCategory.setDescription("test description 2");

        controller.save(givenCategory, new ModelMap());

        assertTrue(givenCategory.getId() > 0);
    }

    @Test
    public void testFindById() throws Exception {
        ModelMap model = new ModelMap();
        controller.view(1, model);
        Category category = (Category)model.get("category");

        assertTrue(category.getId() > 0);
    }
}
