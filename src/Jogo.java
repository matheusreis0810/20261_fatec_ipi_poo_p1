import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Jogo {

    public static void main(String[] args)throws Exception {
        var gerador = new Random();
        var cacador = new Personagem("Cleber");
        var tico = new Personagem("Tico Trovador", 3, 8, 8);
        tico.repertorio.add(new Musica("God's Plan"));

        String[] itens = {"Pena", "Couro", "Osso", "Presa", "Garra"};
        
        List <Musica> disponivel = new ArrayList<>();
        String[] titulos = {"Center Mass", "Purple Rain", "Kidult", "End of Beginning", "In a Lake",
                            "Timeless", "Don't Fear The Reaper", "Karma Police", "The Boss", "Layla"};
                            
        for (int i = 0; i < 10; i++) {
            disponivel.add(new Musica(titulos[i]));
        }

        while(!cacador.estaMorto() || !tico.estaMorto()){
            int OQueFazer = gerador.nextInt(1, 4);
            int acaoTico = gerador.nextInt(1, 11);
            
               switch (acaoTico){
                case 1,2:{
                    int QualItem = gerador.nextInt(1, 6);
                    tico.mochila.add(itens[QualItem-1]);
                    tico.cacar();
                    break;
                }
                case 3,4:
                    tico.comer();
                    break;
                case 5,6,7,8,9,10:
                    tico.dormir();
                    break;
            }
            System.out.println("******************************");
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
            System.out.println("******************************");
            System.out.println(cacador);
            cacador.aprenderMusica(disponivel);
            System.out.println(cacador);
            cacador.morte(cacador.nome, cacador.mochila, cacador.repertorio);
            System.out.println(tico);
            tico.aprenderMusica(disponivel);
            System.out.println(tico);
            tico.morte(tico.nome, tico.mochila, tico.repertorio);

            try {
                Thread.sleep(5000);
            }catch (InterruptedException _) {
            } 
        }
    }
}