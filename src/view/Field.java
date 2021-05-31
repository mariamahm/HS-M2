package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Field extends JPanel{
	 JLabel currenthp2;
	 private JLabel drawcard1 , drawcardtxt, useheropower1,useheropowertxt;
	 JLabel currenthp ;
	public Field() throws IOException{
		setVisible(true);
        int screenWidth =1920;
        int screenHeight = 1080;
        setSize(screenWidth,screenHeight);
        setLayout(null);
        ImageIcon drawcardbg = new ImageIcon(new ImageIcon("images/drawcard.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
		drawcardtxt= new JLabel();
		drawcardtxt.setIcon(drawcardbg);
		drawcardtxt.setBounds(50,380,170,170);
		//add(drawcardtxt);
		
		ImageIcon heropobg = new ImageIcon(new ImageIcon("images/heropower.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));
		useheropower1=new JLabel();
		useheropower1.setBounds(1700,410,170,170);
		useheropower1.setIcon(heropobg);
        add(useheropower1);
        
        currenthp = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/health-transparent-hearth-6.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        currenthp.setBounds(1000,650,286,395);
        currenthp.setIcon(imageIcon);
        add(currenthp);
        
         currenthp2 = new JLabel();
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("images/health-transparent-hearth-6.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        currenthp2.setBounds(1000,38,286,395);
        currenthp2.setIcon(imageIcon2);
        add(currenthp2);
       
		
	}
	
	
	

	public JLabel getCurrenthp2() {
		return currenthp2;
	}



	public JLabel getCurrenthp() {
		return currenthp;
	}



	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent((java.awt.Graphics) g);
	    Image backgroundImage;
		try {
			backgroundImage = javax.imageio.ImageIO.read(new File("images/Uldaman_Board(1).png"));
			g.drawImage(backgroundImage, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	public static void main(String [] args) throws IOException{
		new Field();
	}


}
