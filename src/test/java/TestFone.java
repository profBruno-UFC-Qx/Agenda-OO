import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestFone {

    @Test
    public void testInicializacao(){
        Fone fone = new Fone("claro", "(88)22161-5300");
        assertEquals("claro", fone.getIdentificador(),
            "Ao inicializar um fone, o seu identificador deve ser igual ao informado no construtor.");
        assertEquals("(88)22161-5300", fone.getNumero(),
            "Ao inicializar um fone, o seu numero deve ser igual ao informado no construtor.");
    }

    @Test
    public void testValidarFoneCorretamente1(){
        Fone fone = new Fone("claro", "(88)22161-5300");
        assertTrue(Fone.validarNumero(fone.getNumero()), 
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void testValidarFoneCorretamente2(){
        Fone fone = new Fone("claro", "88221615300");
        assertTrue(Fone.validarNumero(fone.getNumero()), 
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void testValidarFoneCorretamente3(){
        Fone fone = new Fone("claro", "15642.(77)");
        assertTrue(Fone.validarNumero(fone.getNumero()), 
            "Deve ser possível um numero de telefone que contenha apenas os caracteres - , () , . e digitos de 0-9.");
    }

    @Test
    public void testInvalidarFoneIncorreto1(){
        Fone fone = new Fone("claro", "(99)1564.124a");
        assertFalse(Fone.validarNumero(fone.getNumero()), 
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
        
    }

    @Test
    public void testInvalidarFoneIncorreto2(){
        Fone fone = new Fone("claro", "991564.124a[]");
        assertFalse(Fone.validarNumero(fone.getNumero()), 
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
    }

    @Test
    public void testInvalidarFoneIncorreto3(){
        Fone fone = new Fone("claro", "numero123");
        assertFalse(Fone.validarNumero(fone.getNumero()), 
            "Não deve ser possível um numero de telefone que não contenha apenas os caracteres de - , () , . e digitos de 0-9.");
        
    }
}