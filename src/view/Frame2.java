package view;
import java.awt.Font;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Frame2 extends JPanel{
	

	public Frame2() throws IOException{
		
		setVisible(true);
        int screenWidth =1920;
        int screenHeight = 1080;
        setSize(screenWidth,screenHeight);
        setLayout(null);
        /*BufferedImage background = ImageIO.read(new File("images/background.jpg"));
        JLabel bg = new JLabel(new ImageIcon(background));
        bg.setBounds(0,0,1920,1080);
        f2.add(bg);*/
        JLabel title= new JLabel("Player 1 Choose Your Hero");
        title.setBounds(460,90, 1920, 100);
        title.setFont(new Font("Algerian", Font.BOLD,65));
        title.setForeground(new Color(218,165,32));
       // title.setfo
        add(title);
        BufferedImage myPicture1 = ImageIO.read(new File("images/Jaina_Proudmoore.png"));
        JLabel mage = new JLabel(new ImageIcon(myPicture1));
        mage.setBounds(50,500,286,395);
        BufferedImage myPicture = ImageIO.read(new File("images/Rexxar.png"));
        JLabel rexaar = new JLabel(new ImageIcon(myPicture));
        rexaar.setBounds(400,500,286,395);
        BufferedImage myPicture2 = ImageIO.read(new File("images/Uther_Lightbringer.png"));
        JLabel paladin = new JLabel(new ImageIcon(myPicture2));
        paladin.setBounds(750,500,286,395);
        BufferedImage myPicture3 = ImageIO.read(new File("images/priest.png"));
        JLabel priest = new JLabel(new ImageIcon(myPicture3));
        priest.setBounds(1150,500,286,395);
        BufferedImage myPicture4 = ImageIO.read(new File("images/warlock.png"));
        JLabel warlock = new JLabel(new ImageIcon(myPicture4));
        warlock.setBounds(1550,500,286,395);
        add(mage);
        add(rexaar);
        add(paladin);
        add(priest);
        add(warlock);
        revalidate();
        repaint();
	}
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent((java.awt.Graphics) g);
	    Image backgroundImage;
		try {
			backgroundImage = javax.imageio.ImageIO.read(new File("images/1376129.jpg"));
			g.drawImage(backgroundImage, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
			
	}
	
	public static void main(String [] args) throws IOException{
		new Frame2();
	}
}
