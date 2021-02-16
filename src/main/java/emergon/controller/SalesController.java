/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Sales;
import emergon.service.SalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @RequestMapping
    public ModelAndView showSaless(ModelAndView modelAndView){
        List<Sales> sales = service.getSales();
        modelAndView.addObject("listOfSales", sales);
        modelAndView.setViewName("sales/salesList");
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "sales/salesForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Sales sales, RedirectAttributes attributes){
        service.addSales(sales);
        return "redirect:/sales";//Redirect instructs client to sent a new GET request to /sales
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteSales(id);
        return "redirect:/sales";
    }
    
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable("id") int id, Model model){
        Sales sales = service.getSalesById(id);
        model.addAttribute("salesToEdit", sales);
        return "sales/salesForm";
    }
    
    @PostMapping("/update")
    public String update(Sales sales, RedirectAttributes attributes){
        service.updateSales(sales);
        return "redirect:/sales";
    }
}
