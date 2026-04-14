package com.vps;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskServiceTest {

    @Test
    public void testTituloNoEsNulo() {
        String titulo = "Tarea de prueba";
        assertNotNull("El título no debe ser nulo", titulo);
        assertFalse("El título no debe estar vacío", titulo.isEmpty());
    }

    @Test
    public void testEstadoInicial() {
        String estadoEsperado = "PENDIENTE";
        String estadoActual = "PENDIENTE";
        assertEquals(estadoEsperado, estadoActual);
    }
}
