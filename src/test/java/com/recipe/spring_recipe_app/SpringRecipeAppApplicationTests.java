package com.recipe.spring_recipe_app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages ={"com.recipe.bootstrap","com.recipe.services","com.recipe.controllers","com.recipe.converters"})
public class SpringRecipeAppApplicationTests {

    @Test
    public void contextLoads() {
    }

}
