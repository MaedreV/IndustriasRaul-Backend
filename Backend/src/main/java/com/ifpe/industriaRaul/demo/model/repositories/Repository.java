package com.ifpe.industriaRaul.demo.model.repositories;

import java.sql.SQLException;

public interface Repository<C, KEY> {

    public void create(C c) throws SQLException;

    public void update(C c) throws SQLException;

    public C read(KEY k) throws SQLException;

    public void delete(KEY k) throws SQLException;
}
