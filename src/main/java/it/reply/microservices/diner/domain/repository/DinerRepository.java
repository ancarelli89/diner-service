package it.reply.microservices.diner.domain.repository;

import java.util.Collection;

public interface DinerRepository<Diner, String> extends Repository<Diner, String> {


    boolean containsName(String name);

    public Collection<Diner> findByName(String name) throws Exception;
    
    public Collection<Diner> findAll() throws Exception;
}
