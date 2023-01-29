package com.recipe.spring_recipe_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.recipe.domain")
@EnableJpaRepositories(basePackages = "com.recipe.repositories")
@ComponentScan(basePackages ={"com.recipe.bootstrap","com.recipe.services","com.recipe.controllers"})
public class SpringRecipeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRecipeAppApplication.class, args);
    }


}
