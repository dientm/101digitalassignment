package com.digital.assignment.coreservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digital.assignment.coreservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(
        value = "SELECT * FROM ROLE r WHERE r.name = ?1",
        nativeQuery = true
    )
    Optional<Role> findByName(String name);
}
