package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class Opening extends JPanel{
	public Opening(){
		setVisible(true);
        int screenWidth =1920;
        int screenHeight = 1080;
        setSize(screenWidth,screenHeight);
        setLayout(null);
	}
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent((java.awt.Graphics) g);
	    Image backgroundImage;
		try {
			backgroundImage = javax.imageio.ImageIO.read(new File("images/1920x1080.jpg"));
			g.drawImage(backgroundImage, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
			
	}
public static void main(String[]args){
	new Opening();
}
}
