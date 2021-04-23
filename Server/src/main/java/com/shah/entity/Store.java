package com.shah.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@NamedQuery(name="Store.findAll",query="Select s FROM Store s")
@NamedQuery(name="Store.getByUserName",query = "Select s FROM Store s where s.name =:name")
@NamedQuery(name="Store.clearAll", query = "Delete FROM Store")
public class Store
{

    private Long id;
    private String Name;
    private String Location;

@OneToMany(mappedBy= "store", fetch =FetchType.EAGER)
    private List<Store> storeList;

    public Store(Long id, String Name, String Location)
    {
        this.id=id;
        this.Name=Name;
        this.Location=Location;
    }
}
