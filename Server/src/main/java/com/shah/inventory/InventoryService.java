package com.shah.inventory;

import com.shah.entity.Inventory;

import java.util.List;

public interface InventoryService {
    void clearList();

    List<Inventory> getInventoryList();

    List<Inventory> getWaitList();

    void addToList(Inventory inventory);
    void removeFromList(Inventory inventory);
}
