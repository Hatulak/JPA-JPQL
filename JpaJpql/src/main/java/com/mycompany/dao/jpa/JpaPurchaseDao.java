package com.mycompany.dao.jpa;

import com.mycompany.dao.jpa.GenericJpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.mycompany.dao.PurchaseDao;
import com.mycompany.dao.PurchaseDao;
import com.mycompany.model.PurchaseDTO;

public class JpaPurchaseDao extends GenericJpaDao<PurchaseDTO, Long> implements PurchaseDao {
    
    @Override
    public List<PurchaseDTO> findPurchasesByCustomer(String firstName, String lastName) {
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> q = em.createNamedQuery("PurchaseDTO.findPurchasesByCustomer",PurchaseDTO.class);
        q.setParameter("first",firstName);
        q.setParameter("last",lastName);
        return q.getResultList();
    }

    @Override
    public List<PurchaseDTO> getAllPurchases() {
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> q = em.createNamedQuery("PurchaseDTO.getAllPurchases", PurchaseDTO.class);
        return q.getResultList();
    }
}
