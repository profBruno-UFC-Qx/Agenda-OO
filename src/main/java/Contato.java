import java.util.ArrayList;
import java.util.List;

public class Contato {
    
    private String name;
    private ArrayList<Fone> fones;

    public Contato(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public boolean adicionarFone(Fone fone){
        if(Fone.validarNumero(fone.getNumero())){
            this.fones.add(fone);
            return true;
        }
        return false;
    }

    public boolean removerFone(int index){
        if(index < 0 || index > fones.size())
            return false;
        fones.remove(index);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append(" - " + this.name);
        int i=0;
        for(Fone fone : fones){
            saida.append(" [" + i + ":" + fone.toString() + "]");
            i++;
        }
        return saida.toString();
    }
}
