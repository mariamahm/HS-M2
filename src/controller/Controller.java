package controller;

import engine.Game;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.minions.MinionListener;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.HeroListener;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import view.Opening;
import view.Player2;
import view.Frame2;
import view.Field;
import view.GameView;
public class Controller implements ActionListener, GameListener{
    private int x;    
	private GameView view=new GameView();
	private int indexattack;
	private JLabel remain;
        private Game game;
        private Card Selected;
        private Minion AttackerMinion;
        private Spell SelectedSpell;
        private CardLayout Layout=new CardLayout();
        private JPanel opening=new Opening();
        private JPanel Parent=new JPanel();
        private JPanel Frame2=new Frame2();
        private JPanel Player2=new Player2();
        private JPanel field= new Field();
        private JButton mage,hunter,paladin,priest,warlock,heroup,herodown;
        private JButton mage2,hunter2,paladin2,priest2,warlock2;
        private Hero p1;
		private Hero p2;
        private JLabel name,name2;
        private JLabel currenthp,currenthp2;
        private JLabel Card1,Card2,Card3,Card4,Card5,Card6,Card7,Card8,Card9,Card10,Card12,Card22,Card32,Card42,
        Card52,Card62,Card72,Card82,Card92,Card102;
        private JLabel mc1,mc2,mc3,mc4,mc5,mc6,mc7,mc8,mc9,mc10 ;
        private JLabel mc12,mc22,mc32,mc42,mc52,mc62,mc72,mc82,mc92,mc102 ;
        private ArrayList <JButton> button=new ArrayList<JButton> ();
        private ArrayList <JLabel> mc=new ArrayList<JLabel> ();
        private JLabel card=new JLabel();
        private ArrayList <JLabel> cards=new ArrayList<JLabel>();
        private ArrayList <JLabel> cards2=new ArrayList<JLabel>();
        private JButton endturn;
        private JButton drawcard;
        private JButton useheropower;
        private JButton bcard1,bcard2,bcard3,bcard4,bcard5,bcard6,bcard7,bcard8,bcard9,bcard10,bcard12,bcard22,bcard32,
        bcard42,bcard52,bcard62,bcard72,bcard82,bcard92,bcard102;
        private ArrayList<JButton> cardbuttons1=new ArrayList<JButton> ();
        private ArrayList<JButton> cardbuttons2=new ArrayList<JButton> ();
        private JLabel Cardbg1,Cardbg2,Cardbg3,Cardbg4,Cardbg5,Cardbg6,Cardbg7,Cardbg12,Cardbg22,Cardbg32,Cardbg42,
        Cardbg52,Cardbg62,Cardbg72,pointerdown,pointerup;
        private ArrayList <JLabel> cardbg1=new ArrayList<JLabel>();
        private ArrayList <JLabel> cardbg2=new ArrayList<JLabel>();
        private JButton bcardbg1,bcardbg2,bcardbg3,bcardbg4,bcardbg5,bcardbg6,bcardbg7,bcardbg12,bcardbg22,bcardbg32,
        bcardbg42,bcardbg52,bcardbg62,bcardbg72;
        private ArrayList<JButton> cardbuttonsbg1=new ArrayList<JButton> ();
        private ArrayList<JButton> cardbuttonsbg2=new ArrayList<JButton> ();
        
