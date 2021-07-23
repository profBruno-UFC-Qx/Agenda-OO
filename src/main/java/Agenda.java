import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {
    
    private TreeMap<String, Contato> contatos;

    public Agenda(){
        this.contatos = new TreeMap<>();
    }

    public List<Contato> getContatos() {
        ArrayList<Contato> contatosLista = new ArrayList<>(contatos.values());
        return contatosLista;
    }

    public Contato getContato(String name){
        return contatos.get(name);
    }

    public boolean adicionarContato(Contato contato){
        if(contatos.containsKey(contato.getName())){
            Contato contatoAtual = contatos.get(contato.getName());
            for(Fone fone : contato.getFones())
                contatoAtual.adicionarFone(fone);
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

    public ArrayList<Contato> pesquisar(String expressao){
        ArrayList<Contato> resultados = new ArrayList<>();
        
        Pattern pattern = Pattern.compile(expressao);
        Matcher matcher;
        for(Contato contato : contatos.values()){
            matcher = pattern.matcher(contato.toString());
            if(matcher.find()){
                resultados.add(contato);
            }
        }

        return resultados;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for(Contato contato : contatos.values()){
            saida.append(contato.toString() + "\n");
        }
        return saida.toString();
    }
}
