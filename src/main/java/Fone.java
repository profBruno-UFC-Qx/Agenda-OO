public class Fone {
    
    private String identificador;
    private String numero;

    public Fone(String identificador, String numero){
        this.identificador = identificador;
        this.numero = numero;
    }

    public static boolean validarNumero(String numero){
        String validos = "0123456789()-";
        for(int i=0;i<numero.length();i++){
            if(validos.indexOf(numero.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return identificador + ":" + numero; 
    }
}
