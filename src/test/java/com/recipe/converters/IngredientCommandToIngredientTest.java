package com.recipe.converters;

import com.recipe.commands.IngredientCommand;
import com.recipe.commands.UnitOfMeasureCommand;
import com.recipe.domain.Ingredient;
import com.recipe.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientCommandToIngredientTest {
    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = Long.valueOf(1L);
    public static final Long UOM_ID = Long.valueOf(2L);

    IngredientCommandToIngredient converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
   public void convert() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUnitOfMeasure(unitOfMeasureCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    public void convertWithNotNullUOM() throws Exception{
        IngredientCommand iCommand = new IngredientCommand();
        iCommand.setId(ID_VALUE);
        iCommand.setAmount(AMOUNT);
        iCommand.setDescription(DESCRIPTION);

        Ingredient ingredient = converter.convert(iCommand);

        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE,ingredient.getId());
        assertEquals(DESCRIPTION,ingredient.getDescription());
        assertEquals(AMOUNT,ingredient.getAmount());
    }
}