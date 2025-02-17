package com.db.zepto.db_api.repository;


import com.db.zepto.db_api.model.AppUser;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    public AppUser findByEmail(String email);
}