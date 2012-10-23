package mymvc.dao;

import mymvc.domain.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaCategoryDao {

    @PersistenceContext EntityManager em;

    public Category findById(int id) {
        return getEntityManger()
                .createNamedQuery("Category.classisQuery", Category.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    private EntityManager getEntityManger() {
        return em;
    }
}
