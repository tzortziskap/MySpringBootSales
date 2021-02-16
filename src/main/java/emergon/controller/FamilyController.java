/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Family;
import emergon.service.FamilyService;
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
@RequestMapping("/family")
public class FamilyController {
    
     @Autowired
    private FamilyService service;
    
    @RequestMapping
    public ModelAndView showFamilys(ModelAndView modelAndView){
        List<Family> familys = service.getFamilys();
        modelAndView.addObject("listOfFamilys", familys);
        modelAndView.setViewName("family/familyList");
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "family/familyForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Family family, RedirectAttributes attributes){
        service.addFamily(family);
        return "redirect:/family";//Redirect instructs client to sent a new GET request to /family
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteFamily(id);
        return "redirect:/family";
    }
    
    @GetMapping("/update/{fid}")
    public String showFormUpdate(@PathVariable("fid") int fid, Model model){
        Family family = service.getFamilyById(fid);
        model.addAttribute("familyToEdit", family);
        return "family/familyForm";
    }
    
    @PostMapping("/update")
    public String update(Family family, RedirectAttributes attributes){
        service.updateFamily(family);
        return "redirect:/family";
    }
}
