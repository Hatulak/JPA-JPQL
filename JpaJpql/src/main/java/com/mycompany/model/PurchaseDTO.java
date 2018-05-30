package com.mycompany.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@NamedQueries({
@NamedQuery(name="PurchaseDTO.findPurchasesByCustomer",query="select p from PurchaseDTO p where p.customer.id = (select c.id from CustomerDTO c where c.firstName = :first and c.lastName =:last)"),
@NamedQuery(name="PurchaseDTO.getAllPurchases",query="select distinct p from  PurchaseDTO p left join p.purchaseItems pi"),
})
@Entity
@Table(name="PURCHASE", schema="APP")
public class PurchaseDTO extends AbstractDTO {
    
    @ManyToOne
    private CustomerDTO customer;
    
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();
    
    private String deliveryPlace;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;
    
    @ManyToOne
    private CourierDTO courier;

    //////////
    
    public void setCourier(CourierDTO courier) {
        this.courier = courier;
    }

    public CourierDTO getCourier() {
        return courier;
    }

    public void setPurchaseDate(Date deliveryDate) {
        this.purchaseDate = deliveryDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }
    
    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }
    
}
