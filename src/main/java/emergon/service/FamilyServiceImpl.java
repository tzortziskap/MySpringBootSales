/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Family;
import emergon.repository.FamilyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FamilyServiceImpl implements FamilyService {
    
    @Autowired
    private FamilyRepo familyRepo;

    @Override
    public List<Family> getFamilys() {
        return familyRepo.findAll();
    }

    @Override
    public void addFamily(Family family) {
        familyRepo.save(family);
    }

    @Override
    public void deleteFamily(int id) {
        familyRepo.deleteById(id);
    }

    @Override
    public Family getFamilyById(int id) {
        return familyRepo.findById(id).get();
    }

    @Override
    public Family updateFamily(Family family) {
        return familyRepo.save(family);
    }
    
}
