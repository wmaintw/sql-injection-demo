package mymvc.service;

import mymvc.domain.User;

public interface AuditService {
    public void add(String operation, User user);
}