        public Controller() throws IOException, FullHandException, CloneNotSupportedException{
		
        	Parent.setLayout(Layout);
        	remain=new JLabel();
        	   remain.setBounds(50,380,170,170);
        	   field.add(remain);
        	ImageIcon down= new ImageIcon(new ImageIcon("images/down.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
            pointerdown=new JLabel();
            pointerdown.setIcon(down);
            pointerdown.setBounds(905,0,100,100);
            pointerdown.setVisible(false);
            field.add(pointerdown);
            heroup=new JButton();
            herodown=new JButton();
            herodown.setBounds(855, 670, 200, 200);
            heroup.setBounds(845, 67, 180, 220);
            heroup.setOpaque(false);
        	heroup.setContentAreaFilled(false);
        	heroup.setBorderPainted(false);
            herodown.setOpaque(false);
        	herodown.setContentAreaFilled(false);
        	herodown.setBorderPainted(false);
            field.add(heroup);
            field.add(herodown);
            ImageIcon up= new ImageIcon(new ImageIcon("images/up.png").getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
            pointerup=new JLabel();
            pointerup.setIcon(up);
            pointerup.setBounds(905,900,100,100);
            pointerup.setVisible(false);
            field.add(pointerup);
        	ImageIcon manacrystal = new ImageIcon(new ImageIcon("images/mana crystals.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        	mc1=new JLabel();
        	mc2=new JLabel();
        	mc3=new JLabel();
        	mc4=new JLabel();
        	mc5=new JLabel();
        	mc6=new JLabel();
        	mc7=new JLabel();
        	mc8=new JLabel();
        	mc9=new JLabel();
        	mc10=new JLabel();
        	mc12=new JLabel();
        	mc22=new JLabel();
        	mc32=new JLabel();
        	mc42=new JLabel();
        	mc52=new JLabel();
        	mc62=new JLabel();
        	mc72=new JLabel();
        	mc82=new JLabel();
        	mc92=new JLabel();
        	mc102=new JLabel();
        	mc.add(mc1);
        	mc.add(mc2);
        	mc.add(mc3);
        	mc.add(mc4);
        	mc.add(mc5);
        	mc.add(mc6);
        	mc.add(mc7);
        	mc.add(mc8);
        	mc.add(mc9);
        	mc.add(mc10);
        	mc.add(mc12);
        	mc.add(mc22);
        	mc.add(mc32);
        	mc.add(mc42);
        	mc.add(mc52);
        	mc.add(mc62);
        	mc.add(mc72);
        	mc.add(mc82);
        	mc.add(mc92);
        	mc.add(mc102);
        	for(int i=0;i<mc.size();i++){
        		
        		
        		if(i==0||i==10)
        			mc.get(i).setIcon(manacrystal);
        		else{
        			mc.get(i).setIcon(manacrystal);
        			mc.get(i).setVisible(false);
        		}
        		
        		
        	}
        	mc1.setBounds(1555,550,40,40);
        	mc2.setBounds(1555,580,40,40);
        	mc3.setBounds(1555,610,40,40);
        	mc4.setBounds(1555,640,40,40);
        	mc5.setBounds(1555,670,40,40);
        	mc6.setBounds(1585,550,40,40);
        	mc7.setBounds(1585,580,40,40);
        	mc8.setBounds(1585,610,40,40);
        	mc9.setBounds(1585,640,40,40);
        	mc10.setBounds(1585,670,40,40);
        	
        	
        	mc12.setBounds(1550,260,40,40);
        	mc22.setBounds(1550,290,40,40);
        	mc32.setBounds(1550,320,40,40);
        	mc42.setBounds(1550,350,40,40);
        	mc52.setBounds(1550,380,40,40);
        	
        	
        	mc62.setBounds(1580,260,40,40);
        	mc72.setBounds(1580,290,40,40);
        	mc82.setBounds(1580,320,40,40);
        	mc92.setBounds(1580,350,40,40);
        	mc102.setBounds(1580,380,40,40);
        	
        	for(int i=0;i<20;i++){
        		field.add(mc.get(i));
        		
        	}
        	Card1=new JLabel();
            Card1.setBounds(150,820,300,300);
            Card2=new JLabel();
            Card2.setBounds(290,820,300,300);
            Card3=new JLabel();
            Card3.setBounds(430,820,300,300);
            Card4=new JLabel();
            Card4.setBounds(570,820,300,300);
            Card5=new JLabel();
            Card5.setBounds(710,820,300,300);
            Card6=new JLabel();
            Card6.setBounds(1090,820,300,300);
            Card7=new JLabel();
            Card7.setBounds(1230,820,300,300);
            Card8=new JLabel();
            Card8.setBounds(1370,820,300,300);
            Card9=new JLabel();
            Card9.setBounds(1510,820,300,300);
            Card10=new JLabel();
            Card10.setBounds(1650,820,300,300);
            Card12=new JLabel();
            Card12.setBounds(150,0,130,180);
            Card22=new JLabel();
            Card22.setBounds(290,0,130,180);
            Card32=new JLabel();
            Card32.setBounds(430,0,130,180);
            Card42=new JLabel();
            Card42.setBounds(570,0,130,180);
            Card52=new JLabel();
            Card52.setBounds(710,0,130,180);
            Card62=new JLabel();
            Card62.setBounds(1090,0,130,180);
            Card72=new JLabel();
            Card72.setBounds(1230,0,130,180);
            Card82=new JLabel();
            Card82.setBounds(1370,0,130,180);
            Card92=new JLabel();
            Card92.setBounds(1510,0,130,180);
            Card102=new JLabel();
            Card102.setBounds(1650,0,130,180);
        cards.add(Card1);
        cards.add(Card2);
        cards.add(Card3);
        cards.add(Card4);
        cards.add(Card5);
        cards.add(Card6);
        cards.add(Card7);
        cards.add(Card8);
        cards.add(Card9);
        cards.add(Card10);
        cards2.add(Card12);
        cards2.add(Card22);
        cards2.add(Card32);
        cards2.add(Card42);
        cards2.add(Card52);
        cards2.add(Card62);
        cards2.add(Card72);
        cards2.add(Card82);
        cards2.add(Card92);
        cards2.add(Card102);
        heroup.addActionListener(this);
        herodown.addActionListener(this);
        for(int i=0;i<cards.size();i++){
        	ImageIcon heropobg = new ImageIcon(new ImageIcon("images/EMPTY.jpg").getImage().getScaledInstance(130, 180, Image.SCALE_DEFAULT));
        	cards.get(i).setIcon(heropobg);
        	cards.get(i).setVisible(false);
        	field.add(cards.get(i));
        	
        }
        for(int i=0;i<cards2.size();i++){
        	ImageIcon heropobg = new ImageIcon(new ImageIcon("images/EMPTY.jpg").getImage().getScaledInstance(130, 180, Image.SCALE_DEFAULT));
        	cards2.get(i).setIcon(heropobg);
        	cards2.get(i).setVisible(false);
        	field.add(cards2.get(i));
        	
        }
        //b
        
        
        
        
        //buttons for cards
        bcard1=new JButton();
        bcard1.setBounds(150,880,130,150);
        bcard2=new JButton();
        bcard2.setBounds(290,880,130,150);
        bcard3=new JButton();
        bcard3.setBounds(430,880,130,150);
        bcard4=new JButton();
        bcard4.setBounds(570,880,130,150);
        bcard5=new JButton();
        bcard5.setBounds(710,880,130,150);
        bcard6=new JButton();
        bcard6.setBounds(1090,880,130,150);
        bcard7=new JButton();
        bcard7.setBounds(1230,880,130,150);
        bcard8=new JButton();
        bcard8.setBounds(1370,880,130,150);
        bcard9=new JButton();
        bcard9.setBounds(1510,880,130,150);
        bcard10=new JButton();
        bcard10.setBounds(1650,880,130,150);
        bcard12=new JButton();
        bcard12.setBounds(150,0,130,150);
        bcard22=new JButton();
        bcard22.setBounds(290,0,130,150);
        bcard32=new JButton();
        bcard32.setBounds(430,0,130,150);
        bcard42=new JButton();
        bcard42.setBounds(570,0,130,150);
        bcard52=new JButton();
        bcard52.setBounds(710,0,130,150);
        bcard62=new JButton();
        bcard62.setBounds(1090,0,130,150);
        bcard72=new JButton();
        bcard72.setBounds(1230,0,130,150);
        bcard82=new JButton();
        bcard82.setBounds(1370,0,130,150);
        bcard92=new JButton();
        bcard92.setBounds(1510,0,130,150);
        bcard102=new JButton();
        bcard102.setBounds(1650,0,130,150);
        cardbuttons1.add(bcard1);
        cardbuttons1.add(bcard2);
        cardbuttons1.add(bcard3);
        cardbuttons1.add(bcard4);
        cardbuttons1.add(bcard5);
        cardbuttons1.add(bcard6);
        cardbuttons1.add(bcard7);
        cardbuttons1.add(bcard8);
        cardbuttons1.add(bcard9);
        cardbuttons1.add(bcard10);
        cardbuttons2.add(bcard12);
        cardbuttons2.add(bcard22);
        cardbuttons2.add(bcard32);
        cardbuttons2.add(bcard42);
        cardbuttons2.add(bcard52);
        cardbuttons2.add(bcard62);
        cardbuttons2.add(bcard72);
        cardbuttons2.add(bcard82);
        cardbuttons2.add(bcard92);
        cardbuttons2.add(bcard102);
        
     // cards for the battleground
        Cardbg1=new JLabel();
        Cardbg1.setBounds(450,450,300,300);
       cardbg1.add(Cardbg1);
        Cardbg2=new JLabel();
        Cardbg2.setBounds(600,450,300,300);
        cardbg1.add(Cardbg2);
        Cardbg3=new JLabel();
        Cardbg3.setBounds(750,450,300,300);
        cardbg1.add(Cardbg3);
        Cardbg4=new JLabel();
        Cardbg4.setBounds(900,450,300,300);
        cardbg1.add(Cardbg4);
        Cardbg5=new JLabel();
        Cardbg5.setBounds(1050,450,300,300);
        cardbg1.add(Cardbg5);
        Cardbg6=new JLabel();
        Cardbg6.setBounds(1200,450,300,300);
        cardbg1.add(Cardbg6);
        Cardbg7=new JLabel();
        Cardbg7.setBounds(1350,450,300,300);
        cardbg1.add(Cardbg7);
        
        Cardbg12=new JLabel();
        Cardbg12.setBounds(450,250,300,300);
       cardbg2.add(Cardbg12);
        Cardbg22=new JLabel();
        Cardbg22.setBounds(600,250,300,300);
        cardbg2.add(Cardbg22);
        Cardbg32=new JLabel();
        Cardbg32.setBounds(750,250,300,300);
        cardbg2.add(Cardbg32);
        Cardbg42=new JLabel();
        Cardbg42.setBounds(900,250,300,300);
        cardbg2.add(Cardbg42);
        Cardbg52=new JLabel();
        Cardbg52.setBounds(1050,250,300,300);
        cardbg2.add(Cardbg52);
        Cardbg62=new JLabel();
        Cardbg62.setBounds(1200,250,300,300);
        cardbg2.add(Cardbg62);
        Cardbg72=new JLabel();
        Cardbg72.setBounds(1350,250,300,300);
        cardbg2.add(Cardbg72);
         // buttons for the battleground cards
        bcardbg1=new JButton();
        bcardbg1.setBounds(450,520,130,180);
        cardbuttonsbg1.add(bcardbg1);
        bcardbg2=new JButton();
        bcardbg2.setBounds(600,520,130,180);
        cardbuttonsbg1.add(bcardbg2);
        bcardbg3=new JButton();
        bcardbg3.setBounds(750,520,130,180);
        cardbuttonsbg1.add(bcardbg3); 
        bcardbg4=new JButton();
        bcardbg4.setBounds(900,520,130,180);
        cardbuttonsbg1.add(bcardbg4); 
        bcardbg5=new JButton();
        bcardbg5.setBounds(1050,520,130,180);
        cardbuttonsbg1.add(bcardbg5);
        bcardbg6=new JButton();
        bcardbg6.setBounds(1200,520,130,180);
        cardbuttonsbg1.add(bcardbg6);
        bcardbg7=new JButton();
        bcardbg7.setBounds(1350,520,130,180);
        cardbuttonsbg1.add(bcardbg7);
        
        bcardbg12=new JButton();
        bcardbg12.setBounds(450,300,130,180);
        cardbuttonsbg2.add(bcardbg12);
        bcardbg22=new JButton();
        bcardbg22.setBounds(600,300,130,180);
        cardbuttonsbg2.add(bcardbg22);
        bcardbg32=new JButton();
        bcardbg32.setBounds(750,300,130,180);
        cardbuttonsbg2.add(bcardbg32); 
        bcardbg42=new JButton();
        bcardbg42.setBounds(900,300,130,180);
        cardbuttonsbg2.add(bcardbg42); 
        bcardbg52=new JButton();
        bcardbg52.setBounds(1050,300,130,180);
        cardbuttonsbg2.add(bcardbg52);
        bcardbg62=new JButton();
        bcardbg62.setBounds(1200,300,130,180);
        cardbuttonsbg2.add(bcardbg62);
        bcardbg72=new JButton();
        bcardbg72.setBounds(1350,300,130,180);
        cardbuttonsbg2.add(bcardbg72);
        
        for(int i=0;i<cardbg1.size();i++){
        	ImageIcon heropobg = new ImageIcon(new ImageIcon("images/EMPTY.jpg").getImage().getScaledInstance(130, 180, Image.SCALE_DEFAULT));
        	cardbg1.get(i).setIcon(heropobg);
        	cardbg1.get(i).setVisible(false);
        	field.add(cardbg1.get(i));
        }
        for(int i=0;i<cardbg2.size();i++){
        	ImageIcon heropobg = new ImageIcon(new ImageIcon("images/EMPTY.jpg").getImage().getScaledInstance(130, 180, Image.SCALE_DEFAULT));
        	cardbg2.get(i).setIcon(heropobg);
        	cardbg2.get(i).setVisible(false);
        	field.add(cardbg2.get(i));
        }
        
        for(int i=0; i<cardbuttonsbg1.size();i++){
        	field.add(cardbuttonsbg1.get(i));
        	cardbuttonsbg1.get(i).setOpaque(false);
        	cardbuttonsbg1.get(i).setContentAreaFilled(false);
        	cardbuttonsbg1.get(i).setBorderPainted(false);
        }
        for(int i=0; i<cardbuttonsbg2.size();i++){
        	field.add(cardbuttonsbg2.get(i));
        	cardbuttonsbg2.get(i).setOpaque(false);
        	cardbuttonsbg2.get(i).setContentAreaFilled(false);
        	cardbuttonsbg2.get(i).setBorderPainted(false);
        }
        for(int i=0; i<cardbuttons1.size();i++){
        	field.add(cardbuttons1.get(i));
        	cardbuttons1.get(i).setOpaque(false);
        	cardbuttons1.get(i).setContentAreaFilled(false);
        	cardbuttons1.get(i).setBorderPainted(false);
        }
        
        for(int i=0; i<cardbuttons2.size();i++){
        	field.add(cardbuttons2.get(i));
        	cardbuttons2.get(i).setOpaque(false);
        	cardbuttons2.get(i).setContentAreaFilled(false);
        	cardbuttons2.get(i).setBorderPainted(false);
        }
       
        
        	
        	
        	
        	// all buttons for the heros
		mage=new JButton("mage");
		hunter=new JButton("hunter");
		paladin=new JButton("paladin");
		priest=new JButton("priest");
		warlock=new JButton("warlock");
		
		mage.setBounds(80,520,220,300);
		hunter.setBounds(430,520,220,300);
		paladin.setBounds(780,520,220,300);
		priest.setBounds(1180,520,220,300);
		warlock.setBounds(1580,520,220,300);
		
		Frame2.add(mage);
		Frame2.add(hunter);
		Frame2.add(paladin);
		Frame2.add(priest);
		Frame2.add(warlock);
		//all buttons for player 2
		mage2=new JButton("mage");
		hunter2=new JButton("hunter");
		paladin2=new JButton("paladin");
		priest2=new JButton("priest");
		warlock2=new JButton("warlock");
		
		mage2.setBounds(80,520,220,300);
		hunter2.setBounds(430,520,220,300);
		paladin2.setBounds(780,520,220,300);
		priest2.setBounds(1180,520,220,300);
		warlock2.setBounds(1580,520,220,300);
		
		Player2.add(mage2);
		Player2.add(hunter2);
		Player2.add(warlock2);
		Player2.add(priest2);
		Player2.add(paladin2);
		
		endturn = new JButton();
		endturn.setBounds(1475,460,160,50);
		
		field.add(endturn);
		
		
		useheropower=new JButton();
		//useheropower.setIcon(heropobg);
	
		useheropower.setBounds(1700,460,160,50);
		field.add(useheropower);
		drawcard=new JButton();
		drawcard.setBounds(50,430,200,410);

		//field.add(drawcard);
		
		
		
		//management of Panels
		ImageIcon startbg= new ImageIcon("images/pngguru.com.png");
		JButton start= new JButton("",startbg);
		start.setBounds(100,100,500,500);
		opening.add(start);
		Parent.add(opening,"1");
		view.add(Parent);
		Parent.add(Frame2,"2");
		Parent.add(Player2,"3");
		Parent.add(field,"4");
		Layout.show(Parent,"1");
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Layout.show(Parent,"2");
            }
        });
		button.add(mage);
    	button.add(mage2);
    	button.add(hunter);
    	button.add(hunter2);
    	button.add(paladin);
    	button.add(paladin2);
    	button.add(priest);
    	button.add(priest2);
    	button.add(warlock);
    	button.add(warlock2);
    	button.add(endturn);
    	button.add(drawcard);
    	button.add(useheropower);
    	for(int i=0;i<button.size();i++){
    		button.get(i).setOpaque(false);
    		button.get(i).setContentAreaFilled(false);
    		button.get(i).setBorderPainted(false);
    		button.get(i).addActionListener(this);
    		
    	}
    	 ImageIcon drawcardbg = new ImageIcon(new ImageIcon("images/Azeroth_is_Burning_-card-back.gif").getImage().getScaledInstance(286, 395, Image.SCALE_DEFAULT));
  		JLabel card= new JLabel();
  		card.setIcon(drawcardbg);
  		card.setBounds(0,450,286,396);
  		field.add(card);

		
		view.revalidate();
		view.repaint();
	}
	
	
	public static void main(String [] args) throws IOException, FullHandException, CloneNotSupportedException{
		new Controller();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mage){
			try {
				p1=new Mage();
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-d5afc394f74a93135ce534db22f21c74.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 555, 400, 450);
	            field.add(lblGif);
	            
				Layout.show(Parent,"3");
			} catch (IOException | CloneNotSupportedException e1) {

				e1.printStackTrace();
			}
		}
		else if(e.getSource()==hunter){
			try {
				p1=new Hunter();
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-0295ee927a37247204d8bfac5a3233e9.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 555, 400, 450);
	            field.add(lblGif);
				Layout.show(Parent,"3");
	
			} catch (IOException | CloneNotSupportedException e1) {
				
				e1.printStackTrace();
			}}
		else if(e.getSource()==paladin){
			try {
				p1=new Paladin();
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-84caa6fee6ca06162b5dffbfce4e0d2a.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 555, 400, 450);
	            field.add(lblGif);
				Layout.show(Parent,"3");
			} catch (IOException | CloneNotSupportedException e1) {
				
				e1.printStackTrace();
			}}
		else if(e.getSource()==warlock){
			try {
					p1=new Warlock();
					URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-fa7e649166e693338bac54c2ce9a0b42.gif");
		            ImageIcon imgGif = new ImageIcon(url);
		            JLabel lblGif = new JLabel();
		            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
		            lblGif.setIcon(imgGif);
		            lblGif.setBounds(845, 555, 400, 450);
		            field.add(lblGif);
				Layout.show(Parent,"3");
			} catch (IOException | CloneNotSupportedException e1) {
				
				e1.printStackTrace();
			}}
		else if(e.getSource()==priest){
			try {
				p1=new Priest();
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-ae6138402ffa0d4eed98afcc03ded23a.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 555, 400, 450);
	            field.add(lblGif);
				Layout.show(Parent,"3");
			} catch (IOException | CloneNotSupportedException e1) {
				
				e1.printStackTrace();
			}}
		else if(e.getSource()==mage2){
			try {
				p2=new Mage();
				game=new Game(p1,p2);
				JLabel remain= new JLabel();
		        remain.setBounds(50,380,170,170);
		        int num=game.getCurrentHero().getDeck().size();
		        remain.setText("Cards In Deck: "+num);
				if( game.getCurrentHero()==p1){
					showforplayer(3,cards,p1);
					pointerup.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);

					showforplayer(4,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					cardbuttons2.get(3).setVisible(true);
					cardbuttons2.get(3).addActionListener(this);
					
				}
				else {
					showforplayer(4,cards,p1);
					pointerdown.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					cardbuttons1.get(3).setVisible(true);
					cardbuttons1.get(3).addActionListener(this);
					showforplayer(3,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					
				}
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-d5afc394f74a93135ce534db22f21c74.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 47, 200, 250);
	            field.add(lblGif);
	            name=new JLabel(""+p1.getName());
	            name.setBounds(873, 675, 350, 450);
	            name.setFont(new Font("Algerian", Font.BOLD,20));
	            name.setForeground(new Color(218,165,32));
	            field.add(name);
	            currenthp=new JLabel("HP: "+p1.getCurrentHP());
                currenthp.setBounds(740,630,286,395);
	            currenthp.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp.setForeground(new Color(218,165,32));
	            field.add(currenthp);    
	            JLabel name2=new JLabel(""+p2.getName());
	            name2.setBounds(870,60, 350, 450);
	            name2.setFont(new Font("Algerian", Font.BOLD,20));
	            name2.setForeground(new Color(218,165,32));
	            currenthp2=new JLabel("HP: "+p2.getCurrentHP());
                currenthp2.setBounds(640,10,286,395);
	            currenthp2.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp2.setForeground(new Color(218,165,32));
	            field.add(name2);
	            currenthp2.setHorizontalAlignment(JLabel.CENTER);
	           field.add(currenthp2);
				Layout.show(Parent,"4");
			} catch (IOException | CloneNotSupportedException | FullHandException e1) {
				
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==hunter2){
			try {
				p2=new Hunter();
				game=new Game(p1,p2);
		        int num=game.getCurrentHero().getDeck().size();
		        remain.setText("Cards In Deck: "+num);
				if( game.getCurrentHero()==p1){
					showforplayer(3,cards,p1);
					pointerup.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					

					showforplayer(4,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					cardbuttons2.get(3).setVisible(true);
					cardbuttons2.get(3).addActionListener(this);
					
				}
				else {
					showforplayer(4,cards,p1);
					cardbuttons1.get(0).setVisible(true);
					pointerdown.setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					cardbuttons1.get(3).setVisible(true);
					cardbuttons1.get(3).addActionListener(this);
					showforplayer(3,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					
				}
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-0295ee927a37247204d8bfac5a3233e9.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 47, 200, 250);
	            field.add(lblGif);
	            name=new JLabel(""+p1.getName());
	            name.setBounds(873, 675, 350, 450);
	            name.setFont(new Font("Algerian", Font.BOLD,20));
	            name.setForeground(new Color(218,165,32));
	            field.add(name);
	            currenthp=new JLabel("HP: "+p1.getCurrentHP());
                currenthp.setBounds(740,630,286,395);
	            currenthp.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp.setForeground(new Color(218,165,32));
	            field.add(currenthp);    
	            JLabel name2=new JLabel(""+p2.getName());
	            name2.setBounds(870,60, 350, 450);
	            name2.setFont(new Font("Algerian", Font.BOLD,20));
	            name2.setForeground(new Color(218,165,32));
	            currenthp2=new JLabel("HP: "+p2.getCurrentHP());
                currenthp2.setBounds(640,10,286,395);
	            currenthp2.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp2.setForeground(new Color(218,165,32));
	            field.add(name2);
	           field.add(currenthp2);
				Layout.show(Parent,"4");
			} catch (IOException | CloneNotSupportedException | FullHandException e1) {
				
				e1.printStackTrace();
			}}
		else if(e.getSource()==paladin2){
			try {
				p2=new Paladin();
				game=new Game(p1,p2);
				
		        int num=game.getCurrentHero().getDeck().size();
		        remain.setText("Cards In Deck: "+num);
				if( game.getCurrentHero()==p1){
					showforplayer(3,cards,p1);
					pointerup.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					

					showforplayer(4,cards2,p2);
					
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					cardbuttons2.get(3).setVisible(true);
					cardbuttons2.get(3).addActionListener(this);
					
				}
				else {
					showforplayer(4,cards,p1);
					pointerdown.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					cardbuttons1.get(3).setVisible(true);
					cardbuttons1.get(3).addActionListener(this);
					showforplayer(3,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					
				}
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-84caa6fee6ca06162b5dffbfce4e0d2a.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 47, 200, 250);
	            field.add(lblGif);
	            name=new JLabel(""+p1.getName());
	            name.setBounds(873, 675, 350, 450);
	            name.setFont(new Font("Algerian", Font.BOLD,20));
	            name.setForeground(new Color(218,165,32));
	            field.add(name);
	            currenthp=new JLabel("HP: "+p1.getCurrentHP());
                currenthp.setBounds(740,630,286,395);
	            currenthp.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp.setForeground(new Color(218,165,32));
	            field.add(currenthp);    
	           name2=new JLabel(""+p2.getName());
	            name2.setBounds(870,60, 350, 450);
	            name2.setFont(new Font("Algerian", Font.BOLD,20));
	            name2.setForeground(new Color(218,165,32));
	            currenthp2=new JLabel("HP: "+p2.getCurrentHP());
                currenthp2.setBounds(640,10,286,395);
	            currenthp2.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp2.setForeground(new Color(218,165,32));
	            field.add(name2);
	           field.add(currenthp2);
				Layout.show(Parent,"4");
				
			} catch (IOException | CloneNotSupportedException | FullHandException e1) {
				
				e1.printStackTrace();
			}}
		else if(e.getSource()==warlock2){
			try {
				p2=new Warlock();
				game=new Game(p1,p2);
				
		        int num=game.getCurrentHero().getDeck().size();
		        remain.setText("Cards In Deck: "+num);
				if( game.getCurrentHero()==p1){
					showforplayer(3,cards,p1);
					pointerup.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					

					showforplayer(4,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					cardbuttons2.get(3).setVisible(true);
					cardbuttons2.get(3).addActionListener(this);
					
				}
				else {
					showforplayer(4,cards,p1);
					cardbuttons1.get(0).setVisible(true);
					pointerdown.setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					cardbuttons1.get(3).setVisible(true);
					cardbuttons1.get(3).addActionListener(this);
					showforplayer(3,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					
				}
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-fa7e649166e693338bac54c2ce9a0b42.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 47, 200, 250);
	            field.add(lblGif);
	            name=new JLabel(""+p1.getName());
	            name.setBounds(873, 675, 350, 450);
	            name.setFont(new Font("Algerian", Font.BOLD,20));
	            name.setForeground(new Color(218,165,32));
	            field.add(name);
	            currenthp=new JLabel("HP: "+p1.getCurrentHP());
                currenthp.setBounds(740,630,286,395);
	            currenthp.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp.setForeground(new Color(218,165,32));
	            field.add(currenthp);    
	             name2=new JLabel(""+p2.getName());
	            name2.setBounds(870,60, 350, 450);
	            name2.setFont(new Font("Algerian", Font.BOLD,20));
	            name2.setForeground(new Color(218,165,32));
	            currenthp2=new JLabel("HP: "+p2.getCurrentHP());
                currenthp2.setBounds(640,10,286,395);
	            currenthp2.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp2.setForeground(new Color(218,165,32));
	            field.add(name2);
	           field.add(currenthp2);
			
				Layout.show(Parent,"4");
			} catch (IOException | CloneNotSupportedException | FullHandException e1) {
			
				e1.printStackTrace();
			}}
		else if(e.getSource()==priest2){
			try {
				p2=new Priest();
				game=new Game(p1,p2);
				
		        int num=game.getCurrentHero().getDeck().size();
		        remain.setText("Cards In Deck: "+num);
				if( game.getCurrentHero()==p1){
					showforplayer(3,cards,p1);
					pointerup.setVisible(true);
					cardbuttons1.get(0).setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					
					showforplayer(4,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					cardbuttons2.get(3).setVisible(true);
					cardbuttons2.get(3).addActionListener(this);
					
				}
				else {
					showforplayer(4,cards,p1);
					cardbuttons1.get(0).setVisible(true);
					pointerdown.setVisible(true);
					cardbuttons1.get(0).addActionListener(this);
					cardbuttons1.get(1).setVisible(true);
					cardbuttons1.get(1).addActionListener(this);
					cardbuttons1.get(2).setVisible(true);
					cardbuttons1.get(2).addActionListener(this);
					cardbuttons1.get(3).setVisible(true);
					cardbuttons1.get(3).addActionListener(this);
					showforplayer(3,cards2,p2);
					cardbuttons2.get(0).setVisible(true);
					cardbuttons2.get(0).addActionListener(this);
					cardbuttons2.get(1).setVisible(true);
					cardbuttons2.get(1).addActionListener(this);
					cardbuttons2.get(2).setVisible(true);
					cardbuttons2.get(2).addActionListener(this);
					
				}
				URL url = new URL("https://s3.amazonaws.com/user-media.venngage.com/299799-ae6138402ffa0d4eed98afcc03ded23a.gif");
	            ImageIcon imgGif = new ImageIcon(url);
	            JLabel lblGif = new JLabel();
	            imgGif.setImage(imgGif.getImage().getScaledInstance(220,320,Image.SCALE_DEFAULT));
	            lblGif.setIcon(imgGif);
	            lblGif.setBounds(845, 47, 200, 250);
	            field.add(lblGif);
	            name=new JLabel(""+p1.getName());
	            name.setBounds(873, 675, 350, 450);
	            name.setFont(new Font("Algerian", Font.BOLD,20));
	            name.setForeground(new Color(218,165,32));
	            field.add(name);
	            currenthp=new JLabel("HP: "+p1.getCurrentHP());
                currenthp.setBounds(740,630,286,395);
	            currenthp.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp.setForeground(new Color(218,165,32));
	            field.add(currenthp);    
	            name2=new JLabel(""+p2.getName());
	            name2.setBounds(870,60, 350, 450);
	            name2.setFont(new Font("Algerian", Font.BOLD,20));
	            name2.setForeground(new Color(218,165,32));
	            currenthp2=new JLabel("HP: "+p2.getCurrentHP());
                currenthp2.setBounds(640,10,286,395);
	            currenthp2.setFont(new Font("Algerian", Font.BOLD,20));
	            currenthp2.setForeground(new Color(218,165,32));
	            field.add(name2);
	           field.add(currenthp2);
				Layout.show(Parent,"4");
			} catch (IOException | CloneNotSupportedException | FullHandException e1) {
				
				e1.printStackTrace();
			}}
		

		if (e.getSource()== endturn){
			try {
				game.endTurn();
			    int num=game.getCurrentHero().getDeck().size();
			    remain.setText("Cards In Deck: "+num);
			    int num2=game.getOpponent().getDeck().size();
			    remain.setText("Cards In Deck: "+num2);
				Card a=game.getCurrentHero().getHand().get(game.getCurrentHero().getHand().size()-1);
				if(game.getCurrentHero()==p1){
						int x=firstfalse(cards);
						if(x!=-1){
						
						cardbuttons1.get(x).setVisible(true);
					    cardbuttons1.get(x).addActionListener(this);
					    setCardText(a,cards.get(x));
						cards.get(x).setHorizontalTextPosition(0);
						cards.get(x).setVisible(true);
						
						}
				}
				else{
					int x=firstfalse(cards2);
					cardbuttons2.get(x).setVisible(true);
				    cardbuttons2.get(x).addActionListener(this);
				    setCardText(a,cards2.get(x));
					cards2.get(x).setHorizontalTextPosition(0);
					cards2.get(x).setVisible(true);
					
					
				}
				
				if(game.getCurrentHero()==p1){
                    for(int i=0;i<game.getCurrentHero().getTotalManaCrystals();i++){
                        mc.get(i).setVisible(true);
                    }
                    cards.get(p1.getHand().size()-1).setVisible(true);
                }
                else{
                    for(int i=10;i<game.getCurrentHero().getTotalManaCrystals()+10;i++){
                        mc.get(i).setVisible(true);
                    }
                    cards2.get(p2.getHand().size()-1).setVisible(true);
				
                }
			} catch (FullHandException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(game.getCurrentHero()==p1){
				pointerup.setVisible(true);
                pointerdown.setVisible(false);
			}
			else{
				pointerup.setVisible(false);
                pointerdown.setVisible(true);
			}
		}
		if(e.getSource()==drawcard){
			try {
				Card a=game.getCurrentHero().drawCard();
				if(game.getCurrentHero()==p1){
					int x=firstfalse(cards);
					if(x!=-1){
					
					cardbuttons1.get(x).setVisible(true);
				    cardbuttons1.get(x).addActionListener(this);
					setCardText(a,cards.get(x));
					cards.get(x).setHorizontalTextPosition(0);
					cards.get(x).setVisible(true);}
				}
				else{
					int x=firstfalse(cards2);
					cardbuttons2.get(x).setVisible(true);
				    cardbuttons2.get(x).addActionListener(this);
				    setCardText(a,cards2.get(x));
					cards2.get(x).setHorizontalTextPosition(0);
					cards2.get(x).setVisible(true);
					
				}
					
			} catch (FullHandException | CloneNotSupportedException e1) {
				
				e1.printStackTrace();
			}
		}
		
		if(cardbuttons1.contains(e.getSource()) && game.getCurrentHero()==p1){
			 x=cardbuttons1.indexOf(e.getSource());
			 try {
				
					if(p1.getHand().get(x) instanceof Minion){
						
						p1.playMinion((Minion) p1.getHand().get(x));
						int i=firstfalse(cardbg1);
						cardbg1.get(i).setVisible(true);
						cardbg1.get(i).setText(cards.get(x).getText());
						cardbg1.get(i).setHorizontalTextPosition(0);
			            cardbuttonsbg1.get(i).addActionListener(this);
			            
						}
						
						cards.get(x).setVisible(false);
						cardbuttons2.get(x).removeActionListener(this);
			} catch (NotEnoughManaException | NotYourTurnException | FullFieldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		else if(cardbuttons2.contains(e.getSource()) && game.getCurrentHero()==p2){
			x=cardbuttons2.indexOf(e.getSource());
			
			try {
				
				if(p2.getHand().get(x) instanceof Minion){
					p2.playMinion((Minion) p2.getHand().get(x));
					
					int z=firstfalse(cardbg2);
					cardbg2.get(z).setVisible(true);
					cardbg2.get(z).setText(cards2.get(x).getText());
					cardbg2.get(z).setHorizontalTextPosition(0);
		            cardbuttonsbg2.get(z).addActionListener(this);
		            
					}
				
				cards2.get(x).setVisible(false);
				cardbuttons2.get(x).removeActionListener(this);
			} catch (NotEnoughManaException | NotYourTurnException | FullFieldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		if(cardbuttonsbg1.contains(e.getSource())&&game.getCurrentHero()==p1){
			 int x=cardbuttonsbg1.indexOf(e.getSource());
			 Selected=p1.getHand().get(x);
			 if(Selected instanceof Minion){
				 game.getCurrentHero().getField().add((Minion) game.getCurrentHero().getHand().get(x));
				 AttackerMinion=(Minion) Selected;
				 indexattack=x;
				 System.out.println("ekhtarto aho");
				 
			 }
			 else if(Selected instanceof Spell){
				 System.out.println("ekhtarto aho");
				 SelectedSpell=(Spell) Selected;
				 if(AOESpell.class.isAssignableFrom(SelectedSpell.getClass())){
					 try {
						game.getCurrentHero().castSpell((AOESpell)SelectedSpell, game.getOpponent().getField());
						cards.get(x).setVisible(false);
						 cardbuttons1.get(x).removeActionListener(this);
					} catch (NotYourTurnException | NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 finally{SelectedSpell=null;}
					 
					 
				 }
				 else if(FieldSpell.class.isAssignableFrom(SelectedSpell.getClass())){
					 try {
						game.getCurrentHero().castSpell((FieldSpell) SelectedSpell);
						cards.get(x).setVisible(false);
						 cardbuttons1.get(x).removeActionListener(this);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{SelectedSpell=null;}
				 }
				 else if(HeroTargetSpell.class.isAssignableFrom(SelectedSpell.getClass())){
					 try {
						game.getCurrentHero().castSpell((HeroTargetSpell)SelectedSpell, game.getOpponent());
						cards.get(x).setVisible(false);
						 cardbuttons1.get(x).removeActionListener(this);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{SelectedSpell=null;}
				 }
				 }

		}
		if(cardbuttonsbg2.contains(e.getSource())&&game.getCurrentHero()==p2){
			 int x=cardbuttonsbg2.indexOf(e.getSource());
			 Selected=p2.getHand().get(x);
			 if(Selected instanceof Minion){
				 indexattack=x;
				 game.getCurrentHero().getField().add((Minion) game.getCurrentHero().getHand().get(x));
				 AttackerMinion=(Minion) Selected;
				
				 
			 }
			 else if(Selected instanceof Spell){
				 System.out.println("ekhtarto aho");
				 SelectedSpell=(Spell) Selected;
				 if(AOESpell.class.isAssignableFrom(SelectedSpell.getClass())){
					 try {
						game.getCurrentHero().castSpell((AOESpell)SelectedSpell, game.getOpponent().getField());
						cards.get(x).setVisible(false);
						 cardbuttons1.get(x).removeActionListener(this);
					} catch (NotYourTurnException | NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 finally{SelectedSpell=null;}
					 
					 
				 }
				 else if(FieldSpell.class.isAssignableFrom(SelectedSpell.getClass())){
					 try {
						game.getCurrentHero().castSpell((FieldSpell) SelectedSpell);
						cards.get(x).setVisible(false);
						 cardbuttons1.get(x).removeActionListener(this);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{SelectedSpell=null;}
				 }
				 else if(HeroTargetSpell.class.isAssignableFrom(SelectedSpell.getClass())){
					 try {
						game.getCurrentHero().castSpell((HeroTargetSpell)SelectedSpell, game.getOpponent());
						cards.get(x).setVisible(false);
						 cardbuttons1.get(x).removeActionListener(this);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{SelectedSpell=null;}
				 }
				 
			 }

		}
		if(cardbuttonsbg2.contains(e.getSource())&&game.getCurrentHero()==p1&&AttackerMinion!=null){
			int x=cardbuttonsbg2.indexOf(e.getSource());
			System.out.println("lanshon");
			Minion Attacked=(Minion) game.getOpponent().getHand().get(x);
			try {
				game.getOpponent().getField().add((Minion) game.getOpponent().getHand().get(x));
				p1.attackWithMinion(AttackerMinion, Attacked);
				if(AttackerMinion.getCurrentHP()==0){
					cardbg1.get(x).setVisible(false);
					
				}
				if(Attacked.getCurrentHP()==0){
					System.out.println("hasheelo");
					cardbg2.get(x).setVisible(false);}
			} catch (TauntBypassException | InvalidTargetException
					| NotSummonedException | CannotAttackException | NotYourTurnException e1) {
				
				e1.printStackTrace();
			}finally{AttackerMinion=null;
			indexattack=19;
			
			}}
			if(e.getSource()==heroup&&game.getCurrentHero()==p1&&AttackerMinion!=null){
				Hero tobedamaged=game.getOpponent();
				try {
					
					
					p1.attackWithMinion(AttackerMinion,tobedamaged);
					currenthp2=new JLabel("HP: "+tobedamaged.getCurrentHP());
					
				} catch (CannotAttackException | NotYourTurnException
						| TauntBypassException | NotSummonedException
						| InvalidTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{AttackerMinion=null;}
				
				
			}
			if(e.getSource()==herodown&&game.getCurrentHero()==p2&&AttackerMinion!=null){
				Hero tobedamaged=game.getOpponent();
				try {
					
					p2.attackWithMinion(AttackerMinion,tobedamaged);
					currenthp=new JLabel("HP: "+tobedamaged.getCurrentHP());
					
				} catch (CannotAttackException | NotYourTurnException
						| TauntBypassException | NotSummonedException
						| InvalidTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{AttackerMinion=null;}
				
				
			}
			
			
		if(cardbuttonsbg1.contains(e.getSource())&&game.getCurrentHero()==p2&&AttackerMinion!=null){
			int x=cardbuttonsbg1.indexOf(e.getSource());
			
			Minion Attacked=(Minion) game.getOpponent().getField().get(x);
			System.out.println("lanshon");
			try {
				game.getOpponent().getField().add((Minion) game.getOpponent().getHand().get(x));
				game.validateAttack(AttackerMinion,Attacked);
				p2.attackWithMinion(AttackerMinion, Attacked);
				if(AttackerMinion.getCurrentHP()==0){
					cardbg2.get(x).setVisible(false);
				}
				if(Attacked.getCurrentHP()==0){
					cardbg1.get(x).setVisible(false);
					System.out.println("shelto aho");}
			} catch (TauntBypassException | InvalidTargetException
					| NotSummonedException | CannotAttackException | NotYourTurnException e1) {
				
				e1.printStackTrace();
			}finally{AttackerMinion=null;
			indexattack=19;
			
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			field.revalidate();
			field.repaint();
	      
    }	
	
	public static void showforplayer(int x, ArrayList<JLabel> a,Hero p){
		
		for(int i=0; i<x; i++){
			setCardText(p.getHand().get(i),a.get(i));
			a.get(i).setHorizontalTextPosition(0);
			a.get(i).setVisible(true);
		}
		
	}
	public static int firstfalse(ArrayList<JLabel>a){
		for(int i=0;i<a.size();i++){
			if(a.get(i).isVisible()==false)
				return i;
			
		}
		return -1;
		
		
	}
	public static void setCardText(Card c, JLabel card){
        String taunt="Not Taunt";
        String divine="No Divine Shield";
        String charge="Not Charge";

        if(c instanceof Spell){
            card.setText("<html>"+"Name: "+c.getName()+"<br>"+
                            "Rarity: "+c.getRarity()+"<br>"+
                            "Cost: "+c.getManaCost()+"</html>");}
        else{
            if(((Minion) c).isTaunt()==true)
                taunt="Taunt";
            if(((Minion) c).isDivine()==true)
                divine="Has Divine Shield";
            if(((Minion)c).isSleeping()==false)
                charge="Charge";


            card.setText("<html>"+"Name: "+c.getName()+"<br>"+
                    "Rarity: "+c.getRarity()+"<br>"+
                    "Cost: "+c.getManaCost()+"<br>"+
                    "Attack: "+((Minion)c).getAttack()+"<br>"+
                    "CurrentHP: "+((Minion) c).getCurrentHP()+"<br>"+
                    taunt+"<br>"+divine+"<br>"+charge+ "</html>");
        }
        card.setForeground(new Color(220,220,220));
    }
	
	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}



	
	

}
