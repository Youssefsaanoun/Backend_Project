package com.serviseimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

import com.models.admin;
import com.repository.AdminRepository;
import com.servise.adminServise;
@Service

public  class AdminIm implements adminServise {


@Autowired
    private final AdminRepository adminRepository;
    
    public AdminIm(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
}

    @Override
    public List<admin> getALLadmin() {
       return  adminRepository.findAll();
    }

    @Override
    public void Deleteadmin(UUID id) {
       adminRepository.deleteById(id);
    }

    @Override
    public admin getadminByID(UUID id) {
         Optional <admin> optional=adminRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        else
            return null;
       
    }

    @Override
    public admin Addadmin(admin admin) {
       return adminRepository.save(admin);
    }

    @Override
    public admin Updateadmin(admin admin) {
        Optional <admin> optional=adminRepository.findById(admin.getId());
        if (optional.isPresent()){
            return  adminRepository.save(admin);
        }
        else
            return null;
    }

    


    


}
