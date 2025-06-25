package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }


    // movimentos possiveis de um rei
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //mover pra cima
        p.setValues(position.getRow() - 1 , position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //mover pra baixo
        p.setValues(position.getRow() + 1 , position.getColumn());

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }


        //mover pra esquerda
        p.setValues(position.getRow()  , position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //mover pra direita
        p.setValues(position.getRow()  , position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //mover para noroeste

        p.setValues(position.getRow() - 1 , position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //mover para noroeste

        p.setValues(position.getRow() - 1 , position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sudoeste
        p.setValues(position.getRow() + 1 , position.getColumn() - 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sudeste
        p.setValues(position.getRow() + 1 , position.getColumn() + 1);

        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }



        return mat;
    }
}
