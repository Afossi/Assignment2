package com.shah.store;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(StoreService.class)
public class StoreServiceImpl {
    private static final int MAX_CAPACITY = 27;
    private static final int INITIAL_CAPACITY = 18;

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
