package it.reply.microservices.diner.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import it.reply.microservices.diner.domain.model.entity.Diner;
import it.reply.microservices.diner.domain.model.entity.Entity;
import it.reply.microservices.diner.domain.service.DinerService;
import it.reply.microservices.diner.domain.valueobject.DinerVO;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
@RequestMapping("/v1/diners")
public class DinerController {

    protected static final Logger logger = Logger.getLogger(DinerController.class.getName());

    protected DinerService dinerService;

    @Autowired
    public DinerController(DinerService dinerService) {
        this.dinerService = dinerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Diner>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("diner-service findByName() invoked:{} for {} ", dinerService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<Diner> diners;
        try {
        	diners = dinerService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findByName REST Call {0}", ex);
            return new ResponseEntity<Collection<Diner>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return diners.size() > 0 ? new ResponseEntity<Collection<Diner>>(diners, HttpStatus.OK)
                : new ResponseEntity<Collection<Diner>>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{diner_id}", method = RequestMethod.GET)
    public ResponseEntity<Entity<String>> findById(@PathVariable("diner_id") String id) {
        logger.info(String.format("diner-service findById() invoked:{} for {} ", dinerService.getClass().getName(), id));
        id = id.trim();
        Entity<String> diner;
        try {
        	diner = dinerService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<Entity<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return diner != null ? new ResponseEntity<Entity<String>>(diner, HttpStatus.OK)
                : new ResponseEntity<Entity<String>>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Diner> add(@RequestBody DinerVO dinerVO) {
        logger.info(String.format("diner-service add() invoked: %s for %s", dinerService.getClass().getName(), dinerVO.getName()));
        System.out.println(dinerVO);
        Diner diner = new Diner(null, null, null, null, null);
        BeanUtils.copyProperties(dinerVO, diner);
        try {
            dinerService.add(diner);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception Diner REST Call {0}", ex);
            return new ResponseEntity<Diner>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<Diner>(HttpStatus.CREATED);
    }
}
