package com.calculatorsmp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class OperationsTest {
    String result;

    public OperationsTest() {
        this.result = "";
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        result = Operations.MakeFormula();
    }

    @AfterEach
    public void tearDown() {
    }

    @DisplayName("La fórmula no debe ser nula")
    @Test
    public void testMakeFormulaNull() {
        assertNotNull(result, "La fórmula no debe ser nula");
    }

    @Test
    public void testMakeFormulaVacio() {
        assertFalse(result.isEmpty(), "La fórmula nunca debe estar vacía");
    }

    @Test
    public void testMakeFormulaValido() {
        assertTrue(result.matches("\\d+([+\\-*/]\\d+)+"), "Fórmula generada sin formato esperado");
    }

    @Test
    @DisplayName("Prueba de división por 0")
    public void testSolveDivisionPara0() {
        String formula = "4/0";
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Operations.Solve(formula);
        });

        String expectedMessage = "No se puede dividir para 0";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testSolveMultiplicacion() {
        String formula = "4*2";
        String expectedResult = "4*2=8";
        assertEquals(expectedResult, Operations.Solve(formula));
    }

    @Test
    @DisplayName("Prueba de división")
    public void testSolveDivision() {
        String formula = "8/2";
        String expectedResult = "8/2=4";
        assertEquals(expectedResult, Operations.Solve(formula));
    }

    @Test
    @DisplayName("Prueba de Suma")
    public void testSolveSuma() {
        String formula = "3+2";
        String expectedResult = "3+2=5";
        assertEquals(expectedResult, Operations.Solve(formula));
    }

    @Test
    @DisplayName("Prueba de Resta")
    public void testSolveResta() {
        String formula = "3-2";
        String expectedResult = "3-2=1";
        assertEquals(expectedResult, Operations.Solve(formula));
    }
}

  
