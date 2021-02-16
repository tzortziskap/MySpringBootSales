/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Sales;
import java.util.List;

/**
 *
 * @author tzortziskapellas
 */
public interface SalesService {
    
    public List<Sales> getSales();

    public void addSales(Sales sales);

    public void deleteSales(int id);

    public Sales getSalesById(int id) ;

    public Sales updateSales(Sales sales);
    
}
