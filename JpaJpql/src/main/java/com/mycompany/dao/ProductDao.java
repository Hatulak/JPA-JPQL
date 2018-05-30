 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.dao;
import java.util.List;
import com.mycompany.model.ProductDTO;

public interface ProductDao extends GenericDao<ProductDTO,Long>  {
    List<ProductDTO> findProductsInPriceRange(Double mininum, Double maximum);
    List<ProductDTO> findProductWithMaxPrice();
    List<ProductDTO> findNotPurchasedProducts();
    List<ProductDTO> findMostPurchasedProduct();
    void changeAllProductsPrice(Double percent);
    
}
