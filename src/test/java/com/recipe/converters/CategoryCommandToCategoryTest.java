package com.recipe.converters;

import com.recipe.commands.CategoryCommand;
import com.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCommandToCategoryTest {
    private static final Long ID_VALUE = Long.valueOf(1L);
    private static final String DESCRIPTION = "description";

    CategoryCommandToCategory converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new CategoryCommandToCategory();
    }
    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception{
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        Category category = converter.convert(categoryCommand);

        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION,category.getDescription());
    }
}