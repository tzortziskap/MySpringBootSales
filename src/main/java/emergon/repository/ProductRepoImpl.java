/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepoImpl extends HibernateUtil<Product> {

    @Override
    public Product save(Product product) {
        return super.save(product);
    }


    public void delete(int id) {
        super.delete(Product.class, id);
    }


    public Product findById(int id) {
        return super.find(Product.class, id);
    }


    public List<Product> findAll() {
        return super.findAll("Product.findAll");
    }

}
