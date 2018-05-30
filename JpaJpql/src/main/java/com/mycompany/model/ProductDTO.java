package com.mycompany.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
  @NamedQuery(name="ProductDTO.findProductsInPriceRange",query="select p from ProductDTO p where p.price between :minimum and :maximum"),
  @NamedQuery(name="ProductDTO.findProductWithMaxPrice",query="select p from ProductDTO p where p.price=(select max (pp.price) from ProductDTO pp) "),
  @NamedQuery(name="ProductDTO.findNotPurchasedProducts",query="select p from ProductDTO p where p.id not in (select pi.product.id from PurchaseItemDTO pi) "),
  @NamedQuery(name="ProductDTO.findMostPurchasedProduct",query="select p from ProductDTO p where p.id in(select pi.product.id from PurchaseItemDTO pi group by pi.product.id having SUM(pi.quantity)>=ALL(select SUM(pii.quantity) from PurchaseItemDTO pii group by pii.product.id))"),
  @NamedQuery(name="ProductDTO.changeAllProductsPrice",query="update ProductDTO p set p.price = p.price + (p.price * :percent)"),
})                                                       

@Entity
@Table(name="PRODUCT", schema="APP")
public class ProductDTO extends AbstractDTO {
   
    private String name;
    private Double price;

    public ProductDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

     @Override
    public String toString() {
        return getId()+","+name+","+price;
    }
}
