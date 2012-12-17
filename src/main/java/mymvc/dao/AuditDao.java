package mymvc.dao;

import mymvc.domain.Audit;

import java.util.List;

public interface AuditDao {
    public List<Audit> all();

    public void add(Audit audit);
}
