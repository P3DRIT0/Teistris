/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Pedro
 */
public class SquarePiece extends Piece{

    public SquarePiece(Game game) {
          //  public Piece(Game game) {
        this.game = game;
   
squares[0] = new Square(Game.MAX_X / 2   - Game.SQUARE_SIDE, 0,                Color.BLUE, game);
squares[1] = new Square(Game.MAX_X / 2,   0,                                   Color.BLUE, game);
squares[2] = new Square(Game.MAX_X / 2   - Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.BLUE, game);
squares[3] = new Square(Game.MAX_X / 2,   Game.SQUARE_SIDE,                    Color.BLUE, game);

    }
      //  super(game);
   // } 
}