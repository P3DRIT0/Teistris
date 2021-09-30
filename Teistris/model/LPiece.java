/*
 */
package model;
import java.awt.Color;

/**
 *
 * @author Pedro
 */
public class LPiece extends Piece {
  private int position;
    /**
     * Construtor que crea os 4 cadrados da peza en forma de L.
     * @param game 
     */
    public LPiece(Game game) {
     // super(game);
        this.game=game;

   position=1;
squares[0] = new Square(Game.MAX_X / 2   - Game.SQUARE_SIDE, 0,                     Color.GREEN, game);
squares[1] = new Square(Game.MAX_X / 2   - Game.SQUARE_SIDE, Game.SQUARE_SIDE,      Color.GREEN, game);
squares[2] = new Square(Game.MAX_X / 2  - Game.SQUARE_SIDE,   Game.SQUARE_SIDE + Game.SQUARE_SIDE, Color.GREEN, game);
squares[3] = new Square(Game.MAX_X / 2 ,    Game.SQUARE_SIDE + Game.SQUARE_SIDE,      Color.green, game);
    
 }
        
    @Override
    public boolean rotate(){
       
        switch(position){
          case 0:
              if(game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY()- Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[1].getX(), squares[1].getY()) &&
                 game.isValidPosition(squares[2].getX() +Game.SQUARE_SIDE, squares[2].getY()+ Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[3].getX() + (2* Game.SQUARE_SIDE), squares[3].getY())){
                  
            squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
            squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
            squares[1].setX(squares[1].getX());
            squares[1].setY(squares[1].getY());
            squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE );
            squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX() + (2* Game.SQUARE_SIDE));
            squares[3].setY(squares[3].getY());
            position=1;
              break;
              }

                
            case 1:
              if(game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY()+ Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[1].getX(), squares[1].getY()) &&
                 game.isValidPosition(squares[2].getX() +Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[3].getX(), squares[3].getY() - (2* Game.SQUARE_SIDE))){
            squares[0].setX(squares[0].getX()-Game.SQUARE_SIDE);
            squares[0].setY(squares[0].getY()+Game.SQUARE_SIDE);
            squares[1].setX(squares[1].getX());
            squares[1].setY(squares[1].getY());
            squares[2].setX(squares[2].getX() +Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() -Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX() );
            squares[3].setY(squares[3].getY() -(2*Game.SQUARE_SIDE));
            position=2;
                break;   
                }
            case 2:
                if(game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY()+ Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[1].getX(), squares[1].getY()) &&
                 game.isValidPosition(squares[2].getX() -Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[3].getX()- (2* Game.SQUARE_SIDE), squares[3].getY())){
           
             squares[0].setX(squares[0].getX()   + Game.SQUARE_SIDE);
             squares[0].setY(squares[0].getY() +Game.SQUARE_SIDE);
             squares[1].setX(squares[1].getX());
             squares[1].setY(squares[1].getY());   
             squares[2].setX(squares[2].getX() -Game.SQUARE_SIDE  );
             squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE );
             squares[3].setX(squares[3].getX() - (2* Game.SQUARE_SIDE));
             squares[3].setY(squares[3].getY());
                position=3;
                break;
         }
                
            case 3:
                   if(game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY()- Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[1].getX(), squares[1].getY()) &&
                 game.isValidPosition(squares[2].getX() -Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE) &&
                 game.isValidPosition(squares[3].getX(), squares[3].getY() + (2* Game.SQUARE_SIDE))){
                squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                squares[1].setX(squares[1].getX());
                squares[1].setY(squares[1].getY());
                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX());
                squares[3].setY(squares[3].getY() + (2* Game.SQUARE_SIDE));
                position=0;
                break;
        }
       }   
        return true;
    }       
}  