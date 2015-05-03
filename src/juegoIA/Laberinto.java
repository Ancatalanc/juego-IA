/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Pedro on 02-05-2015.
 */
public class Laberinto extends JComponent implements Constantes {

    public int ancho,largo;
    //las casillas n x m
    public Celda[][] celdas;
    //public int i_player,j_player;
    public Lienzo lienzo;
    Player player;

    public Laberinto(Lienzo li){
        lienzo=li;
        celdas = new Celda[heightGameWorld][widthGameWorld];
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++) {
                celdas[i][j] = new Celda(i + (i * sizeCell), j + (j * sizeCell), 'C');
            }
        }
        
        player=new Player(this);
        
        //Indico donde esta el jugador
        /*
        i_player=0;
        j_player=0;
        celdas[i_player][j_player].tipo='J';
        */
        this.ancho = widthGameWorld * sizeCell;
        this.largo = heightGameWorld * sizeCell;
        this.setSize(ancho, largo);
    }
    
    /*
    public void mover_arriba(){
        System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        if(j_player > 0){
            if(celdas[i_player][j_player-1].tipo!='O'){
                celdas[i_player][j_player].tipo='C';
                j_player-=1;
                celdas[i_player][j_player].tipo='J';
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible subir");
        }
    }
    
    public void mover_abajo(){
        System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        if(j_jugador < widthGameWorld-1){
            if(celdas[i_player][j_player+1].tipo!='O'){
                celdas[i_player][j_player].tipo='C';
                j_player+=1;
                celdas[i_player][j_player].tipo='J';
            }
        }else{
            System.out.println("Imposible bajar");
        }
    }
    
    public void mover_izquierda(){
        System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        if(j_player > 0){
            if(celdas[i_player-1][j_player].tipo!='O'){
                celdas[i_player][j_player].tipo='C';
                i_player-=1;
                celdas[i_player][j_player].tipo='J';
            }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
    
    public void mover_derecha(){
        System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        if(j_player < heightGameWorld-1){
            if(celdas[i_player+1][j_player].tipo!='O'){
                celdas[i_player][j_player].tipo='C';
                i_player+=1;
                celdas[i_player][j_player].tipo='J';
            }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
 */
    public void chequearTecla(KeyEvent evento){
        if ( evento.getKeyCode() == 38){
            System.out.println("Mover arriba");
            player.mover_arriba();
        }
        if ( evento.getKeyCode() == 40){
            System.out.println("Mover abajo");
            player.mover_abajo();
        }
        if ( evento.getKeyCode() == 37){
            System.out.println("Mover izquierda");
            player.mover_izquierda();
        }
        if ( evento.getKeyCode() == 39){
            System.out.println("Mover derecha");
            player.mover_derecha();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //update(g);
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++) {
                celdas[i][j].paintComponent(g);
            }
        }
    }
    
@Override
    public void update(Graphics g){
        for(int i=0;i<heightGameWorld;i++){
            for(int j=0;j<widthGameWorld;j++){
                //if(celdas[i][j].select){
                celdas[i][j].update(g);
                //}
            }
        }
    }


}

