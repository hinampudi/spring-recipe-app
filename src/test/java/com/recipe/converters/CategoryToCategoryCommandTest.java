package com.recipe.converters;

import com.recipe.commands.CategoryCommand;
import com.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryToCategoryCommandTest {
    private static final Long ID_VALUE = Long.valueOf(1L);
    private static final String DESCRIPTION = "description";
    CategoryToCategoryCommand converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }
    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new Category()));
    }
    @Test
    public void convert() throws Exception{
        Category category =new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        CategoryCommand categoryCommand = converter.convert(category);

        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}