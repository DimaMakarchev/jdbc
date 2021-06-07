package com.jdbc.jdbc.repo;

import com.jdbc.jdbc.model.Bro;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public interface RepoBr {

    void creatDb();

    void save(Bro bro);

    List<Bro> findAll();

    Bro findOnId(int id);

    void remove(Bro bro);

    void update(Bro bro);
}
