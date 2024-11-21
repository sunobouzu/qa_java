package com.example;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {
    private Cat cat;
    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Мясо", "Рыба"), food);
    }
}
