import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contato {
    

    public Contato(String name){
    }

    public String getNome() {
        return "";
    }

    public int getQuantidadeFones(){
        return -1;
    }

    public List<Fone> getFones() {
        return Collections.emptyList();
    }

    public boolean adicionarFone(Fone fone){ return false; }

    public boolean removerFone(int index){ return false; }

}
