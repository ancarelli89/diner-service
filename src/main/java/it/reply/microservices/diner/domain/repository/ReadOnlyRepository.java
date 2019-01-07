package it.reply.microservices.diner.domain.repository;

import java.util.Collection;

import it.reply.microservices.diner.domain.model.entity.Entity;

public interface ReadOnlyRepository<TE, T> {


    boolean contains(T id);


    Entity<T> get(T id);


    Collection<TE> getAll();
}
