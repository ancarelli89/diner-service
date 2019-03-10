package it.reply.microservices.diner.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import it.reply.microservices.diner.domain.model.entity.Diner;
import it.reply.microservices.diner.domain.model.entity.Entity;

public interface DinerService {

    public void add(Diner diner) throws Exception;

    public void update(Diner diner) throws Exception;

    public void delete(String id) throws Exception;

    public Entity<String> findById(String dinerId) throws Exception;

    public Collection<Diner> findByName(String name) throws Exception;
    
    public Collection<Diner> findAll() throws Exception;

    public Collection<Diner> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}