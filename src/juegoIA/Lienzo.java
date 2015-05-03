/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static juegoIA.Constantes.heightGameWorld;
import static juegoIA.Constantes.widthGameWorld;

/**
 * Created by Arkgath on 02-05-2015.
 */
public class Lienzo extends JPanel implements Constantes {
    Laberinto laberinto;
    public MusicThread musicplayer;
    public Timer lanzadorTareas;
    public Enemigo enemigoA,enemigoB;
    public Image fondo;
    
    public Graphics graficoAuxiliar;
    public Image imagenAuxiliar;

    public Lienzo() {
        laberinto = new Laberinto(this);
        enemigoA = new Enemigo(laberinto);
        enemigoB = new Enemigo(laberinto);

        //color del fondo
        
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(laberinto.ancho, laberinto.largo);
        
        try{
            fondo= ImageIO.read(new File("images/fondo.jpg"));
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                identificarCelda(evt);
                repaint();
            }
        });
        
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                laberinto.chequearTecla(e);
                repaint();
            }          
        });

        lanzadorTareas=new Timer();
        lanzadorTareas.scheduleAtFixedRate(enemigoA,0,1000);
        lanzadorTareas.scheduleAtFixedRate(enemigoB,0,500);
        
        this.setDoubleBuffered(true);
        
        musicplayer = new MusicThread(ruta+"/BGM/GS2_VenusLighthouse.wav",2);
        musicplayer.run();
    }

    private void identificarCelda(java.awt.event.MouseEvent e){
        for(int i=0;i<heightGameWorld;i++){
            for (int j=0;j<widthGameWorld;j++){
                if(laberinto.celdas[i][j].dentro_area(e.getX(),e.getY())){
                    if ((e.getModifiers() & InputEvent.BUTTON1_MASK)==InputEvent.BUTTON1_MASK){
                        System.out.println("Boton derecho - "+"Poner Obstaculo");
                        laberinto.celdas[i][j].tipo='O';
                    }else{
                        System.out.println("Boton izq"+"poner adversario");
                        laberinto.celdas[i][j].tipo='A';
                    }
                }
            }
        }
    }

    // llamado la primera vez que se 'pinta'
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, null);
        laberinto.paintComponent(g);

    }
/*
    // llamado cuando se 'repinta'
    @Override
    public void update(Graphics g) {
        g.drawImage(fondo, 0, 0, null);
        laberinto.update(g);
    }
*/
    //metodo llamado cuando se repinta
    @Override
    public void update(Graphics g) {
        if(graficoAuxiliar==null){
            imagenAuxiliar=createImage(this.getWidth(),this.getHeight());
            graficoAuxiliar=imagenAuxiliar.getGraphics();

        }
        graficoAuxiliar.setColor(getBackground());
        //graficoAuxiliar.fillRect(fondo,0,0,null);
        laberinto.update(graficoAuxiliar);
        g.drawImage(imagenAuxiliar,0,0,null);

        laberinto.update(g);
    }
    
}
