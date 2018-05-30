package com.mycompany.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.mycompany.dao.ProductDao;
import com.mycompany.model.ProductDTO;

public class JpaProductDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {
    @Override
    public List<ProductDTO> findProductsInPriceRange(Double minimum, Double maximum ) {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findProductsInPriceRange",ProductDTO.class);
         q.setParameter("minimum",minimum);
         q.setParameter("maximum",maximum);
        return q.getResultList();
    }

    @Override
    public List<ProductDTO> findProductWithMaxPrice() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findProductWithMaxPrice",ProductDTO.class);
        return q.getResultList();
        
    }

    @Override
    public List<ProductDTO> findNotPurchasedProducts() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findNotPurchasedProducts",ProductDTO.class);
        return q.getResultList();
    }

    @Override
    public List<ProductDTO> findMostPurchasedProduct() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findMostPurchasedProduct",ProductDTO.class);
        return q.getResultList();
    }

    @Override
    public void changeAllProductsPrice(Double percent) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("ProductDTO.changeAllProductsPrice",ProductDTO.class);
        q.setParameter("percent",percent/100);
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();
    }
}
