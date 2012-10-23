package mymvc.dao;

import junit.framework.TestCase;
import mymvc.domain.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CategoryDaoTest extends TestCase {

    @Autowired
    CategoryDao dao;

    public void testSave() throws Exception {

    }

    public void testFindById() throws Exception {
        Category category = dao.findById(1);

        assertEquals(1, category.getId());
    }
}
