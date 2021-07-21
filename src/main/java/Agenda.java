import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    
    private TreeMap<String, Contato> contatos;

    public Agenda(){
        this.contatos = new TreeMap<>();
    }

    public Map<String, Contato> getContatos() {
        return contatos;
    }

    public Contato getContato(String name){
        return contatos.get(name);
    }

    public boolean adicionarContato(Contato contato){
        if(contatos.containsKey(contato.getName())){
            for(Fone fone : contato.getFones())
                contatos.get(contato.getName()).adicionarFone(fone);
            return false;
        }
        contatos.put(contato.getName(), contato);
        return true;
    }

    public boolean removerContato(String name){
        if(contatos.containsKey(name)){
            contatos.remove(name);
            return true;
        }
        return false;
    }
}
