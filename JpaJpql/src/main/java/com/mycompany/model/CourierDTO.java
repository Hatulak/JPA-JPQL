package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURIER", schema="APP")
public class CourierDTO extends AbstractDTO {
    
    private String name;
    private String address;
    private String email;
    
    @OneToMany(mappedBy="courier", cascade=CascadeType.PERSIST)
    private List<PurchaseDTO> purchase = new ArrayList();

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
