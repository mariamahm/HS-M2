package view;

import java.awt.*;

import javax.swing.*;

public class hand extends JPanel{
	
	
	public hand(){
	setSize(1920,500);
	setLayout(new FlowLayout());
	setOpaque(false);
	for(int i=0;i<10;i++){
		JLabel Card1=new JLabel();
		ImageIcon heropobg = new ImageIcon(new ImageIcon("images/EMPTY.jpg").getImage().getScaledInstance(130, 180, Image.SCALE_DEFAULT));
    	Card1.setIcon(heropobg);
		add(Card1,FlowLayout.LEFT);
	}
	
	
	
	
	}
	
	public static void main(String[]args){
		JFrame f=new JFrame();
		f.setSize(1920,1080);
		f.setVisible(true);
		f.add(new hand(),BorderLayout.SOUTH);
		f.pack();
		
	}
}
