package com.recipe.domain;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category =new Category();

    @Before
    public void setUp(){
        category =new Category();
    }
    @Test
    void getId() throws Exception{
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());
    }

    @Test
    void getDescription() throws Exception{

    }

    @Test
    void getRecipes() throws Exception{
    }
}