package mymvc.dao;

import mymvc.domain.User;

public interface UserDao {
    public User findByUsernameAndPassword(String username, String password);
}
