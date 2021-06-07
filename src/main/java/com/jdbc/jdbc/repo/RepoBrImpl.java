package com.jdbc.jdbc.repo;

import com.jdbc.jdbc.model.Bro;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("repoBrImpl")
public class RepoBrImpl implements RepoBr {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    @Transactional
    public void creatDb() {
        jdbcTemplate.execute("drop table if exists brocool");
        jdbcTemplate.execute("create table brocool(" +
                "id int not null auto_increment," +
                "name varchar (50)," +
                "primary key (id))");
    }

    @Override
    @Transactional
    public void save(Bro bro) {
        jdbcTemplate.update("insert into brocool(name) values (?)",
                bro.getName());
    }

    @Override
    @Transactional
    public List<Bro> findAll() {
        return jdbcTemplate.query("SELECT * FROM  brocool",
                (rs, rowNum) -> new Bro(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
    }

    @Override
    @Transactional
    public Bro findOnId(int id) {
        return jdbcTemplate.queryForObject("SELECT * from brocool Where id =?",
                new Object[]{id}, (rs, rowNum) -> new Bro(rs.getInt("id"),
                        rs.getString("name")));
    }

    @Override
    @Transactional
    public void remove(Bro bro) {
        jdbcTemplate.update("" +
                        "DELETE brocool where id = ? ",
                bro.getId());
    }

    @Override
    @Transactional
    public void update(Bro bro) {
        jdbcTemplate.update("UPDATE brocool SET name = ?  where id = ? and id =?",
//                bro.getName(), bro.getId());
//                bro.getName(), new Object[]{bro.getId()});
//                bro.getName(), new Object[]{bro.getId()},new Object[]{bro.getId()});
                bro.getName(), new Object[]{bro.getId(),bro.getId()});
    }
}
