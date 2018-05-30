/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.dao;
import java.util.List;
import com.mycompany.model.PurchaseDTO;

public interface PurchaseDao  extends GenericDao<PurchaseDTO,Long>  {
    List<PurchaseDTO> findPurchasesByCustomer(String firstName, String lastName);
    List<PurchaseDTO> getAllPurchases();
}

