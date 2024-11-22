package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final Boolean expectedMane;

    private Feline feline;

    public LionParametrizedTest(String sex, Boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"НеправильныйПол", null},
        };
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testLionValidSex() throws Exception {
        if ("Самец".equals(sex) || "Самка".equals(sex)) {
            Lion lion = new Lion(sex, feline);
            assertEquals("Неверное значение гривы", expectedMane, lion.doesHaveMane());
        }
    }

    @Test
    public void testLionInvalidSex() {
        if ("НеправильныйПол".equals(sex)) {
            assertThrows("Неизвестное значение поля пол у льва",
                    Exception.class, () -> new Lion(sex, feline));
        }
    }
}
