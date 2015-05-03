/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import java.util.Random;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Arkgath
 */


public class Enemigo extends TimerTask implements Constantes{
    
    public Laberinto laberinto;
    public int i_player, j_player;
    
    public Enemigo(Laberinto l){
        laberinto=l;
        i_player=heightGameWorld-1;
        j_player=numeroAleatorio(0,widthGameWorld-1);
        laberinto.celdas[i_player][j_player].tipo='A';
    }
    

    
    public void mover_izquierda(){
        if(i_player > 0){
            laberinto.celdas[i_player][j_player].tipo='C';
            i_player-=1;
            laberinto.celdas[i_player][j_player].tipo='A';
        }else{
            laberinto.celdas[i_player][j_player].tipo='C';
            i_player=heightGameWorld-1;
            j_player=numeroAleatorio(0,widthGameWorld-1);
        }
    }
    
    @Override
    public void run(){
        mover_izquierda();
        laberinto.lienzo.repaint();
    }
    
    public int numeroAleatorio(int minimo,int maximo){
        Random random = new Random();
        int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
        return numero_aleatorio;
    }
    
}
