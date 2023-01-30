package com.recipe.controllers;

import com.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
    @SuppressWarnings("removal")
    @RequestMapping("/recipe/show/{id}")
    public String findById(@PathVariable String id, Model model){
            model.addAttribute("recipe", recipeService.findById(new Long(id)));
            return "recipe/show";
    }
}
