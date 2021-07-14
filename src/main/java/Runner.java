public class Runner {

    public static void main(final String[] args) {
        
        Contato contato = new Contato("Alex");
        System.out.println(contato);
        //  - Alex

        contato.adicionarFone(new Fone("Claro", "(77)89085-9077"));
        contato.adicionarFone(new Fone("Tim", "(63)61730-9301"));
        contato.adicionarFone(new Fone("Vivo", "(83)13265-4910"));
        System.out.println(contato);
        //  - Alex [0:Claro:(77)89085-9077] [1:Tim:(63)61730-9301] [2:Vivo:(83)13265-4910]

        if(!contato.adicionarFone(new Fone("Oi", "(44)40674-308[4]"))){
            System.out.println("fail: numero infomador é inválido");
        }// fail: numero infomador é inválido

        if(!contato.adicionarFone(new Fone("Claro", "(33)40674-num"))){
            System.out.println("fail: numero infomador é inválido");
        }// fail: numero infomador é inválido

        contato.adicionarFone(new Fone("Casa", "(39)11322-7246"));
        System.out.println(contato);
        //  - Alex [0:Claro:(77)89085-9077] [1:Tim:(63)61730-9301] [2:Vivo:(83)13265-4910] [3:Casa:(39)11322-7246]

        contato.removerFone(1);
        contato.removerFone(2);
        System.out.println(contato);
        // - Alex [0:Claro:(77)89085-9077] [1:Vivo:(83)13265-4910]

        if(!contato.removerFone(3)){
            System.out.println("fail: index infomado não não existe.");
        }// fail: index infomado não não existe.

        if(contato.removerFone(-2)){
            System.out.println("fail: index infomado não não existe.");
        }// fail: index infomado não não existe.
        System.out.println(contato);
        // - Alex [0:Claro:(77)89085-9077] [1:Vivo:(83)13265-4910]
    }
}
