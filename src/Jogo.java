import java.util.Random;


public class Jogo {

    public static void main(String[] args)throws Exception {
        var gerador = new Random();
        var cacador = new Personagem("Cleber");
        String[] itens = {"Pena", "Couro", "Osso", "Presa", "Garra"};

        while(cacador.getVivo() == 1){
            int OQueFazer = gerador.nextInt(1, 4);
            switch (OQueFazer){
                case 1:{
                    int QualItem = gerador.nextInt(1, 6);
                    cacador.mochila.add(itens[QualItem-1]);
                    cacador.cacar();
                    break;
                }
                case 2:
                    cacador.comer();
                    break;
                case 3:
                    cacador.dormir();
                    break;
            }
            System.out.println(cacador);
            System.out.println("Conteudo da mochila do " + cacador.nome + ": " + cacador.mochila);
            System.out.println("***************************");
            cacador.morte(cacador.nome, cacador.mochila);
            try {
                Thread.sleep(5000);
            }catch (InterruptedException _) {
            } 
        }
    }
}
