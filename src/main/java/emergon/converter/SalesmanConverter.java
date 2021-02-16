/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.converter;

import emergon.entity.Salesman;
import emergon.service.SalesmanService;
import javax.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tzortziskapellas
 */
public class SalesmanConverter implements AttributeConverter<Salesman,String>{
    
    @Autowired
    private SalesmanService service;
    @Override
    public String convertToDatabaseColumn(Salesman x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salesman convertToEntityAttribute(String y) {
        return service.getSalesmanById(Integer.parseInt(y));
    }
    
}
