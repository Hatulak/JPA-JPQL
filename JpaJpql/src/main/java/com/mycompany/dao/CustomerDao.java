/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.dao;
import java.util.List;
import com.mycompany.model.CustomerDTO;

public interface CustomerDao extends GenericDao<CustomerDTO,Long>  {
    
    
    public List<CustomerDTO> findCustomerByLastName(String lastName); 
    
}
