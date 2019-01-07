package it.reply.microservices.diner.domain.service;

import java.util.Collection;

import it.reply.microservices.diner.domain.repository.Repository;

public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        this.repository = repository;
    }

    public void add(TE entity) throws Exception {
        repository.add(entity);
    }

    public Collection<TE> getAll() {
        return repository.getAll();
    }
}
