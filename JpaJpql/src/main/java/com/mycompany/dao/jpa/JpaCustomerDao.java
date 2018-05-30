package com.mycompany.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.mycompany.dao.CustomerDao;
import com.mycompany.model.CustomerDTO;

public class JpaCustomerDao extends GenericJpaDao<CustomerDTO, Long> implements CustomerDao {   

    @Override
    public List<CustomerDTO> findCustomerByLastName(String lastName) {
        EntityManager em = getEntityManager();
        TypedQuery<CustomerDTO> q = em.createNamedQuery("CustomerDTO.findCustomerByLastName", CustomerDTO.class); 
        q.setParameter("lastName", lastName);
        return q.getResultList();
    }

 
}