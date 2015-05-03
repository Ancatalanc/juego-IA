/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoIA;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Celda  extends JComponent implements Constantes{
    
    public BufferedImage player, obstaculo, camino, enemigo, burbuja;
    public BufferedImage soldier[], secuenciaImg;
    //cordenada x y
    public int x;
    public int y;
    public char tipo;
    public boolean select;
    public int indexSprite;
    //anchura altura
    //public int altura;
    //public int anchura;

    //const
    public Celda(int x, int y,char tipo) {
        this.x = x;
        this.y = y;
        this.tipo=tipo;
        //this.altura = x + sizeCell;
        //this.anchura = y + sizeCell;
        try{
            player = ImageIO.read(new File("images/player.png"));
            obstaculo = ImageIO.read(new File("images/obstaculo.png"));
            camino = ImageIO.read(new File("images/camino.png"));
            enemigo = ImageIO.read(new File("images/enemigo.png"));
            burbuja = ImageIO.read(new File("images/burbuja.png"));
            //grupo imagenes
            
            secuenciaImg = ImageIO.read( new File("images/Sprite/soldier.png"));
            soldier = new BufferedImage[ 9 * 4];
            
            for( int i = 0; i < 9; i++){
                for( int j = 0; j < 4; j++){
                    soldier[(i*4) + j] = secuenciaImg.getSubimage(i * sizeCell, j * sizeCell, sizeCell, sizeCell);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    //metodo llamado cuando repaint
    @Override
    public void update(Graphics g){
        switch(tipo){
            //case 'J': g.drawImage(jugador, x, y, this); break;
            case 'J': g.drawImage(soldier[indexSprite], x, y, this); break;
            case 'O': g.drawImage(obstaculo, x, y, this); break;
            //case 'C': g.drawImage(camino, x, y, this); break;
            case 'A': g.drawImage(enemigo, x, y, this); break;
            case 'B':g.drawImage(burbuja, x, y, this); break;
        }
    }
    
    //calcula si el clic esta dentro del area de la celda
    public boolean dentro_area(int xp,int yp){
        Rectangle r=new Rectangle(x,y,sizeCell,sizeCell);
        return r.contains(new Point(xp,yp));
    }
    
    // metodo para dibujar celda
    @Override
    public void paintComponent(Graphics g) {
        switch(tipo){
            //case 'J': g.drawImage(jugador, x, y, this); break;
            case 'J': g.drawImage(soldier[indexSprite], x, y, this); break;
            case 'O': g.drawImage(obstaculo, x, y, this); break;
            case 'C': g.drawImage(camino, x, y, this); break;
            case 'A': g.drawImage(enemigo, x, y, this); break;
            case 'B':g.drawImage(burbuja, x, y, this); break;
        }
     		update(g);
	}
	
	/*public void update(Graphics g){
		if(select){
			g.drawRect(x,y,sizecell,sizecell);
			g.fillRect(x,y,sizecell,sizecell);
		}else{
			g.drawRect(x,y,sizecell,sizecell);

		}
	}*/
}
