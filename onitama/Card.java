import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classe que contém informações das cartas
 */
public class Card {
    private String name;
    private Color color;
    private Position[] positions;
    /**
     * Construtor que define os principais atributos de uma cara
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */
    public Card(String name, Color color, Position[] positions) {
        this.name = name;
        this.color = color;
        this.positions = positions;
    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */
    public Position[] getPositions() {
        return this.positions;
    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */
    public static Card[] createCards() {
        Card[] gameCards = {
            new Card("TIGER", Color.BLUE, new Position[]{ new Position(-2, 0), new Position(1, 0)}), 
            new Card("RABBIT", Color.BLUE, new Position[]{ new Position(-1, 1), new Position(0, 2), new Position(1, -1)}),
            new Card("CRAB", Color.BLUE, new Position[]{ new Position(-1, 0), new Position(0, 2), new Position(0, -2)}),
            new Card("GOOSE", Color.BLUE, new Position[]{ new Position(0, -1), new Position(-1, -1), new Position(0, 1), new Position(1, 1)}),
            new Card("DRAGON", Color.RED, new Position[]{ new Position(1, -1), new Position(-1, -2), new Position(-1, 2), new Position(1,1)}),
            new Card("FROG", Color.RED, new Position[]{ new Position(-1, -1), new Position(0, -2), new Position(1,1)}),
            new Card("ELEPHANT", Color.RED, new Position[]{ new Position(0, -1), new Position(-1, -1), new Position(-1, 1), new Position(0, 1)}),
            new Card("ROOSTER", Color.RED, new Position[]{ new Position(0, -1), new Position(1, -1), new Position(0, 1), new Position(-1, 1)})
        };

        List<Card> cardsList = Arrays.asList(gameCards);
        Collections.shuffle(cardsList);

        Card[] cartas = new Card[5];
        cartas[0] = cardsList.get(0);
        cartas[1] = cardsList.get(1);
        cartas[2] = cardsList.get(2);
        cartas[3] = cardsList.get(3);
        cartas[4] = cardsList.get(4);

        return cartas;
    }
}
