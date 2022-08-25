package padraobridge;

/**
 *
 * @authores thalys fabrete, alexandre borlini, vitor zani e pedro mariano.
 */
public class PadraoBridge {

    public static void main(String[] args) {
        VideogameAbstrato videogame = new VideogameStandard(new VideogamePlaystation());
        System.out.println("\n---------------\n");
        videogame.jogar();
        videogame.menu("PAUSE");
        System.out.println("\n---------------\n");
        videogame = new VideogameUltra(new VideogameXbox());
        videogame.jogar();
        videogame.menu("PAUSE");
        System.out.println("\n---------------\n");
    }
    
}
