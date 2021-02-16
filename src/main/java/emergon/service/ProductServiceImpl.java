/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import emergon.repository.ProductRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
     private ProductRepo productRepo;
    
    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> product = productRepo.findById(id);
        return product.get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
    
}
