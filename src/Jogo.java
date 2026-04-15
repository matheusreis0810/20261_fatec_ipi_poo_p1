import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Jogo {

    public static void main(String[] args)throws Exception {
        var gerador = new Random();
        var cacador = new Personagem("Cleber");
        String[] itens = {"Pena", "Couro", "Osso", "Presa", "Garra"};
        
        List <Musica> disponivel = new ArrayList<>();
        String[] titulos = {"Center Mass", "Purple Rain", "Kidult", "End of Beginning", "In a Lake",
                            "Timeless", "Don't Fear The Reaper", "Karma Police", "The Boss", "Layla"};
        for (int i = 0; i < 10; i++) {
            disponivel.add(new Musica(titulos[i]));
        } 

        while(!cacador.estaMorto()){
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
            cacador.aprenderMusica(disponivel);
            System.out.println(cacador);
            cacador.aprenderMusica(disponivel);
            System.out.println("Conteudo da mochila do " + cacador.nome + ": " + cacador.mochila);
            System.out.println("Repertório do " + cacador.nome + ": " + cacador.repertorio);
            System.out.println("*********");
            cacador.morte(cacador.nome, cacador.mochila);
            try {
                Thread.sleep(5000);
            }catch (InterruptedException _) {
            } 
        }
    }
}