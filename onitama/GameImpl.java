public class GameImpl implements Game{

    Player redPlayer;
    Player bluePlayer;
    Card cartaMesa;
    Spot tabuleiro[][];

    public GameImpl() {
        Card[] cartasJogo = Card.createCards();
        
        this.redPlayer = new Player("Jogador Vermelho", Color.RED, cartasJogo[1], cartasJogo[2]);
        this.bluePlayer = new Player("Jogador Azul", Color.BLUE, cartasJogo[3], cartasJogo[4]);
        cartaMesa = cartasJogo[0];

        this.tabuleiro = new Spot[5][5];
    }

    public GameImpl(String redPlayerName, String bluePlayerName) {
        Card[] cartasJogo = Card.createCards();
        
        this.redPlayer = new Player(redPlayerName, Color.RED, cartasJogo[1], cartasJogo[2]);
        this.bluePlayer = new Player(bluePlayerName, Color.BLUE, cartasJogo[3], cartasJogo[4]);
        cartaMesa = cartasJogo[0];

        this.tabuleiro = new Spot[5][5];
    }

    public GameImpl(String redPlayerName, String bluePlayerName, Card[] cards) {
        this.redPlayer = new Player(redPlayerName, Color.RED, cards[1], cards[2]);
        this.bluePlayer = new Player(bluePlayerName, Color.BLUE, cards[3], cards[4]);
        cartaMesa = cards[0];
        
        this.tabuleiro = new Spot[5][5];
    }


    public Color getSpotColor(Position position){
        return tabuleiro[position.getRow()][position.getCol()].getColor();
    }

    public Piece getPiece(Position position){
        return tabuleiro[position.getRow()][position.getCol()].getPiece();
    }

    public Card getTableCard(){
        return this.cartaMesa;
    }

    public Player getRedPlayer(){
        return this.redPlayer;
    }

    public Player getBluePlayer(){
        return this.bluePlayer;
    }

    public void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{
        /*Player currentPlayer = getCurrentPlayer();
    
        // Verifica se é a vez do jogador atual
        if (!currentPlayer.equals(getRedPlayer()) && !currentPlayer.equals(getBluePlayer())) {
            throw new IncorrectTurnOrderException("It's not the turn of the current player.");
        }
        
        // Verifica se a carta é válida para o jogador atual
        if (!currentPlayer.hasCard(card)) {
            throw new InvalidCardException("Invalid card for the current player.");
        }
        
        // Verifica se a posição atual é válida
        if (!isValidPosition(currentPos)) {
            throw new IllegalMovementException("Invalid current position.");
        }
        
        // Verifica se a posição de movimento da carta é válida
        if (!isValidPosition(cardMove)) {
            throw new IllegalMovementException("Invalid card move position.");
        }
        
        // Obtém a peça atual
        Piece currentPiece = getPiece(currentPos);
        
        // Verifica se a peça atual pertence ao jogador atual
        if (currentPiece == null || !currentPiece.getColor().equals(currentPlayer.getPieceColor())) {
            throw new InvalidPieceException("Invalid piece for the current player.");
        }
        
        // Verifica se o movimento é válido para a carta e atualiza a posição da peça
        if (!card.isValidMove(currentPos, cardMove)) {
            throw new IllegalMovementException("Invalid movement for the card.");
        }
        
        // Move a peça para a nova posição
        Piece pieceToMove = tabuleiro[currentPos.getRow()][currentPos.getCol()].removePiece();
        tabuleiro[cardMove.getRow()][cardMove.getCol()].setPiece(pieceToMove);
        
        // Remove a carta jogada da mão do jogador
        currentPlayer.removeCard(card);
        
        // Passa a vez para o próximo jogador
        if (currentPlayer.equals(redPlayer)) {
            currentPlayer = bluePlayer;
        } else {
            currentPlayer = redPlayer;
        }*/

    }

    
    public boolean checkVictory(Color color) {
        Player winnerPlayer;
        Player looserPlayer;

        //Verifica a cor dos jogadores
        if(color == Color.RED) {
            winnerPlayer = redPlayer;
            looserPlayer = bluePlayer;
        } else {
            winnerPlayer = bluePlayer;
            looserPlayer = redPlayer;
        }

        //Verifica se o mestre está na posição da base adversária
        if(winnerPlayer.getPieceColor() == Color.RED){
            if(tabuleiro[0][2].getPiece().getColor() != winnerPlayer.getPieceColor() && tabuleiro[0][2].getPiece().isMaster()){
                return true;
            }
        }
        else if(winnerPlayer.getPieceColor() == Color.BLUE) {
            if(tabuleiro[4][2].getPiece().getColor() != winnerPlayer.getPieceColor() && tabuleiro[4][2].getPiece().isMaster()) {
                return true;
            }
        }

        //Verifica se o mestre adversário foi derrotado:
        int isMasterCount = 0;
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                if(tabuleiro[row][col].getPiece().isMaster()){
                    isMasterCount++;
                }
            }
        }
        if(isMasterCount == 1)
            return true;     

        return false;
    }

    public void printBoard(){
        //Falta implementar
    }
}