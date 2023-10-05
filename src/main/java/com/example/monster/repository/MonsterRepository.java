package com.example.monster.repository;

import com.example.monster.models.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
    @Query("SELECT m FROM Monster m WHERE m.name = ?1")
    Optional<Monster> findMonsterByName(String name);
}
