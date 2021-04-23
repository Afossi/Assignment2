package com.shah;

import com.shah.entity.Inventory;
import com.shah.inventory.InventoryService;
import com.shah.entity.Store;
import com.shah.store.StoreService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@SessionScoped
@Named
public class StoreBean implements Serializable {

    @NotEmpty
    private String name;

    @NotEmpty
    private String sport;

    @NotEmpty
    private String location;

    @NotEmpty
    private int quantity;

    @NotEmpty
    private int price;

    @NotEmpty
    private String Name;

    @EJB
    InventoryService inventoryService;

    @EJB
    StoreService storeService;

    //Get InventoryList
    public List<Inventory> getInventoryList(){return inventoryService.getInventoryList();}

    //Wait(Remove)
    public List<Inventory> getWaitList(){return inventoryService.getWaitList();}

    //Add Inventory
    public String addInventory()
    {
        Inventory inventory = new Inventory(name,sport,location,quantity,price);

        return"Index.xhtml";
    }
    //Accessor and Mutators
    public List<Store> getStoreList(){return null;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
