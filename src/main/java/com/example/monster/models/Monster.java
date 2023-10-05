package com.example.monster.models;

import jakarta.persistence.*;

@Entity
@Table(name = "monster")
public class Monster {
    @Id
    @Column(name = "monster_id" )
    @SequenceGenerator(
            name = "monster_sequence",
            sequenceName = "monster_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "monster_sequence"
    )
    private Long id;
    private String name;
    private String element;
    private Integer level;
    private Integer health;
    private Integer attack;
    private Integer defense;

    public Monster() {}

    public Monster(Long id, String name, String element, Integer level, Integer health, Integer attack, Integer defense) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public Monster(String name, String element, Integer level, Integer health, Integer attack, Integer defense) {
        this.name = name;
        this.element = element;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", level=" + level +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}
