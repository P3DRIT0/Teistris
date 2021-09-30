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
public class BarPiece extends Piece{
     private int position;
    
        public BarPiece(Game game) {
   //   super(game);
        position=1;
        this.game = game;
squares[0]= new Square(Game.MAX_X / 2, 0,                     Color.YELLOW, game);
squares[1] = new Square(Game.MAX_X / 2   , 0 + Game.SQUARE_SIDE,                     Color.YELLOW, game);
squares[2] = new Square(Game.MAX_X / 2,    Game.SQUARE_SIDE + Game.SQUARE_SIDE,      Color.YELLOW, game);
squares[3] = new Square(Game.MAX_X / 2   , 0 +(3*Game.SQUARE_SIDE),      Color.YELLOW, game);
 }
        
    @Override
    public boolean rotate(){
        if(position==0){
           if(game.isValidPosition(squares[0].getX()+ Game.SQUARE_SIDE, squares[0].getY()- Game.SQUARE_SIDE) &&
                   game.isValidPosition(squares[1].getX(), squares[1].getY()) &&
                   game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE) &&
                   game.isValidPosition(squares[3].getX() - (2* Game.SQUARE_SIDE), squares[3].getY() + (2* Game.SQUARE_SIDE))
                   ){
            squares[0].setX(squares[0].getX() +Game.SQUARE_SIDE );
            squares[0].setY(squares[0].getY() -Game.SQUARE_SIDE);
            squares[1].setX(squares[1].getX());
            squares[1].setY(squares[1].getY());
            squares[2].setX(squares[2].getX() -Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() +Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX() - (2* Game.SQUARE_SIDE));
            squares[3].setY(squares[3].getY() + (2* Game.SQUARE_SIDE));
         
            position=1;
           }
        }
        
        else if(position==1){
            if(game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() +Game.SQUARE_SIDE) && 
                    game.isValidPosition(squares[1].getX() , squares[1].getY()) &&
                    game.isValidPosition(squares[2].getX()+Game.SQUARE_SIDE, squares[2].getY()- Game.SQUARE_SIDE)  &&
                    game.isValidPosition(squares[3].getX() + (2* Game.SQUARE_SIDE), squares[3].getY()- (2* Game.SQUARE_SIDE))){
                
            squares[0].setX(squares[0].getX() -Game.SQUARE_SIDE );
            squares[0].setY(squares[0].getY() +Game.SQUARE_SIDE);
            squares[1].setX(squares[1].getX());
            squares[1].setY(squares[1].getY());
            squares[2].setX(squares[2].getX() +Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() -Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX() + (2* Game.SQUARE_SIDE));
            squares[3].setY(squares[3].getY() - (2* Game.SQUARE_SIDE));   
           position=0;
            }
        }  
    return true;
    
    }
}