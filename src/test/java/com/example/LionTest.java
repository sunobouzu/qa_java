package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.Assert.*;


public class LionTest {
    private Lion lion;
    private Feline felineMock;


    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testSexLion() throws Exception {
            Lion maleLion = new Lion("Самец", felineMock);
            assertTrue("Самец должен иметь гриву", maleLion.doesHaveMane());

            Lion femaleLion = new Lion("Самка", felineMock);
            assertFalse("Самка не должна иметь гривы", femaleLion.doesHaveMane());
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        Mockito.when(felineMock.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        String animalType =  "Хищник";
        List expectedFood = List.of("Мясо", "Рыба");
        Mockito.when(felineMock.getFood(animalType)).thenReturn(expectedFood);
        List<String> food = lion.getFood();
        assertEquals(expectedFood, food);
    }

    @Test
    public void testLionInvalidSex() {
        String invalidSex = "НеправильныйПол";

        assertThrows("Неизвестное значение поля пол у льва",
                Exception.class, () -> new Lion(invalidSex, felineMock));
    }
}
