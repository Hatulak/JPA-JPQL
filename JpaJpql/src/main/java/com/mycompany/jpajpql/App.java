package com.mycompany.jpajpql;

import java.sql.Date;
import java.time.LocalDate;
import com.mycompany.dao.CourierDao;
import com.mycompany.dao.CustomerDao;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.PurchaseDao;
import com.mycompany.dao.jpa.JpaCourierDao;
import com.mycompany.dao.jpa.JpaCustomerDao;
import com.mycompany.dao.jpa.JpaProductDao;
import com.mycompany.dao.jpa.JpaPurchaseDao;
import com.mycompany.model.CourierDTO;
import com.mycompany.model.CustomerDTO;
import com.mycompany.model.ProductDTO;
import com.mycompany.model.PurchaseDTO;
import com.mycompany.model.PurchaseItemDTO;

public class App {

    public static void main(String[] args) {

        CustomerDao cdao = new JpaCustomerDao();
        ProductDao pdao = new JpaProductDao();
        PurchaseDao dao = new JpaPurchaseDao();
        CourierDao courdao = new JpaCourierDao();

        // utworzenie klienta
        CustomerDTO c1 = new CustomerDTO();
        c1.setFirstName("jan");
        c1.setLastName("kowalski");
        c1.setEmail("jan.kowalski@dot.com");
        // zapis klienta
        cdao.save(c1);
        
        // utworzenie klienta
        CustomerDTO c2 = new CustomerDTO();
        c2.setFirstName("andrzej");
        c2.setLastName("czajnik");
        c2.setEmail("a.czajnik@ads.com");
        // zapis klienta
        cdao.save(c2);
        
        // utworzenie kuriera
        CourierDTO cour1 = new CourierDTO();
        cour1.setName("Kurier");
        cour1.setAddress("ul.ulicowa");
        cour1.setEmail("asdf@fghj.com");
        // zapis kuriera
        courdao.save(cour1);
        
        // utworzenie kuriera
        CourierDTO cour2 = new CourierDTO();
        cour2.setName("Kurier2");
        cour2.setAddress("ul.uliczna");
        cour2.setEmail("afasdfasf234@fgfsdj.com");
        // zapis kuriera
        courdao.save(cour2);

        // utworzenie produktu
        ProductDTO p1 = new ProductDTO();
        p1.setName("monitor");
        p1.setPrice(599.99);
        // zapis produktu
        pdao.save(p1);
        
        // kolejny produkt
        ProductDTO p2 = new ProductDTO();
        p2.setName("klawiatura");
        p2.setPrice(29.99);
        // zapis produktu
        pdao.save(p2);
        
        // kolejny produkt
        ProductDTO p3 = new ProductDTO();
        p3.setName("mysz");
        p3.setPrice(9.99);
        // zapis produktu
        pdao.save(p3);

        // utworzenie zamowienia
        PurchaseDTO pe = new PurchaseDTO();
        pe.setCustomer(c1);
        pe.setDeliveryPlace("ul.xyz");
        pe.setPurchaseDate(Date.valueOf("2018-10-10"));
        PurchaseItemDTO pi = new PurchaseItemDTO();
        pi.setProduct(p1);
        pi.setQuantity(10);
        pe.addPurchaseItem(pi);
        pe.setCourier(cour1);
        
        // zapis zamowienia
        dao.save(pe);
        
        // utworzenie zamowienia
        PurchaseDTO pe2 = new PurchaseDTO();
        pe2.setCustomer(c2);
        pe2.setDeliveryPlace("ul.dasdadasd");
        pe2.setPurchaseDate(Date.valueOf("2018-05-14"));
        PurchaseItemDTO pi2 = new PurchaseItemDTO();
        pi2.setProduct(p3);
        pi2.setQuantity(123);
        pe2.addPurchaseItem(pi2);
        pe2.setCourier(cour2);
        
        // zapis zamowienia
        dao.save(pe2);   
        
        c1.setFirstName("janek");
        cdao.update(c1);
        
        PurchaseItemDTO pi3 = new PurchaseItemDTO();
        pi3.setProduct(p2);
        pi3.setQuantity(5);
        pe.addPurchaseItem(pi3);
        
        dao.update(pe);
        pe.getPurchaseItems().remove(0);
        pi.setQuantity(13);
        pe.addPurchaseItem(pi);
        dao.update(pe);
        
        /*//PODPUNKT A
        for(CustomerDTO c:cdao.findCustomerByLastName("kowalski")){
            System.out.println(c);
        }
        */
        
        /*//PODPUNKT B
        for(ProductDTO p: pdao.findProductWithMaxPrice()){
            System.out.println(p.getId().toString()+"  "+p.getName()+"  "+p.getPrice().toString());
        }
        */
        
        /*//PODPUNKT C
        for(ProductDTO p: pdao.findProductsInPriceRange(10.0, 1000.0)){
            System.out.println(p.getId().toString()+"  "+p.getName()+"  "+p.getPrice().toString());
        }
        */
        
        /*//PODPUNKT D
        for(PurchaseDTO p: dao.findPurchasesByCustomer("janek", "kowalski")){
            System.out.println(p.getId().toString()+"  "+p.getCustomer().getFirstName()+ "  "+ p.getCustomer().getLastName()+"  "+p.getDeliveryPlace()+"  "+p.getPurchaseDate().toString());
        }
        */
        
        /*//PODPUNKT E
        for(ProductDTO p: pdao.findNotPurchasedProducts()){
            System.out.println(p.getId().toString()+"  "+p.getName()+"  "+p.getPrice().toString());
        }
        */
        
        /*//PODPUNKT F
        for(ProductDTO p: pdao.findMostPurchasedProduct()){
            System.out.println(p.getId().toString()+"  "+p.getName()+"  "+p.getPrice().toString());
        }
        */
        //PODPUNKT E
        //pdao.changeAllProductsPrice(-5.0);
        
        //PODPUNKT 3
        for(PurchaseDTO p: dao.getAllPurchases()){
            System.out.println(p.getId().toString()+"  "+p.getCustomer().getFirstName()+ "  "+ p.getCustomer().getLastName()+"  "+p.getDeliveryPlace()+"  "+p.getPurchaseDate().toString());
            for(int i=0; i<p.getPurchaseItems().size(); i++){
                System.out.println(p.getPurchaseItems().get(i).getProduct().toString()+"  "+p.getPurchaseItems().get(i).getQuantity().toString());
            }
        }
        
        
    }

}
