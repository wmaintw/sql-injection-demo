package mymvc.service;

import mymvc.dao.AuditDao;
import mymvc.dao.JpaAuditDao;
import mymvc.domain.Audit;
import mymvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DefaultAuditService implements AuditService {
    @Autowired
    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    private AuditDao auditDao;

    @Override
    public void add(String operation, User user) {
        Audit audit = new Audit();
        audit.setOperation(operation);
        audit.setUser(user);
        audit.setActionDate(new Date());

        auditDao.add(audit);
    }
}
