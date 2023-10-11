/**
 * Classe que contém informações e ações básicas relacionadas aos jogadores
 */
public class Player {
    private String name;
    private Color pieceColor;
    private Card[] cards = new Card[2];    
    /**
     * Construtor que define informações básicas do jogador
     * @param name Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param cards Cartas na mão do jogador
     */
    public Player(String name, Color pieceColor, Card[] cards) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.cards = cards; 
    }

    /**
     * Construtor que define informações básicas do jogador
     * @param name Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param card1 A primeira carta na mão do jogador
     * @param card2 A segunda carta na mão do jogador
     */
    public Player(String name, Color pieceColor, Card card1, Card card2) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.cards = new Card[]{card1, card2};
    }

    /**
     * Método que devolve o nome do jogador(a)
     * @return String com o nome do jogador(a)
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve a cor das peças do jogador
     * @return Enum Color com a cor das peças do jogador
     */
    public Color getPieceColor() {
        return this.pieceColor;
    }

    /**
     * Método que devolve as cartas da mão do jogador
     * @return Booleano true para caso seja um mestre e false caso contrário
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Método que troca uma carta da mão por outra carta (idealmente da mesa)
     * @param oldCard A carta que será substituída
     * @param newCard A carta que irá substituir
     * @exception InvalidCardException Caso a carta não esteja na mão do jogador e/ou na mesa
     */
    protected void swapCard(Card oldCard, Card newCard) throws InvalidCardException {
        //Verifica se a carta está na mão do jogador:
        boolean handCard = false;
        for(int i = 0; i < cards.length; i++) {
            if(cards[i] == oldCard){
                handCard = true;
                break;
            }
        }

        if(!handCard) {
            throw new InvalidCardException ("A carta não está na mão do jogador!");
        }

        //Quem verificará se a carta está na mesa será o método que chamará o swapCard. Provavelmente o GameImpl.
        
        // Realiza a troca das cartas
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == oldCard) {
                cards[i] = newCard;
                break;
            }
        } 
    }
}
