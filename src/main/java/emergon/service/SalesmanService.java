/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Salesman;
import java.util.List;

/**
 *
 * @author tzortziskapellas
 */
public interface SalesmanService {
    
    public List<Salesman> getSalesmans();

    public void addSalesman(Salesman salesman);

    public void deleteSalesman(int id);

    public Salesman getSalesmanById(int id) ;

    public Salesman updateSalesman(Salesman salesman);
    
}
