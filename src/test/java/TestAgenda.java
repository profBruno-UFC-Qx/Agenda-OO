import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CASA, "(63)54612-5374")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertEquals(2, contato.getFones().size(),
            "Ao adicionar telefones válidos, eles serão salvos na lista de telefones do contato.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertEquals(1, agenda.getContatos().size(),
            "Ao adicionar um contato válido, ele será salvo na lista de contatos da agenda.");  
    }

    @Test
    public void testAdicionarContatoRepetido(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        Contato contato1 = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato1.adicionarFone(new Fone(Identificador.TIM, "(16)69902-3026")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato1.adicionarFone(new Fone(Identificador.VIVO, "(51)31658-4460")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");    
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertFalse(agenda.adicionarContato(contato1),
            "Não deve ser possível adicionar um contato na lista de contatos se o nome já existir.");
        assertEquals(1, agenda.getContatos().size(),
            "Ao adicionar um contato válido, ele será salvo na lista de contatos da agenda.");
        assertEquals(3, contato.getFones().size(),
            "Se o contato já existir deve ser possível apenas adicionar os novos telefones no contato já existente.");
    }

    @Test
    public void testRemoverContatoComSucesso(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        contato.adicionarFone(new Fone(Identificador.VIVO, "(16)69902-3026"));
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertTrue(agenda.removerContato("Alex"),
            "Deve ser possível remover um contato se o nome estiver cadastrado na lista de contatos da agenda.");
        assertEquals(0, agenda.getContatos().size(),
            "Ao remover um contato ele automáticamente irá ser excluído da lista de contatos.");  
    }

    @Test
    public void testRemoverFoneDoContatoDaAgenda(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        Fone fone = new Fone(Identificador.CLARO, "(59)19536-2054");
        assertTrue(contato.adicionarFone(fone),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        contato.adicionarFone(new Fone(Identificador.TIM, "(16)69902-3026"));
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertTrue(agenda.removerFone("Alex", 1),
            "Deve ser possível remover um contato se o nome do contato estiver cadastrado na agenda e se indice do fone corresponder a um fone.");
        assertEquals(1, contato.getFones().size(),
            "Ao remover um fone pelo indice o fone irá ser excluído permanentemente da lista de fones do contato.");
        List<Fone> fones = new ArrayList<>();
        fones.add(fone);
        List<Fone> restantes = contato.getFones();
        assertEquals(fones, restantes,
            "Ao remover um fone pelo indice o fone que será excluído tem que corresponder exatamente ao indíce que foi informado.");

    }

    @Test
    public void testRemoverFoneDoContatoDaAgendaComNomeNaoCadastrado(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertFalse(agenda.removerFone("Alexx", 1),
            "Não deve ser possível remover um fone de um contato se o nome do contato não estiver cadastrado na lista");
    }

    @Test
    public void testRemoverFoneDoContatoDaAgendaComIndiceIncorreto(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertFalse(agenda.removerFone("Alex", 2),
            "Não deve ser possível remover um fone de um contato se o indice do fone não conrresponder ao indice válido na lista de fones");
    }

    

    @Test
    public void testRemoverContatoComNomeNaoCadastrado(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Alex");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        contato.adicionarFone(new Fone(Identificador.TIM, "(16)69902-3026"));
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        assertFalse(agenda.removerContato("Ana"),
            "Não deve ser possível remover um contato se o nome do contato não estiver cadastrado na lista de contatos da agenda.");
    }

    @Test
    public void testPesquisandoContatosPorNomes(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Ana");
        Contato contato1 = new Contato("Adriele");
        Contato contato2 = new Contato("Ariele");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-2054")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato1.adicionarFone(new Fone(Identificador.TIM, "(46)40354-9846")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato2.adicionarFone(new Fone(Identificador.OI, "(37)44338-4811")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        List<Contato> resultadoExato = new ArrayList<>();
        List<Contato> resultado = agenda.pesquisar("ri");
        resultadoExato.add(contato1);
        resultadoExato.add(contato2);
        assertEquals(resultadoExato, resultado,
            "Deve ser possível encontrar contatos na lista de contatos se o padrão conrresponder a qualquer nome, identificado ou telefones");
    }

    @Test
    public void testPesquisandoContatosPorNumeros(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Geoana");
        Contato contato1 = new Contato("Adriele");
        Contato contato2 = new Contato("Ana");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-9999")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato1.adicionarFone(new Fone(Identificador.TIM, "(46)40354-8453")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato2.adicionarFone(new Fone(Identificador.OI, "(37)44338-4999")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        List<Contato> resultadoExato = new ArrayList<>();
        List<Contato> resultado = agenda.pesquisar("999");
        resultadoExato.add(contato2);
        resultadoExato.add(contato);
        assertEquals(resultadoExato, resultado,
            "Deve ser possível encontrar contatos na lista de contatos se o padrão conrresponder a qualquer nome, identificado ou telefones");
    }

    @Test
    public void testPesquisandoContatosSemNenhumResultado(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Ana");
        Contato contato1 = new Contato("Adriele");
        Contato contato2 = new Contato("Ariele");
        assertTrue(contato.adicionarFone(new Fone(Identificador.CLARO, "(59)19536-9999")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato1.adicionarFone(new Fone(Identificador.TIM, "(46)40354-9846")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(contato2.adicionarFone(new Fone(Identificador.OI, "(37)44338-4811")),
            "Deve ser possível adicionar um fone a um conato se o número estiver correto.");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        List<Contato> resultadoExato = new ArrayList<>();
        List<Contato> resultado = agenda.pesquisar("xyz");
        assertEquals(resultadoExato, resultado,
            "Não deve ser possível retornar nenhum resultado de pesquisa se o padrão não conrresponder a nenhum nome, identificador ou telefone.");
    }

    @Test
    public void testAgendaEmOrdemAlfabetica(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Carlos");
        Contato contato1 = new Contato("Adriele");
        Contato contato2 = new Contato("Biatriz");
        assertTrue(agenda.adicionarContato(contato),
            "Deve ser possível adcionar um contato na lista de contatos se o nome ainda não existir.");
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        List<Contato> listaEsperada = new ArrayList<>();
        listaEsperada.add(contato1);
        listaEsperada.add(contato2);
        listaEsperada.add(contato);
        List<Contato> lista = agenda.getContatos();
        assertEquals(listaEsperada, lista);
    }
}
