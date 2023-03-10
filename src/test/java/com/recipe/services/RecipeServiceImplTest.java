package com.recipe.services;

import com.recipe.converters.RecipeCommandToRecipe;
import com.recipe.converters.RecipeToRecipeCommand;
import com.recipe.domain.Recipe;
import com.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    RecipeServiceImpl recipeService;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService =new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }
    @Test
    public void getRecipeByIdTest() throws Exception{
        Recipe recipe =new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
        assertNotNull("Null Recipe returned",recipeReturned);
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
    @Test
    public void getRecipesTest() throws Exception {

        Recipe recipe =new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }
    @Test
    public void testDeleteByID() throws Exception{
        Long idToDelete = Long.valueOf(3L);
        recipeService.deleteById(idToDelete);

        //no 'when', since method has void return type
        //then
        verify(recipeRepository,times(1)).deleteById(anyLong());
    }

}