package it.reply.microservices.diner.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import it.reply.microservices.diner.domain.model.entity.Diner;
import it.reply.microservices.diner.domain.model.entity.Entity;

import org.springframework.stereotype.Repository;

@Repository("dinerRepository")
public class InMemDinerRepository implements DinerRepository<Diner, String> {

    private Map<String, Diner> entities;


    public InMemDinerRepository() {
        entities = new HashMap<String, Diner>();
        Diner diner = new Diner("Antonio", "1", "Carelli", "AntonioC", "Via del Colosseo 1, Roma");
        entities.put("1", diner);
        diner = new Diner("Mario", "2", "Rossi", "MarioR", "Piazza della Replubblica 1, Roma");
        entities.put("2", diner);
    }

    //@Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }


    //@Override
    public void add(Diner entity) {
        entities.put(entity.getId(), entity);
    }


    //@Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }


    //@Override
    public void update(Diner entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }


    //@Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    //@Override
    public Entity<String> get(String id) {
        return entities.get(id);
    }


    //@Override
    public Collection<Diner> getAll() {
        return entities.values();
    }


    //@Override
    public Collection<Diner> findByName(String name) throws Exception {
        Collection<Diner> diners = new ArrayList<Diner>();
        int noOfChars = name.length();
        Iterator<Diner> it = entities.values().iterator();
        while(it.hasNext()) {
        	Diner diner = it.next();
        	 if (diner.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
             	diners.add(diner);
             }
        }
        return diners;
    }


}
