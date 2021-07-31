import java.util.ArrayList;
import java.util.Collections;
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
        return new ArrayList<Contato>(contatos.values());
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
        return (contatos.remove(name) != null);
    }

    public boolean removerFone(String name, int index){
        if(contatos.containsKey(name)){
            return contatos.get(name).removerFone(index);
        }
        return false;
    }

    public int quantidadeDeFones(Identificador identificador){
        int quantidade = 0;
        for(Contato contato : contatos.values()){
            ArrayList<Fone> fones = contato.getFones();
            for(Fone fone : fones){
                if(fone.getIdentificador() == identificador){
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    public int quantidadeTotalDeFones(){
        int quantidadeTotal = 0;
        for(Contato contato : contatos.values()){
            quantidadeTotal += contato.quantidadeFones();
        }
        return quantidadeTotal;
    }

    public ArrayList<Contato> pesquisar(String expressao){
        ArrayList<Contato> resultados = new ArrayList<>();
        
        Pattern pattern = Pattern.compile(expressao);   
        for(Contato contato : contatos.values()){
            Matcher matcher = pattern.matcher(contato.toString());
            if(matcher.find()){
                resultados.add(contato);
            }
        }
        Collections.sort(resultados);
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