package com.example.monster.service;

import com.example.monster.models.Monster;
import com.example.monster.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {
	private final MonsterRepository monsterRepository;

	@Autowired
	public MonsterService(MonsterRepository monsterRepository) {
		this.monsterRepository = monsterRepository;
	}

	public List<Monster> getMonsters() {
		return monsterRepository.findAll();
	}

	public Optional<Monster> getMonsterById(Long id) {
		return monsterRepository.findById(id);
	}
	public void addMonster(Monster monster) {
		Optional<Monster> monsterOptional = monsterRepository.findMonsterByName(monster.getName());
		if(monsterOptional.isPresent()) {
			throw new IllegalStateException("name taken");
		}
		monsterRepository.save(monster);
	}

	public void updateMonster(Long id, Monster updatedMonster) {
		Optional<Monster> existingMonster = monsterRepository.findById(id);
		if (existingMonster.isPresent()) {
			Monster monster = existingMonster.get();
			monster.setName(updatedMonster.getName());
			monster.setLevel(updatedMonster.getLevel());
			monster.setElement(updatedMonster.getElement());
			monster.setHealth(updatedMonster.getHealth());
			monster.setAttack(updatedMonster.getAttack());
			monster.setDefense(updatedMonster.getDefense());
			monsterRepository.save(monster);
		}
	}

	public void deleteMonster(Long id) {
		boolean exists = monsterRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException(
					"monster with id " + id + " does not exist"
			);
		}
		monsterRepository.deleteById(id);
	}
}
