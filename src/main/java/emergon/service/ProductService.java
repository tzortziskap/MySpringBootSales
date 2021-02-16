/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import java.util.List;

/**
 *
 * @author tzortziskapellas
 */
public interface ProductService {
    
     public List<Product> getProducts();

    public void addProduct(Product product);

    public void deleteProduct(int id);

    public Product getProductById(int id) ;

    public Product updateProduct(Product product);
}
