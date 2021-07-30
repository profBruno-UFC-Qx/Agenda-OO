public class Fone {
    
    private Identificador identificador;
    private String numero;

    public Fone(Identificador identificador, String numero){
        this.identificador = identificador;
        this.numero = numero;
    }

    public static boolean validarNumero(String numero){
        String validos = "0123456789()-";
        //pecorre a string do numero
        for(int i=0;i<numero.length();i++){
            //verifica se existe algum caractere na string de numero que nao ocorre na string de validos
            if(validos.indexOf(numero.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return identificador.toString() + ":" + numero; 
    }
}
