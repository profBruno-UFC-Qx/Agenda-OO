import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestFone {

    @Test
    public void testIdentificador(){
        assertTrue(Identificador.CLARO instanceof Enum, "O identificador deve ser uma enumeração");
        assertTrue(Identificador.TIM instanceof Enum, "O identificador deve ser uma enumeração");
        assertTrue(Identificador.VIVO instanceof Enum, "O identificador deve ser uma enumeração");
        assertTrue(Identificador.OI instanceof Enum, "O identificador deve ser uma enumeração");
        assertTrue(Identificador.CASA instanceof Enum, "O identificador deve ser uma enumeração");
        assertTrue(Identificador.TRABALHO instanceof Enum, "O identificador deve ser uma enumeração");

    }

    @Test
    public void testInicializacao(){
        Fone fone = new Fone(Identificador.CLARO, "(88)22161-5300");
        Fone fone1 = new Fone(Identificador.TRABALHO, "(88)93162-5665");
        Fone fone2 = new Fone(Identificador.TIM, "(35)90429-3605");
        Fone fone3 = new Fone(Identificador.VIVO, "(76)95862-9705");
        Fone fone4 = new Fone(Identificador.OI, "(45)94200-0844");
        Fone fone5 = new Fone(Identificador.CASA, "(59)94762-3373");
        assertEquals("Claro", fone.getIdentificador().toString(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("Trabalho", fone1.getIdentificador().toString(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("Tim", fone2.getIdentificador().toString(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("Vivo", fone3.getIdentificador().toString(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("Oi", fone4.getIdentificador().toString(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("Casa", fone5.getIdentificador().toString(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("(88)22161-5300", fone.getNumero(),
            "Ao inicializar um fone, o seu numero deve ser igual ao informado no construtor.");
    }

    @Test
    public void testValidarFoneCorretamente1(){
        Fone fone = new Fone(Identificador.CLARO, "(88)22161-5300");
        assertTrue(Fone.validarNumero(fone.getNumero()), 
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void testValidarFoneCorretamente2(){
        Fone fone = new Fone(Identificador.CLARO, "88221615300");
        assertTrue(Fone.validarNumero(fone.getNumero()), 
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void testValidarFoneCorretamente3(){
        Fone fone = new Fone(Identificador.CLARO, "15642-15(77)");
        assertTrue(Fone.validarNumero(fone.getNumero()), 
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void testInvalidarFoneIncorreto1(){
        Fone fone = new Fone(Identificador.CLARO, "(99)1564-124a");
        assertFalse(Fone.validarNumero(fone.getNumero()), 
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
        
    }

    @Test
    public void testInvalidarFoneIncorreto2(){
        Fone fone = new Fone(Identificador.CLARO, "991564.124a[]");
        assertFalse(Fone.validarNumero(fone.getNumero()), 
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
    }

    @Test
    public void testInvalidarFoneIncorreto3(){
        Fone fone = new Fone(Identificador.CLARO, "numero123");
        assertFalse(Fone.validarNumero(fone.getNumero()), 
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
        
    }
}