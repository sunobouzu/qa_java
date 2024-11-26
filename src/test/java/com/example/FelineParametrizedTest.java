package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

        private Feline feline;
        private final int inputKittensCount;
        private final int expectedOutput;

        public FelineParametrizedTest(int inputKittensCount, int expectedOutput) {
            this.inputKittensCount = inputKittensCount;
            this.expectedOutput = expectedOutput;
        }

        @Parameterized.Parameters(name = "Тестовые данные: {0} ожидается {1}")
        public static Object[][] data() {
            return new Object[][]{
                    {1, 1},
                    {5, 5},
                    {3, 3},
                    {2, 2}
            };
        }

        @Before
        public void setUp() {
            feline = new Feline();
        }
        @Test
        public void testGetKittens() {
            assertEquals(expectedOutput, feline.getKittens(inputKittensCount));
        }

}
