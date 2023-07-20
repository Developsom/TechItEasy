package com.example.techiteasy.Repository;

import com.example.techiteasy.Model.Television;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TelevisionRepository extends JpaRepository<Television, Long> {
    void deleteByName(String name);
}
