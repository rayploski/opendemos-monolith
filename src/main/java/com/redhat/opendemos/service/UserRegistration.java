package com.redhat.opendemos.service;


import com.redhat.opendemos.model.User;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class UserRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<User> userEvent;

    public void registerUser(User user) throws Exception {
        log.info("Registering " + user.getName());
        em.persist(user);
        userEvent.fire(user);
    }
}
