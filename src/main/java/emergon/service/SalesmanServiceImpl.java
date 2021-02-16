/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Salesman;
import emergon.repository.SalesmanRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SalesmanServiceImpl implements SalesmanService {
    
    @Autowired
    private SalesmanRepo salesmanRepo;

    @Override
    public List<Salesman> getSalesmans() {
        return salesmanRepo.findAll();
    }

    @Override
    public void addSalesman(Salesman salesman) {
        salesmanRepo.save(salesman);
    }

    @Override
    public void deleteSalesman(int id) {
        salesmanRepo.deleteById(id);
    }

    @Override
    public Salesman getSalesmanById(int id) {
        return salesmanRepo.findById(id).get();
    }

    @Override
    public Salesman updateSalesman(Salesman salesman) {
        return salesmanRepo.save(salesman);
    }
    
}
