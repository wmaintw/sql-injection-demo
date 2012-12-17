package mymvc.dao;

import mymvc.domain.Audit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("AuditDao")
@Transactional
public class JpaAuditDao implements AuditDao {

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    public List<Audit> all() {
        return null;
    }

    @Override
    public void add(Audit audit) {
        entityManager.persist(audit);
    }
}
