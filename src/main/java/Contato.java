import java.util.ArrayList;

public class Contato {
    
    private String name;
    private ArrayList<Fone> fones;

    public Contato(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    public boolean adicionarFone(Fone fone){
        if(Fone.validarNumero(fone.getNumero())){
            this.fones.add(fone);
            return true;
        }
        return false;
        
    } 
}
