/*
 * Copyright (C) 2019 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;
import java.awt.Color;
/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */
public abstract class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    protected Game game;

    /**
     * Referenzas ao array cos catro cadrados que forman a peza
     */
    protected Square squares[]= new Square[4]; 

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     */


    /**
     *
     * @return game que é un obxecto.
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game é o obxecto xogo.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * 
     * @return squares, que é o array que contén os cadrados que forman a peza.
     */
    public Square[] getSquares() {
        return squares;
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {
          if(game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY()) &&
                game.isValidPosition(squares[1].getX() + Game.SQUARE_SIDE, squares[1].getY())  &&
                  game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY()) &&
                  game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE, squares[3].getY())
                  ){
              for (int i = 0; i < squares.length; i++) {
                squares[i].setX(squares[i].getX() + Game.SQUARE_SIDE); // moves á dereita un lugar.   
              }
            }
          else {
            return false;
        }
        return true;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {
          if(game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY()) &&
                 game.isValidPosition(squares[1].getX() - Game.SQUARE_SIDE, squares[1].getY()) &&
                  game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY()) &&
                  game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE, squares[3].getY()) ){
              for (int i = 0; i < squares.length; i++) {
                  squares[i].setX(squares[i].getX()- Game.SQUARE_SIDE);  // moves á esquerda un lugar.
              }
            }
          else {
            return false;
        }
        return true;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {
          if(game.isValidPosition(squares[0].getX(), squares[0].getY()+ Game.SQUARE_SIDE) &&
                  game.isValidPosition(squares[1].getX(), squares[1].getY()+ Game.SQUARE_SIDE) &&
                  game.isValidPosition(squares[2].getX(), squares[2].getY()+ Game.SQUARE_SIDE) &&
                  game.isValidPosition(squares[3].getX(), squares[3].getY()+ Game.SQUARE_SIDE) ){
              for (int i = 0; i < squares.length; i++) {
                  squares[i].setY(squares[i].getY() + Game.SQUARE_SIDE); // moves cara abaixo un lugar.
              }
            }
          else {
            return false;
        }
        return true;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }

    public Square[] getPieceArray() {
       return squares;
    }
}