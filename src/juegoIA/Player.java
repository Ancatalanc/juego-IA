/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import javax.swing.JOptionPane;

/*/**
 *
 * @author Arkgath
 */
public class Player implements Constantes{
    public Laberinto laberinto;
    public int i_player,j_player;
    
    public Player (Laberinto l){
        laberinto=l;
        i_player=0;
        j_player=0;
        l.celdas[i_player][j_player].tipo='J';
    }
    
    public synchronized void mover_arriba(){
    System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        //if(j_player > 0){
            if(laberinto.celdas[i_player][j_player-1].tipo!='O'){
                laberinto.celdas[i_player][j_player].tipo='C';
                j_player-=1;
                if(laberinto.celdas[i_player][j_player].tipo!='A'){
                
                    laberinto.celdas[i_player][j_player].tipo='J';
                    laberinto.celdas[i_player][j_player].indexSprite=4;
                }else{
                    laberinto.lienzo.musicplayer.song.stop();
                    laberinto.lienzo.lanzadorTareas.cancel();
                    JOptionPane.showMessageDialog(null,"GG WP!\n", "Computer Game", JOptionPane.PLAIN_MESSAGE);  
                }
            }
        //}
    }
    
    public synchronized void mover_abajo(){
    System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        //if(j_player < widthGameWorld-1){
            if(laberinto.celdas[i_player][j_player+1].tipo!='O'){
                laberinto.celdas[i_player][j_player].tipo='C';
                j_player+=1;
                if(laberinto.celdas[i_player][j_player].tipo!='A'){
                
                    laberinto.celdas[i_player][j_player].tipo='J';
                    laberinto.celdas[i_player][j_player].indexSprite=2;
                }else{
                    laberinto.lienzo.musicplayer.song.stop();
                    laberinto.lienzo.lanzadorTareas.cancel();
                    JOptionPane.showMessageDialog(null,"GG WP!\n", "Computer Game", JOptionPane.PLAIN_MESSAGE);  
                }
            }
        //}
    }
    
    public synchronized void mover_izquierda(){
    System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        //if(j_jugador > 0){
            if(laberinto.celdas[i_player-1][j_player].tipo!='O'){
                laberinto.celdas[i_player][j_player].tipo='C';
                i_player-=1;
                if(laberinto.celdas[i_player][j_player].tipo!='A'){
                
                    laberinto.celdas[i_player][j_player].tipo='J';
                    laberinto.celdas[i_player][j_player].indexSprite=1;
                }else{
                    laberinto.lienzo.player.song.stop();
                    laberinto.lienzo.lanzadorTareas.cancel();
                    JOptionPane.showMessageDialog(null,"GG WP!\n", "Computer Game", JOptionPane.PLAIN_MESSAGE);  
                }
            }
        //}
    }
    
    public synchronized void mover_derecha(){
    System.out.println("Jugador esta en:"+i_player+" ,"+j_player);
        //if(j_jugador < heightGameWorld-1){
            if(laberinto.celdas[i_player+1][j_player].tipo!='O'){
                laberinto.celdas[i_player][j_player].tipo='C';
                i_player+=1;
                if(laberinto.celdas[i_player][j_player].tipo!='A'){
                
                    laberinto.celdas[i_player][j_player].tipo='J';
                    laberinto.celdas[i_player][j_player].indexSprite=3;
                }else{
                    laberinto.lienzo.player.song.stop();
                    laberinto.lienzo.lanzadorTareas.cancel();
                    JOptionPane.showMessageDialog(null,"GG WP!\n", "Computer Game", JOptionPane.PLAIN_MESSAGE);  
                    
                }
            }
        //}
    }

    /*
    public synchronized void mover_arriba(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(laberinto.celdas[i_jugador][j_jugador-1].tipo!='O'){
            	laberinto.celdas[i_jugador][j_jugador].tipo='C';
                j_jugador-=1;
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible subir");
        }
    }
    */
    /*
    public void mover_abajo(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador < widthGameWorld-1){
            if(laberinto.celdas[i_jugador][j_jugador+1].tipo!='O'){
                laberinto.celdas[i_jugador][j_jugador].tipo='C';
                j_jugador+=1;
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
            }
        }else{
            System.out.println("Imposible bajar");
        }
    }
    */
    /*
    public void mover_izquierda(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(laberinto.celdas[i_jugador-1][j_jugador].tipo!='O'){
            	laberinto.celdas[i_jugador][j_jugador].tipo='C';
                i_jugador-=1;
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
            }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
    */
    /*
    public void mover_derecha(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador < heightGameWorld-1){
            if(laberinto.celdas[i_jugador+1][j_jugador].tipo!='O'){
                laberinto.celdas[i_jugador][j_jugador].tipo='C';
                i_jugador+=1;
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
         }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
    */
}
