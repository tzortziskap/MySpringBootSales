/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.entity.Product;
import emergon.entity.Sales;
import emergon.entity.Salesman;
import emergon.service.CustomerService;
import emergon.service.ProductService;
import emergon.service.SalesService;
import emergon.service.SalesmanService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author tzortziskapellas
 */
@Controller
@RequestMapping("/sales")
public class SalesController {
    
     @Autowired
     private SalesService service;
     @Autowired
     private ProductService productService;
     @Autowired
     private CustomerService customerService;
     @Autowired
     private SalesmanService salesmanService;
     
     
     
     @ModelAttribute("products")
     public List<Product> getProducts(){
         return productService.getProducts();
     }
     
     @ModelAttribute("customers")
     public List<Customer> getCustomers(){
         return customerService.getCustomers();
     }
     @ModelAttribute("salesmen")
     public List<Salesman> getSalesmen(){
         return salesmanService.getSalesmans();
     }
     
    
    @RequestMapping
    public ModelAndView showSaless(ModelAndView modelAndView){
        List<Sales> sales = service.getSales();
        modelAndView.addObject("listOfSales", sales);
        modelAndView.setViewName("sales/salesList");
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("sale") Sales sale){
        return "sales/salesForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("sale") @Valid Sales sales,
            BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "sales/salesForm";
        }
        sales.setCost(service.calculateCost(sales.getPcode(),sales.getQuant()));
        service.addSales(sales);
        return "redirect:/sales";//Redirect instructs client to sent a new GET request to /sales
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteSales(id);
        return "redirect:/sales";
    }
    
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable("scode") int scode, Model model){
        Sales sales = service.getSalesById(scode);
        model.addAttribute("salesToEdit", sales);
        return "sales/salesForm";
    }
    
    @PostMapping("/update")
    public String update(Sales sales, RedirectAttributes attributes){
        sales.setCost(service.calculateCost(sales.getPcode(),sales.getQuant()));
        service.updateSales(sales);
        return "redirect:/sales";
    }
}
