/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.converter;

import emergon.entity.Product;
import emergon.service.ProductService;
import javax.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tzortziskapellas
 */
public class ProductConverter implements AttributeConverter<Product,String>{
    
    @Autowired
    private ProductService service;
    @Override
    public String convertToDatabaseColumn(Product x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product convertToEntityAttribute(String y) {
        return service.getProductById(Integer.parseInt(y));
    }
    
}
