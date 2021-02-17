/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.converter;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import javax.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tzortziskapellas
 */
public class CustomerConverter implements AttributeConverter<Customer,String>{
    
    @Autowired
    private CustomerService service;
    @Override
    public String convertToDatabaseColumn(Customer x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer convertToEntityAttribute(String y) {
        return service.getCustomerById(Integer.parseInt(y));
    }
    
}
