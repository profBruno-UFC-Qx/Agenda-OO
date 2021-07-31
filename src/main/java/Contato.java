import java.util.ArrayList;

public class Contato implements Comparable<Contato> {
    
    private String name;
    private ArrayList<Fone> fones;

    public Contato(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getQuantidadeFones(){
        return fones.size();
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }

    public int compareTo(Contato contato){
        return this.name.compareTo(contato.getName());
    }

    public boolean adicionarFone(Fone fone){
        if(Fone.validarNumero(fone.getNumero())){
            this.fones.add(fone);
            return true;
        }
        return false;
    }

    public boolean removerFone(int index){
        if(index < 0 || index >=  fones.size())
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
