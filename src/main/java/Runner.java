public class Runner {

    public static void main(final String[] args) {
        
        Contato contato = new Contato("Vitor");
        contato.adicionarFone(new Fone("oi", "(62)43691-2182"));
        System.out.println(contato);
        
        
    }
}
