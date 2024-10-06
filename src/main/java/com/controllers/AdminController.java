package com.controllers;
import com.models.admin;
import com.serviseimplementation.AdminIm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController{
    private final AdminIm adminIm;
    public AdminController(AdminIm adminIm) {
        this.adminIm = adminIm;
    }
    @GetMapping
    public ResponseEntity <List<admin>>getALLadmin(){
        List <admin>admins=adminIm.getALLadmin();
        return ResponseEntity.ok(admins);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void>DeleteAdmin(@PathVariable UUID id){
        adminIm.Deleteadmin(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/UpdateAdmin")
    public ResponseEntity<admin>updateAdmin(UUID id ,admin admin){
        admin.setId(id);
        admin UpdateAdmin=adminIm.Updateadmin(admin);
        return ResponseEntity.ok(UpdateAdmin);
    }
    @PostMapping("/AddAdmin")
    public ResponseEntity<admin>AddAdmin(admin admin){
        admin Admin =adminIm.Addadmin(admin);
        if (Admin==null){
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.ok(Admin);

    }


    
}
