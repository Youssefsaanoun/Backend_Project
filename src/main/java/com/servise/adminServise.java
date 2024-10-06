package com.servise;

import java.util.List;
import java.util.UUID;

import com.models.admin;


public interface adminServise {


   public List<admin> getALLadmin();
    public void Deleteadmin(UUID id );
    public admin getadminByID(UUID id );
    public admin Addadmin(admin admin);
    public admin Updateadmin(admin admin);


}
