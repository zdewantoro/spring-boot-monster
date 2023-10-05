package com.example.monster.config;

import com.example.monster.models.Monster;
import com.example.monster.repository.MonsterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MonsterConfig {
    @Bean
    CommandLineRunner commandLineRunner(MonsterRepository repository) {
        return args -> {
            Monster dragon = new Monster(
                "dragon",
                "fire",
                10,
                100,
                200,
                100
            );

            Monster fenrir = new Monster(
                    "fenrir",
                    "wind",
                    10,
                    75,
                    250,
                    75
            );

            Monster golem = new Monster(
                    "golem",
                    "earth",
                    10,
                    200,
                    20,
                    180
            );

            Monster kraken = new Monster(
                    "kraken",
                    "water",
                    10,
                    200,
                    100,
                    100
            );

            repository.saveAll(
                    List.of(
                            dragon, fenrir, golem, kraken
                    )
            );
        };
    }
}
