// this class will help with the checks needed to test for legal moves

/* int direction works like this:

7 8 9
4 5 6
1 2 3

it mimicks the numberpad on a standard keyboard
5 should never be used
*/

public class MoveCheckUtil {
  // int linear() checks if a piece moving in a linear fasion is making a legal move:
  // returns 1 if the move is legal
  // returns 0 if the move is illegal *should throw an error higher up which will be caught
  // returns 
  static int linear(Piece[][] board, int row1, int col1, int row2, int col2) {

    // variable declarations/initilization
    int direction = 5;
    int spaces = 0;

    // get side variable
    boolean isWhite = board[row1][col1].getIsWhite();

    // find the direction
      // vertical/horizontal moves:
    if (col1 == col2 && row1 == row2) { //the piece isn't moving
      return 0; // ILLEGAL
    } else if (col1 == col2 && row1 > row2) { // moving up
      direction = 8;
      spaces = Math.abs(row1 - row2);
    } else if (col1 == col2 && row1 < row2) { // moving down
      direction = 2;
      spaces = Math.abs(row1 - row2);
    } else if (col1 > col2 && row1 == row2) { // moving left
      direction = 4;
      spaces = Math.abs(col1 - col2);
    } else if (col1 < col2 && row1 == row2) { // moving right
      direction = 6;
      spaces = Math.abs(col1 - col2);
    }
      // diagonal moves:
    else if (!(Math.abs(row1 - row2) == Math.abs(col1 - col2))) { // the piece isn't moving the same amount of rows as columns
      return 0; // not a linear move
    } else if (row1 > row2 && col1 > col2) { // up-left
      direction = 7;
      spaces = Math.abs(row1 - row2);
    } else if (row1 > row2 && col1 < col2) { // up-right
      direction = 9;
      spaces = Math.abs(row1 - row2);
    } else if (row1 < row2 && col1 > col2) { // down-left
      direction = 1;
      spaces = Math.abs(row1 - row2);
    } else if (row1 < row2 && col1 < col2) { // down-right
      direction = 3;
      spaces = Math.abs(row1 - row2);
    }

    int j = 0; // avoids duplicate variable declaration for diagonal moves

    // knowing the direction, and distance (spaces) of the move, check if its legal
    switch (direction) {
      case 8: // UP, y is variable
        for (int i = row1; i >= row2; i--) { // init i as the spot, move untill 
          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][col1] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][col1].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][col1].getPieceChar() == 'K' || board[i][col1].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i-1 >= row2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal

      case 2: // DOWN, y is variable
        for (int i = row1; i <= row2; i++) {
          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][col1] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][col1].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][col1].getPieceChar() == 'K' || board[i][col1].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i+1 >= row2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal

      case 4: // LEFT, x/col is decreasing
        for (int i = col1; i >= col2; i--) {
          if (i == col1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[row1][i] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[row1][i].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[row1][i].getPieceChar() == 'K' || board[row1][i].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i-1 >= col2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal

      case 6: // RIGHT, x/col is increasing
        for (int i = col1; i <= col2; i++) {
          if (i == col1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[row1][i] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[row1][i].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[row1][i].getPieceChar() == 'K' || board[row1][i].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i+1 <= col2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal


      // DIAGONAL CASES

      
      case 7: // UP-LEFT, both are decreasing
        j = col1;
        for (int i = row1; i >= row2; i--, j--) { // init i as the spot, move untill 

          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][j] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][j].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][j].getPieceChar() == 'K' || board[i][j].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i-1 >= row2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal

      case 9: // UP-RIGHT, i/y/row is decreasing, j/x/col is increasing
        j = col1;
        for (int i = row1; i >= row2; i--, j++) { // init i as the spot, move untill 

          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][j] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][j].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][j].getPieceChar() == 'K' || board[i][j].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i-1 >= row2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal

      case 1: // DOWN-LEFT, i/y/row is increasing, j/x/col is decreasing
        j = col1;
        for (int i = row1; i <= row2; i++, j--) { // init i as the spot, move untill 

          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][j] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][j].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][j].getPieceChar() == 'K' || board[i][j].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i+1 <= row2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal
      
      case 3: // DOWN-RIGHT, both are decreasing
        j = col1;
        for (int i = row1; i >= row2; i--, j--) { // init i as the spot, move untill 

          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][j] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][j].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][j].getPieceChar() == 'K' || board[i][j].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i-1 >= row2) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal
    }
    return 0;
  }
}

/*
00 01 02 03 04 05 06 07 
10 11 12 13 14 15 16 17
20 21 22 23 24 25 26 27
30 31 32 33 34 35 36 37
40 41 42 43 44 45 46 47
50 51 52 53 54 55 56 57
60 61 62 63 64 65 66 67
70 71 72 73 74 75 76 77
*/