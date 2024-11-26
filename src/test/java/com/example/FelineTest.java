package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;


    @Before
    public void setUp() {
        feline = new Feline();
    }


    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
