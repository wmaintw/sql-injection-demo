package mymvc.service;

import mymvc.dao.UserDao;
import mymvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User exist(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
