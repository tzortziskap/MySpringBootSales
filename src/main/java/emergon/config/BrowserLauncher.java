/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.config;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author tzortziskapellas
 */
@Component
public class BrowserLauncher {
    
    @EventListener(ApplicationReadyEvent.class)
public void launchBrowser(){
System.setProperty("java.awt.headless", "false");
Desktop desktop = Desktop.getDesktop();
try{
desktop.browse(new URI("http://localhost:8080/MySpringBootSales"));
}catch(Exception e){}
}
}
