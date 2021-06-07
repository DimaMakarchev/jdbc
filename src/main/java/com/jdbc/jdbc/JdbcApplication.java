package com.jdbc.jdbc;

import com.jdbc.jdbc.model.Bro;
import com.jdbc.jdbc.repo.RepoBr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("repoBrImpl")
    private RepoBr repoBr;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        repoBr.creatDb();
        repoBr.save(new Bro(1, "BROOOO"));
        repoBr.save(new Bro(2, "Ti"));
        repoBr.save(new Bro(3, "Ma"));
//        repoBr.remove(new Bro(3, "bro))))"));
        repoBr.update(new Bro(3, "bro))))"));
        repoBr.findAll().stream().forEach(System.out::println);
        System.out.println("///++++" + repoBr.findOnId(1));


    }
}
