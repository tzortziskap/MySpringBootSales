/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Family;
import java.util.List;

/**
 *
 * @author tzortziskapellas
 */
public interface FamilyService {
    
    public List<Family> getFamilys();

    public void addFamily(Family family);

    public void deleteFamily(int id);

    public Family getFamilyById(int id) ;

    public Family updateFamily(Family family);
    
}
