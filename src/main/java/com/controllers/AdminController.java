package com.controllers;
import com.models.admin;
import com.serviseimplementation.AdminIm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:5173")
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
    @PutMapping("/UpdateAdmin/{id}")
    public ResponseEntity<admin>updateAdmin(@PathVariable  UUID id ,@RequestBody admin admin){
        admin.setId(id);
        admin UpdateAdmin=adminIm.Updateadmin(admin);
        return ResponseEntity.ok(UpdateAdmin);
    }
    @PostMapping("/AddAdmin")
    public ResponseEntity<admin> AddAdmin(@RequestBody admin admin){
        admin Admin =adminIm.Addadmin(admin);
        if (Admin==null){
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.ok(Admin);

    }
    @GetMapping("/GetAddminByiD/{id}")
public ResponseEntity <admin> GetAddminByiD(@PathVariable UUID id) {
admin Admin=adminIm.getadminByID(id);
if (Admin!=null){
return ResponseEntity.ok(Admin);}
else return ResponseEntity.noContent().build();

}



    
}
