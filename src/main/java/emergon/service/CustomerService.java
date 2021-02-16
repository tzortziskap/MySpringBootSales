/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import java.util.List;

/**
 *
 * @author tzortziskapellas
 */
public interface CustomerService {
    
    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);

    public void deleteCustomer(int id);

    public Customer getCustomerById(int id) ;

    public Customer updateCustomer(Customer customer);
    
}
