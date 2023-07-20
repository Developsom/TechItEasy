package com.example.techiteasy.Repository;

import com.example.techiteasy.Model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TelevisionRepository extends JpaRepository<Television, Long> {
    void deleteByName(String name);

    Optional<Television> findByName(String name);
}
