package com.example.TicketsDemo.repository;

import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JdbcUtilRepository implements UtilRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


}
