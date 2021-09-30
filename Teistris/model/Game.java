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

import view.MainWindow;
import java.util.ArrayList;

/**
 * Clase que implementa o comportamento do xogo do Tetris
 *
 * @author Profe de Programación
 */
public class Game {

    /**
     * Array cos cadrados que quedan no chan cando caen as fichas
     */
    private ArrayList<Square> groundSquares;

    /**
     * Constante que define o tamaño en pixels do lado dun cadrado
     */
    public final static int SQUARE_SIDE = 20;
    /**
     * Constante que define o valor máximo da coordenada x no panel de cadrados
     */
    public final static int MAX_X = 320;

    /**
     * Costante que almacena o valor máximo da coordenada Y no panel de
     * cadrados.
     */
    public final static int MAX_Y = 400;

    /**
     * Referenza á peza actual do xogo, que é a única que se pode mover
     */
    private Piece currentPiece;

    /**
     * Referenza á ventá principal do xogo
     */
    private MainWindow mainWindow;

    /**
     * Flag que indica se o xogo está en pausa ou non
     */
    private boolean paused = false;

    /**
     * Número de liñas feitas no xogo
     */
    private int numberOfLines = 0;

    /**
     * @return Referenza á ventá principal do xogo
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * @param mainWindow Ventá principal do xogo a establecer
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * @return O estado de pausa do xogo
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * @param paused O estado de pausa a establecer
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * @return Número de liñas feitas no xogo
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * @param numberOfLines O número de liñas feitas no xogo
     */
    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    /**
     * Construtor da clase, que crea unha primeira peza
     *
     * @param mainWindow Referenza á ventá principal do xogo
     */
    public Game(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.createNewPiece();
        this.groundSquares = new ArrayList<Square>();
    }

    /**
     * Move a ficha actual á dereita, se o xogo non está pausado
     */
    public void movePieceRight() {
        if (!paused) {
            currentPiece.moveRight();
        }
    }

    /**
     * Move a ficha actual á esquerda, se o xogo non está pausado
     */
    public void movePieceLeft() {
        if (!paused) {
            currentPiece.moveLeft();
        }
    }

    /**
     * Rota a ficha actual, se o xogo non está pausado
     */
    public void rotatePiece() {
        if (!paused) {
            currentPiece.rotate();
        }
    }

   
    public void movePieceDown() {
        if ((!paused) && (!currentPiece.moveDown())) {
            this.addPieceToGround();
            this.createNewPiece();
            System.out.println(this.hitPieceTheGround());
            if (this.hitPieceTheGround()) {
                this.mainWindow.showGameOver();
            }
        }
    }

    
    public boolean isValidPosition(int x, int y) {
        boolean isValid = true;
        for (int i = 0; i < groundSquares.size(); i++) {
            if (x == groundSquares.get(i).getX() && y == groundSquares.get(i).getY()) {
                isValid = false;
            }

        }
        if ((x == MAX_X) || (x < 0) || (y == MAX_Y) || (!isValid)) {
            return false;
        }
        return true;
    }

  
    private void createNewPiece() {
        SquarePiece sp1;
        LPiece lp1;
        BarPiece bp1;
        TPiece tp1;

        int pieceType = new java.util.Random().nextInt(4);
        switch (pieceType) {
            case 0:
                sp1 = new SquarePiece(this);
                currentPiece = sp1;
                break;
            case 1:
                lp1 = new LPiece(this);
                currentPiece = lp1;

                break;
            case 2:
                bp1 = new BarPiece(this);
                currentPiece = bp1;
                break;
            case 3:
                tp1 = new TPiece(this);
                currentPiece = tp1;
                break;

        }

       
    }

  
    private void addPieceToGround() {
        // Engadimos os cadrados da peza ao chan
        for (int i = 0; i < currentPiece.getSquares().length; i++) {
            groundSquares.add(currentPiece.getSquares()[i]);
        }
        // Chamamos ao método que borra as liñas do chan que estean completas
        this.deleteCompletedLines();
    }

    
    private void deleteCompletedLines() {
        for (int i = 0; i <= MAX_Y; i++) {                    
            int aux = 0;
            for (int j = 0; j < groundSquares.size(); j++) {   
                if (groundSquares.get(j).getY() == i) {          
                    aux += SQUARE_SIDE;
                }

                if (aux == MAX_X) {  
                    this.deleteLine(i);  
                    numberOfLines++;
                    mainWindow.showNumberOfLines(numberOfLines);// tamaño dos cadrados dunha liña 
                }
            }
        }
    }

    
    private void deleteLine(int y) {
        for (int i = 0; i < groundSquares.size(); i++) {
            if (groundSquares.get(i).getY() == y) { 
                mainWindow.deleteSquare(groundSquares.get(i).getLblSquare());
                groundSquares.remove(i);
                i--;
            } else if (groundSquares.get(i).getY() < y) {
                groundSquares.get(i).setY(groundSquares.get(i).getY() + Game.SQUARE_SIDE); //baixa os cadrados
            }
        }
    }

  
    private boolean hitPieceTheGround() {
        for (Square groundSquare:groundSquares) {
            for (Square pieaceSquare:currentPiece.getSquares()) {  
                if (groundSquare.getCoordinates().equals(pieaceSquare.getCoordinates())) { //se teñen a mesma posición é que chocan
                    return true;
                }
            }
        }
      
        return false;
    }
}
