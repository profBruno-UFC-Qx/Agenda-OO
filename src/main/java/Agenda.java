import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Agenda {

    public List<Contato> getContatos() {
        return Collections.emptyList();
    }

    public int getQuantidadeDeContatos() { return -1; }

    public Contato getContato(String name){
        return null;
    }

    public boolean adicionarContato(Contato contato) { return false; }

    public boolean removerContato(String name){
        return false ;
    }

    public boolean removerFone(String name, int index){ return false; }

    public int getQuantidadeDeFones(Tipo tipo){ return -1; }

    public int getQuantidadeDeFones(){
        return -1;
    }

    public List<Contato> pesquisar(String expressao) { return Collections.emptyList(); }

}