package com.shah.inventory;

import com.shah.entity.Inventory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(InventoryService.class)
public class InventoryServiceImpl implements InventoryService {

    private static final int MAX_CAPACITY = 27;
    private static final int INITIAL_CAPACITY = 18;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void clearList() {
        Query deleteFromInventory = em.createNamedQuery("Inventory.clearAll");
        deleteFromInventory.executeUpdate();
    }


    @Override
    public List<Inventory> getInventoryList() {
        List<Inventory> inventoryList = em.createNamedQuery("Inventory.findAll",Inventory.class)
                .getResultList();

        if (inventoryList.size() < MAX_CAPACITY) {
            return inventoryList.stream()
                    .limit(INITIAL_CAPACITY)
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            return inventoryList.stream()
                    .limit(MAX_CAPACITY)
                    .sorted()
                    .collect(Collectors.toList());
        }
    }


    @Override
    public List<Inventory> getWaitList() {
        List<Inventory> inventoryList = em.createNamedQuery("Inventory.findAll",Inventory.class)
                .getResultList();
        if (inventoryList.size() > INITIAL_CAPACITY && inventoryList.size() < MAX_CAPACITY) {
            return inventoryList
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(8)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void addToList(Inventory inventory) {
        em.persist(inventory);
    }

    @Override
    public void removeFromList(Inventory inventory) {
        em.persist(inventory);
    }
}


