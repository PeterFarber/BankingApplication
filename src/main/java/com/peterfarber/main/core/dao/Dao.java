package com.peterfarber.main.core.dao;

import java.util.List;

public interface Dao <T> {

    public void create(T object);

    public T retrieveByString(String id);

    public List<T> retrieveAll();

    public void update(T object);

    public void delete(String id);

    public void createPreparedStmt(T object);

}
