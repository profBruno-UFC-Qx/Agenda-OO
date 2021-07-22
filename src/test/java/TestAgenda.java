import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestAgenda {
    
    @Test
    public void testInicializacao(){
        Agenda agenda = new Agenda();
        assertTrue(agenda.getContatos().isEmpty(),
            "Ao inicializar uma agenda, não deve haver nenhum contato na lista de contatos.");
    }

    @Test
    public void testAdicionarContatoComSucesso(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone("claro", "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
    }

    @Test
    public void testAdicionarContatoRepetido(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        Contato contato1 = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone("claro", "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato1.adicionarFone(new Fone("tim", "(16)69902-3026")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertFalse(agenda.adicionarContato(contato1),
            "Não deve ser possível adicionar um contato na lista de contatos se o nome já existir.");
        assertEquals(2, agenda.getContato(contato.getName()).getFones().size(),
            "Se o contato já existir deve ser possível apenas adicionar os novos telefones no contato já existente.");
    }

    @Test
    public void testRemoverContatoComSucesso(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone("claro", "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        contato.adicionarFone(new Fone("tim", "(16)69902-3026"));
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertTrue(agenda.removerContato("Alex"),
            "Deve ser possível remover um contato se o nome estiver cadastrado na lista de contatos da agenda.");
    }

    @Test
    public void testRemoverContatoComNomeNaoCadastrado(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone("claro", "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        contato.adicionarFone(new Fone("tim", "(16)69902-3026"));
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertFalse(agenda.removerContato("Ana"),
            "Não deve ser possível remover um contato se o nome do contato não estiver cadastrado na lista de contatos da agenda.");
    }
}
