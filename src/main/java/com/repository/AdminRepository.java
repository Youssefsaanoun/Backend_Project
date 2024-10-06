package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.models.admin;
@Repository
public  interface AdminRepository  extends JpaRepository<admin,UUID>  {

}
