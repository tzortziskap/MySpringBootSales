/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author tzortziskapellas
 */

@RequestMapping("/")
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String showHome(){
        return "home";
    }
    
    
}
