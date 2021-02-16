/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Sales;
import emergon.repository.SalesRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SalesServiceImpl implements SalesService {
    
    @Autowired
    private SalesRepo salesRepo;

    @Override
    public List<Sales> getSales() {
        return salesRepo.findAll();
    }

    @Override
    public void addSales(Sales sales) {
        salesRepo.save(sales);
    }

    @Override
    public void deleteSales(int id) {
        salesRepo.deleteById(id);
    }

    @Override
    public Sales getSalesById(int id) {
        return salesRepo.findById(id).get();
    }

    @Override
    public Sales updateSales(Sales sales) {
        return salesRepo.save(sales);
    }
    
}
