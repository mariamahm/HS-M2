package view;


import java.io.IOException;

import javax.swing.JFrame;


 @SuppressWarnings("serial")
public class GameView extends JFrame {
    	
    
    
    	
	



		public GameView() throws IOException{
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int screenWidth =1920;
        int screenHeight = 1080;//screenSize.height;
        setSize(screenWidth,screenHeight);
        setTitle("HearthStone");
        /*try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("images/background.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
               public void paintComponent(Graphics g) {
                    Image newImage = backgroundImage.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
                    g.drawImage(newImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //opening = new JPanel();
        //opening.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        
        

        
        
        //a.setFont(new java.awt.Font("OldLondon", 2, 24));
        //a.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //this.add(opening);
        this.revalidate();
        this.repaint();
    }
    	


     public static void main(String [] args) throws IOException{
        new GameView();
     }

}
    	