/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Game;
import java.applet.AudioClip;
import javax.sound.midi.Soundbank;

/**
 *
 * @author Raquel
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    AudioClip Sound;

    public MainWindow() {

        initComponents();
        String imagepath = "multimedia/BackgroundInterior.jpg";
        ((JPanelBackground) panelXogo).setBackground(imagepath);
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/multimedia/TestrisSong.wav"));
        Sound.loop();
    }

    private Game game = null; // Referenza ao obxecto do xogo actual
    private Timer timer;

    /**
     * Pinta un cadrado no panel de cadrados
     *
     * @param lblSquare Etiqueta co cadrado que se quere pintar no panel
     */
    public void drawSquare(JLabel lblSquare) {
        panelXogo.add(lblSquare);
        panelXogo.repaint();
    }

    /**
     * Borra un cadrado do panel de cadrados
     *
     * @param lblSquare Etiqueta co cadrado que se quere borrar do panel
     */
    public void deleteSquare(JLabel lblSquare) {
        panelXogo.remove(lblSquare);
        panelXogo.repaint();
    }

    /**
     * Actualiza na ventá o número de liñas que van feitas no xogo
     *
     * @param numberOfLines Número de liñas feitas no xogo
     */
    public void showNumberOfLines(int numberOfLines) {
        numLiñas.setText(String.valueOf(numberOfLines));
        if (numberOfLines >= 20) {
            timer.setDelay(500);

        }
    }

    public void showGameOver() {
        game = null;
        JOptionPane.showMessageDialog(this, "Fin do xogo");
        timer.stop();

    }

    /**
     * Inicia un novo xogo
     */
    private void startGame() {
        // Limpamos todo o que puidese haber pintado no panel do xogo
        panelXogo.removeAll();
        // Creamos un novo obxecto xogo
        game = new Game(this);
        // Desactivamos o botón de pausa
        tglbtnParar.setSelected(false);
        // Establecemos o número de liñas que se mostran na ventá a cero
        numLiñas.setText("0");
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                // Ao picar no botón de "Abaixo", chamamos ao obxecto xogo para que
                // se mova a peza actual cara abaixo
                if (game != null) {
                    game.movePieceDown();
                }
            }
        };
        timer = new Timer(1000, taskPerformer);
        timer.start();

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_DOWN && ke.getID() == KeyEvent.KEY_PRESSED) {
                    game.movePieceDown();
                }
                if (ke.getKeyCode() == KeyEvent.VK_LEFT && ke.getID() == KeyEvent.KEY_PRESSED) {
                    game.movePieceLeft();
                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT && ke.getID() == KeyEvent.KEY_PRESSED) {
                    game.movePieceRight();
                }
                return false;
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        nome = new javax.swing.JLabel();
        panelXogo =  new JPanelBackground();
        liñas = new javax.swing.JLabel();
        btnNovaPartida = new javax.swing.JButton();
        btnRotar = new javax.swing.JButton();
        btnEsquerda = new javax.swing.JButton();
        btnDereita = new javax.swing.JButton();
        btnAbaixo = new javax.swing.JButton();
        tglbtnParar = new javax.swing.JToggleButton();
        numLiñas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 670));
        getContentPane().setLayout(null);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/Silenciar.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(310, 30, 40, 40);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setOpaque(false);

        nome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nome.setText("Pedro Fontela Cabaleiro");
        getContentPane().add(nome);
        nome.setBounds(20, 10, 200, 25);

        panelXogo.setBackground(new java.awt.Color(255, 255, 255));
        panelXogo.setPreferredSize(new java.awt.Dimension(320, 400));

        javax.swing.GroupLayout panelXogoLayout = new javax.swing.GroupLayout(panelXogo);
        panelXogo.setLayout(panelXogoLayout);
        panelXogoLayout.setHorizontalGroup(
            panelXogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        panelXogoLayout.setVerticalGroup(
            panelXogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(panelXogo);
        panelXogo.setBounds(30, 90, 330, 400);

        liñas.setText("Liñas:");
        getContentPane().add(liñas);
        liñas.setBounds(30, 65, 50, 30);

        btnNovaPartida.setText("Nova partida");
        btnNovaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNovaPartidaMouseClicked(evt);
            }
        });
        btnNovaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPartidaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaPartida);
        btnNovaPartida.setBounds(30, 40, 120, 25);

        btnRotar.setText("Rotar");
        btnRotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRotar);
        btnRotar.setBounds(160, 540, 80, 25);

        btnEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/botonizquierda.png"))); // NOI18N
        btnEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsquerdaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEsquerda);
        btnEsquerda.setBounds(90, 540, 50, 40);

        btnDereita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/botonderecha.png"))); // NOI18N
        btnDereita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDereitaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDereita);
        btnDereita.setBounds(270, 540, 50, 40);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setOpaque(false);

        btnAbaixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/botonabajo.png"))); // NOI18N
        btnAbaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbaixoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbaixo);
        btnAbaixo.setBounds(170, 580, 50, 40);

        tglbtnParar.setText("Parar");
        tglbtnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglbtnPararActionPerformed(evt);
            }
        });
        getContentPane().add(tglbtnParar);
        tglbtnParar.setBounds(200, 40, 80, 25);
        getContentPane().add(numLiñas);
        numLiñas.setBounds(80, 70, 53, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multimedia/BackgroundExterior2.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -170, 1140, 990);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPartidaActionPerformed
        // Ao picar no botón de "Nova partida", invocamos ao método privado 
        // que inicia un novo xogo
        startGame();
    }//GEN-LAST:event_btnNovaPartidaActionPerformed

    private void tglbtnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglbtnPararActionPerformed
        // Ao picar no botón de "Pausa", chamamos ao obxecto xogo para 
        // establecer o atributo de pausa no estado do botón
        if (game != null) {
            game.setPaused(tglbtnParar.isSelected());
        }
    }//GEN-LAST:event_tglbtnPararActionPerformed

    private void btnRotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotarActionPerformed
        // Ao picar no botón de "Rotar", chamamos ao obxecto xogo para que 
        // rote a peza actual
        if (game != null) {
            game.rotatePiece();
        }
    }//GEN-LAST:event_btnRotarActionPerformed

    private void btnEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsquerdaActionPerformed
        // Ao picar no botón de "Esquerda", chamamos ao obxecto xogo para que
        // se mova a peza actual á esquerda
        if (game != null) {
            game.movePieceLeft();
        }
    }//GEN-LAST:event_btnEsquerdaActionPerformed

    private void btnDereitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDereitaActionPerformed
        // Ao picar no botón de "Dereita", chamamos ao obxecto xogo para que
        // se mova a peza actual á dereita
        if (game != null) {
            game.movePieceRight();
        }
    }//GEN-LAST:event_btnDereitaActionPerformed

    private void btnAbaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbaixoActionPerformed

// Ao picar no botón de "Abaixo", chamamos ao obxecto xogo para que
        // se mova a peza actual cara abaixo
        if (game != null) {
            game.movePieceDown();
        }

    }//GEN-LAST:event_btnAbaixoActionPerformed

    private void btnNovaPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaPartidaMouseClicked


    }//GEN-LAST:event_btnNovaPartidaMouseClicked


    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            Sound.stop();

        } else {
            Sound.play();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    //  public void keyReleased(KeyEvent e){
    //     if(e.getKeyCode()==KeyEvent.VK_UP){
    //JOptionPane.showMessageDialog(contentPane, "Has pulsado Enter");
    //       System.out.println("si");
    //   }
    //}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbaixo;
    private javax.swing.JButton btnDereita;
    private javax.swing.JButton btnEsquerda;
    private javax.swing.JButton btnNovaPartida;
    private javax.swing.JButton btnRotar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel liñas;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel numLiñas;
    private javax.swing.JPanel panelXogo;
    private javax.swing.JToggleButton tglbtnParar;
    // End of variables declaration//GEN-END:variables
}
