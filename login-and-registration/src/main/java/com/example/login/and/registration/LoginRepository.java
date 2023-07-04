package com.example.login.and.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginDto,Integer>, JpaSpecificationExecutor<LoginDto> {
    List<LoginDto> findAll();

    Object save(LoginDto loginDto);

    Optional<LoginDto> findById(int id);

    void deleteById(int id);
}
