package com.example.monster.controller;

import com.example.monster.models.Monster;
import com.example.monster.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/monster")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController (MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
	public List<Monster> getMonsters() {
		return monsterService.getMonsters();
	}

    @GetMapping("/{id}")
    public Optional<Monster> getMonsterById(@PathVariable Long id) {
        return monsterService.getMonsterById(id);
    }

    @PostMapping("/")
    public void addMonster(@RequestBody Monster monster) {
        monsterService.addMonster(monster);
    }

    @PutMapping("/{id}")
    public void updateMonster(@PathVariable Long id, @RequestBody Monster updatedMonster) {
        monsterService.updateMonster(id, updatedMonster);
    }

    @DeleteMapping("/{id}")
    public void deleteMonster(@PathVariable Long id) {
        monsterService.deleteMonster(id);
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
