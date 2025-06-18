package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int r=0; r<board.getRows(); r++){
            for(int c=0; c<board.getColumns(); c++){
                mat[r][c] = (ChessPiece) board.piece(r,c);
            }
        }
        return mat;
    }


    // utilizando o to position pra usar as coordenadas do sistema do xadrez primeiro indicando colun e depois linhas.
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
    }

    //responsavel por iniciar a partida, colocando as peças nos tabuleiros

    private void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

    }

}
