package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParametrizedTest  {

    private final String sex;
    private final Boolean mane;

    private Feline feline;

    public LionParametrizedTest(String sex, Boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Самокатчик", null},
        };
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }


    @Test
    public void testLion() throws Exception {
        if ("Самец".equals(sex) || "Самка".equals(sex)){
            Lion  lion = new Lion(sex, feline);
            assertEquals("Лев не лев", lion.doesHaveMane(), mane);
        }
        else {
            Exception exceptionLionSex = assertThrows("Неизвестное значение поля пол у льва",Exception.class,()-> new Lion(sex, feline));
            assertEquals(exceptionLionSex.getMessage(),"Используйте допустимые значения пола животного - самец или самка");
        }
    }
}

