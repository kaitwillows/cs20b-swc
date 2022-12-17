class Pawn extends Piece {
  boolean isWhite;
  char pieceChar;



  public Pawn(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'P';
    } else {
      pieceChar = 'p';
    }
  }

  void moveCheck() {
    if (isWhite) { // the pawn is white
      
    } else { // the pawn is black

    }
  }

  // appear in piece.java
  char getPieceChar() {
    return pieceChar;
  }
  boolean getIsWhite() {
    return isWhite;
  }

}

// sidewhite
//