package mymvc.dao;


import mymvc.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("UserDao")
@Transactional
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE username = '%s' and password = '%s'";
        String FIND_USER_BY_USERNAME_AND_PASSWORD_NATIVE = String.format(sql, username, password);

        Query query = entityManager.createNativeQuery(FIND_USER_BY_USERNAME_AND_PASSWORD_NATIVE, User.class);
        List<User> users = query.getResultList();

        if (users != null && users.size() > 0) {
            user = users.get(0);
        }

        return user;
    }
}
