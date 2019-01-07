package it.reply.microservices.diner.domain.service;

import it.reply.microservices.diner.domain.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}

