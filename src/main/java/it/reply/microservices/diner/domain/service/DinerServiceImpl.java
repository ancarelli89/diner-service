package it.reply.microservices.diner.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.reply.microservices.diner.domain.model.entity.Diner;
import it.reply.microservices.diner.domain.model.entity.Entity;
import it.reply.microservices.diner.domain.repository.DinerRepository;

@Service("dinerService")
public class DinerServiceImpl extends BaseService<Diner, String>
        implements DinerService {

    private DinerRepository<Diner, String> dinerRepository;

    /**
     *
     * @param dinerRepository
     */
    @Autowired
    public DinerServiceImpl(DinerRepository<Diner, String> dinerRepository) {
        super(dinerRepository);
        this.dinerRepository = dinerRepository;
    }

    @Override
    public void add(Diner diner) throws Exception {
        if (dinerRepository.containsName(diner.getName())) {
            throw new Exception(String.format("There is already a diner with the name - %s", diner.getName()));
        }

        if (diner.getName() == null || "".equals(diner.getName())) {
            throw new Exception("Diner name cannot be null or empty string.");
        }
        super.add(diner);
    }


    @Override
    public Collection<Diner> findByName(String name) throws Exception {
        return dinerRepository.findByName(name);
    }
    
    public Collection<Diner> findAll() throws Exception {
        return dinerRepository.findAll();
    }

    @Override
    public void update(Diner diner) throws Exception {
    	dinerRepository.update(diner);
    }

    @Override
    public void delete(String id) throws Exception {
    	dinerRepository.remove(id);
    }

    @Override
    public Entity<String> findById(String dinerId) throws Exception {
        return dinerRepository.get(dinerId);
    }

    @Override
    public Collection<Diner> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}