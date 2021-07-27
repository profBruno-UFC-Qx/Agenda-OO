# Contato - Agenda 
![contato](assets/figura.jpg)

O objetivo dessa atividade é implementar uma agenda que possui vários contatos e cada contato possui vários telefones.


- [Requisitos](#requisitos)
- [Diagrama](#diagrama)
- [Exemplo de execução](#exemplo-de-execução)
- [Relatório de Entrega](#relatório-de-entrega)


## Requisitos

- Inicializar um contato
  - Para inicializar um contato você precisar informar o nome do contato.
- Inserir fones no contato
  - Um fone tem um indentificador e um número
  - Identificadores são nomes como: casa, fixo, tim, claro.
- Validar números de telefone
  - Processe os números de telefone para que sejem aceitos somente aqueles que tem os seguintes caracteres: ```0123456789()-```.
  - Se o usuário tentar inserir um número de telefone inválido não adcione o fone no contato.
- Adicionar contato na ageda
  - O contato possui o nome como chave
  - Se tentar adicionar outro contato na agenda com o mesmo nome, adicione apenas os telefones no contato existente.
- Mostrar na agenda
  - Exiba os contatos da agenda em ordem alfabética.
- Remoção de contatos da agenda
  - Remover contato pela chave.
  - Remover telefone do contato pela chave e por indíce do telefone.
- Busca
  - Fazer uma busca por um padrão em todos os atributos do contato, seja por nome, identificado ou telefone.
  - Se o contato tiver qualquer campo que combine com a string pattern de busca, ele deve ser retornado. Se o pattern é maria, devem ser retornados os contatos como "maria julia", "mariana", "ana maria" etc. Também inclua na busca identificador do telefone e o número de telefone.


## Diagrama

## Exemplo de execução 
```java
import java.util.ArrayList;

public class Runner {

    public static void main(final String[] args) {
        
        Agenda agenda = new Agenda();
        
        Contato contato = new Contato("Adriele");
        contato.adicionarFone(new Fone("Claro", "(77)89085-9077"));
        contato.adicionarFone(new Fone("Tim", "(63)61730-9301"));
        System.out.println(contato); // - Adriele [0:Claro:(77)89085-9077] [1:Tim:(63)61730-9301]
        
        Contato contato1 = new Contato("Biatriz");
        contato1.adicionarFone(new Fone("Vivo", "(80)63810-9092"));
        System.out.println(contato1); // - Biatriz [0:Vivo:(80)63810-9092]
        
        Contato contato2 = new Contato("Ariele");
        contato2.adicionarFone(new Fone("Trabalho", "(24)62362-1925"));
        if(!contato2.adicionarFone(new Fone("Trabalho", "(24)62362-abc"))){
            System.out.println("fail: numero de telefone invalido"); //fail: numero de telefone invalido
        }
        System.out.println(contato2); // - Ariele [0:Trabalho:(24)62362-1925]
        
        agenda.adicionarContato(contato);
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        System.out.println(agenda);
        /*
            - Adriele [0:Claro:(77)89085-9077] [1:Tim:(63)61730-9301]
            - Ariele [0:Trabalho:(24)62362-1925]
            - Biatriz [0:Vivo:(80)63810-9092]
        */

        Contato contato3 = new Contato("Biatriz");
        contato3.adicionarFone(new Fone("OI", "(59)67638-0967"));
        contato3.adicionarFone(new Fone("Casa", "(59)67638-0967"));
        agenda.adicionarContato(contato3);
        System.out.println(agenda);
        /*
            - Adriele [0:Claro:(77)89085-9077] [1:Tim:(63)61730-9301]
            - Ariele [0:Trabalho:(24)62362-1925]
            - Biatriz [0:Vivo:(80)63810-9092] [1:OI:(59)67638-0967] [2:Casa:(59)67638-0967]
        */

        agenda.removerFone("Adriele", 1);
        System.out.println(agenda);
        /*
            - Adriele [0:Claro:(77)89085-9077]
            - Ariele [0:Trabalho:(24)62362-1925]
            - Biatriz [0:Vivo:(80)63810-9092] [1:OI:(59)67638-0967] [2:Casa:(59)67638-0967]
        */

        if(!agenda.removerContato("Alex")){
            System.out.println("fail: nome do contato não esta cadastrado na ageda"); 
            // fail: nome do contato não esta cadastrado na agenda
        }
        ArrayList<Contato> resultados = agenda.pesquisar("le");
        for(Contato resultado : resultados)
            System.out.println(resultado.toString());
        /*
            - Adriele [0:Claro:(77)89085-9077]
            - Ariele [0:Trabalho:(24)62362-1925]
        */
    }
}
```

## Relatório de Entrega

Não esqueça de preencher o seguinte formulário [Link para formulário](#form) ao completar a atividade.
