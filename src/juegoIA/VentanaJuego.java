/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Arkgath
 */
public class VentanaJuego extends JFrame implements Constantes {

    public Lienzo lienzo;
    
    public JButton btn_music;
    public JButton btn_level;
    public JButton btn_ajustes;
    public JButton btn_ia;
    public JSlider iaPlayer;
    public JSlider iaEnemigo;
    public JLabel lbl_puntuacion;
    public JLabel lbl_nivel;
    public JPanel panelSuperior;
    public JPanel panelLateral;
    public JFrame opciones;
    //HiloMusica musica_juego = new HiloMusica();
    public boolean musica_on;
    public static boolean ia_on;
    public JPanel panel_op;

    public VentanaJuego() {
        

        
        lienzo = new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        
        //Botones
        btn_music = new JButton("Musica On/Off");
        btn_level = new JButton("Nivel");
        btn_ajustes = new JButton("Ajustes");
        btn_ia = new JButton("IA: Activar/Desactivar");
        
        this.setTitle("Laberinto");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo,BorderLayout.CENTER);
        this.setSize(lienzo.getHeight()+25, lienzo.getWidth()+38);
    }
}

