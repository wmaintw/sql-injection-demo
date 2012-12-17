package mymvc.dao;

import junit.framework.TestCase;
import mymvc.domain.Audit;
import mymvc.domain.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class JpaAuditDaoTest extends TestCase {

    @Autowired
    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    private AuditDao auditDao;

    @Test
    public void testAdd() throws Exception {
        Audit audit = new Audit();
        audit.setActionDate(new Date());
        audit.setOperation("login");
        User user = new User();
        user.setId(1);
        user.setName("vian ma");
        audit.setUser(user);
        auditDao.add(audit);

        assertNotNull(audit.getId());
    }
}
