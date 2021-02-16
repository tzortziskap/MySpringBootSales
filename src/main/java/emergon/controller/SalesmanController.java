/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Salesman;
import emergon.service.SalesmanService;
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
@RequestMapping("/salesman")
public class SalesmanController {
    
     @Autowired
    private SalesmanService service;
    
    @RequestMapping
    public ModelAndView showSalesmans(ModelAndView modelAndView){
        List<Salesman> salesmans = service.getSalesmans();
        modelAndView.addObject("listOfSalesmen", salesmans);
        modelAndView.setViewName("salesman/salesmanList");
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "salesman/salesmanForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Salesman salesman, RedirectAttributes attributes){
        service.addSalesman(salesman);
        return "redirect:/salesman";//Redirect instructs client to sent a new GET request to /salesman
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteSalesman(id);
        return "redirect:/salesman";
    }
    
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable("scode") int scode, Model model){
        Salesman salesman = service.getSalesmanById(scode);
        model.addAttribute("salesmanToEdit", salesman);
        return "salesman/salesmanForm";
    }
    
    @PostMapping("/update")
    public String update(Salesman salesman, RedirectAttributes attributes){
        service.updateSalesman(salesman);
        return "redirect:/salesman";
    }
}
