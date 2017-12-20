//****************************************************************************************
//	Project: TMFG2_21	
//
//	Authors	and	matric	number:	
//	Chris Ting Lik Yong (55738)
//  Md. Saifuddin Tipu (54398)
//  Nur Addina Binti Baslan (50738)
//  Syahirah Binti Jumain (59215)
//  Tay Ya Sing (58109)
//
//	Honour	code:	We	pledge	that	this	program	represents	our	own	program	code.	
//  We	 received help from  no 	assitance 	in	developing	and	 debugging  our  program.		
//****************************************************************************************

import java.awt.image.BufferedImage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;

import javax.imageio.ImageIO;


import javax.sound.sampled.*;


public class ChessGui extends JFrame implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel gui = new JPanel(null);
	
//  Chess Pieces are downloaded from https://www.vecteezy.com/free-vector/chess-pieces	
	
	private Clip clip;
	private Board playboard;
	private JTextField txtPlayerOne;
	private JTextField txtPlayerTwo;
	private JFrame frame;
	
	public ChessGui() {
		setSize(1060,720);
		gui.setBackground(Color.PINK);
		setTitle("Chess");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().add(gui);
        
	    gui.setBorder(new EmptyBorder(5, 5, 5, 5));
	    
	    JLabel lblWelcomeToChess = new JLabel("CHESS MASTER");		
	    lblWelcomeToChess.setHorizontalAlignment(SwingConstants.CENTER);
		gui.add(lblWelcomeToChess);
		lblWelcomeToChess.setForeground(new Color(139, 69, 19));
		lblWelcomeToChess.setFont(new Font("Algerian", Font.BOLD, 29));
		lblWelcomeToChess.setBounds(715, 20, 300, 39);
		
		JLabel lblPlayerOne = new JLabel("Player 1");		
		gui.add(lblPlayerOne);
		lblPlayerOne.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPlayerOne.setForeground(new Color(139, 69, 19));
		lblPlayerOne.setBounds(700, 70, 80, 20);
		
		
		JLabel lblPlayerTwo = new JLabel("Player 2");		
		gui.add(lblPlayerTwo);
		lblPlayerTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPlayerTwo.setForeground(new Color(139, 69, 19));
		lblPlayerTwo.setBounds(700, 120, 80, 20);
	
				
		txtPlayerOne = new JTextField("");
		gui.add(txtPlayerOne);
		txtPlayerOne.setFont(new Font("Andalus", Font.BOLD, 14));
		txtPlayerOne.setBounds(800, 70, 215, 25);
	
		
		txtPlayerTwo = new JTextField("");
		gui.add(txtPlayerTwo);
		txtPlayerTwo.setFont(new Font("Andalus", Font.BOLD, 14));
		txtPlayerTwo.setBounds(800, 120, 215, 25);
		
		
		txtPlayerOne.addKeyListener(this);
		txtPlayerTwo.addKeyListener(this);
	    
        JLabel labelPlayer1 = new JLabel();
        JLabel labelPlayer2 = new JLabel();
        
	    JButton btnStartTheGame = new JButton("START");
	    btnStartTheGame.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		            
	     		if(txtPlayerOne.getText().trim().isEmpty() || txtPlayerTwo.getText().trim().isEmpty())
	    		{
	     			JOptionPane.showMessageDialog(frame,"Please key in your name!","Error!",JOptionPane.ERROR_MESSAGE);
	    		}
	     		
	     		else if(txtPlayerOne.getText().trim().equals(txtPlayerTwo.getText().trim()))
	    		{
	     			JOptionPane.showMessageDialog(frame,"Please input different name!","Error!",JOptionPane.ERROR_MESSAGE);
	    		}

	     		else {
	     			
	     		playboard =  new Board();
	     	    gui.add(playboard);
	     	    playboard.setBounds(10, 10, 700, 700);
	     	    
    		 	labelPlayer1.setText(txtPlayerOne.getText() + " - White Chess");
                gui.add(labelPlayer1);	                
                labelPlayer1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                labelPlayer1.setBounds(700,200,250, 100);
                labelPlayer1.setForeground(new Color(139, 69, 15));
                
                labelPlayer1.revalidate();
                labelPlayer1.repaint();
                
                
                labelPlayer2.setText(txtPlayerTwo.getText() + " - Black Chess");
                gui.add(labelPlayer2);	                
                labelPlayer2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                labelPlayer2.setBounds(700,220,250, 100);
                labelPlayer2.setForeground(new Color(139, 69, 15));
                
                labelPlayer2.revalidate();
                labelPlayer2.repaint();
	     		}
	     	}
	     });
	    btnStartTheGame.setForeground(new Color(250, 250, 250));
	    btnStartTheGame.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	    btnStartTheGame.setBorderPainted(false);
	    btnStartTheGame.setBackground(new Color(139, 69, 19));
	    btnStartTheGame.setBounds(700, 166, 155, 25);
	    gui.add(btnStartTheGame);
	     
	    JLabel lblMassage = new JLabel("--------- STATUS ---------");		
		gui.add(lblMassage);
		lblMassage.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblMassage.setForeground(new Color(139, 69, 19));
		lblMassage.setBounds(700, 215, 320, 20);
		
		JLabel lblline = new JLabel("---------------------------");		
		gui.add(lblline);
		lblline.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblline.setForeground(new Color(139, 69, 19));
		lblline.setBounds(700, 275, 329, 40);
		
		
		JPanel Tutorial = new JPanel();
		gui.add(Tutorial);
		Tutorial.setBackground(new Color(0,0,0));
	
		
		Tutorial.setBounds(700, 350, 315, 240);  
		ImageIcon igameover = new ImageIcon("src/chess.gif");
		Tutorial.add(new JLabel(igameover, JLabel.CENTER));
		Tutorial.setVisible(true);
	
		
	    JButton btnExit = new JButton("EXIT");
	    gui.add(btnExit);
	    btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	    btnExit.setForeground(new Color(255,0,0));
	    btnExit.setBounds(865, 643, 150, 25);
	    btnExit.setBackground(new Color(139, 69, 19));
	    btnExit.setForeground(new Color(250,250,250)); 
	    btnExit.setBorderPainted(false);
	    
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
				{
					clip.stop();	
					Window win = SwingUtilities.getWindowAncestor(gui);
					win.dispose();
				}
		});	
		    

	     JButton btnmusic = new JButton("MUSIC ON/OFF");
	     gui.add(btnmusic);
	     btnmusic.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	     btnmusic.setForeground(new Color(255,0,0));
	     btnmusic.setBounds(700, 643, 150, 25);
	     btnmusic.setBackground(new Color(139, 69, 19));
	     btnmusic.setForeground(new Color(250,250,250)); 
	     btnmusic.setBorderPainted(false);
	     
         try {
	         // Open an audio input stream.
	         File soundFile = new File ("src/music.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	         // Get a sound clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.loop(Clip.LOOP_CONTINUOUSLY);
	         clip.start();
         

	         btnmusic.addActionListener(new ActionListener()
		{	
	    	 
	    	 public void actionPerformed(ActionEvent n)
	    	 {
	   	         
	    	     if (clip.isRunning())
	             {
	            	 clip.stop();			        	                	
	             }
	             else
	             { 
	    	         clip.loop(Clip.LOOP_CONTINUOUSLY);
	            	 clip.start();   
	                 clip.setFramePosition(0);
	             }
	    		 
	    			  
	    	  }
						
		});
	     
	     
         } catch (UnsupportedAudioFileException r){
	         r.printStackTrace();
	      } catch (IOException r) {
	         r.printStackTrace();
	      } catch (LineUnavailableException r) {
	         r.printStackTrace();
	      }	
		
	     JButton btnRestartTheGame = new JButton("RESTART");
	     btnRestartTheGame.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		
	     			clip.stop();
    	     		Window win = SwingUtilities.getWindowAncestor(gui);
    	     		win.dispose();
    	     		ChessGui restart = new ChessGui();
    	     		restart.setVisible(true);

	     		}
					
	     	});
	     btnRestartTheGame.setForeground(new Color(250, 250, 250));
	     btnRestartTheGame.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	     btnRestartTheGame.setBorderPainted(false);
	     btnRestartTheGame.setBackground(new Color(139, 69, 19));
	     btnRestartTheGame.setBounds(865, 166, 150, 25);
	     gui.add(btnRestartTheGame);
	     
	     JButton btnMatchHistory = new JButton("WINNER BOARD");
	     btnMatchHistory.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		
	     		frame = new JFrame("Winner Board");
				frame.setBounds(100, 100, 450, 300);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				frame.getContentPane().setLayout(null);
				frame.getContentPane().setBackground(Color.WHITE);;
				
				JLabel MATCH = new JLabel("Winner Board");
				MATCH.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
				MATCH.setForeground(new Color(139, 69, 19));
				MATCH.setHorizontalAlignment(SwingConstants.CENTER);
				MATCH.setBounds(104, 21, 218, 28);
				frame.getContentPane().add(MATCH);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(30, 61, 383, 176);
				frame.getContentPane().add(scrollPane);
				
				JTextArea textArea = new JTextArea();
				textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
				scrollPane.setViewportView(textArea);
				
				 try {
					    @SuppressWarnings("resource")
						BufferedReader Reader = new BufferedReader(new FileReader("WinnerBoard.txt"));

					    String line;
					    int m = 1;
					    
					    while((line = Reader.readLine())!= null){
					    	String[] array = line.split(",");

							textArea.append(
							"Match "+m+"\n"+
							"Player One: "+array[0]+"\n"+
							"Player Two: "+array[1]+"\n"+
							"Winner: "+array[2]+"\n\n");
							
							m++;

					    }

					} catch (IOException t) {
					    t.printStackTrace();
					} 
	     	}
	     });
	     btnMatchHistory.setForeground(Color.WHITE);
	     btnMatchHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	     btnMatchHistory.setBorderPainted(false);
	     btnMatchHistory.setBackground(new Color(139, 69, 19));
	     btnMatchHistory.setBounds(700, 607, 315, 25);
	     gui.add(btnMatchHistory);
	}
	
	class Board extends JComponent implements MouseListener{
		
		private static final long serialVersionUID = 1L;
		public static final int blackPawn = 1;
		public static final int blackRook = 3;
		public static final int blackKnight = 5;
		public static final int blackQueen = 7;
		public static final int blackKing = 9;
		public static final int blackBishop = 11;
	
		public static final int whitePawn = 0;
		public static final int whiteRook = 2;
		public static final int whiteKnight = 4;
		public static final int whiteQueen =6;
		public static final int whiteKing = 8;
		public static final int whiteBishop = 10;
	
		public static final int none = -1;
		public static final int whitePlayer = 0;
		public static final int blackPlayer = 1;
		
		private int currentPlayer;
		private int selectedPiece1,_x,_y;
		private boolean ended;
		private int _check;
		
		private BufferedImage[] icons;
		private int[][] boardplace;
		
		 JLayeredPane layeredPane;
	     JPanel chessBoard;
		 JLabel chessPiece;
		 int xAdjustment;
		 int yAdjustment;
		 
		 
		
		 private Board(){
			
			this.addMouseListener(this);
					
			boardplace = new int[11][11];			
		
			for(int i=0;i<11;i++){
				for(int j=0;j<11;j++){
					boardplace[i][j] = none;					
				
				}
			}
			
			boardplace[3][0] = blackQueen;
			boardplace[4][0] = blackKing;
			boardplace[5][0] = blackBishop;
			boardplace[6][0] = blackKnight;
			boardplace[7][0] = blackRook;
			boardplace[3][1] = blackPawn;
			
			boardplace[3][10] = whiteRook;
			boardplace[4][10] = whiteKnight;
			boardplace[5][10] = whiteBishop;
			boardplace[6][10] = whiteKing;
			boardplace[7][10] = whiteQueen;
			boardplace[7][9] = whitePawn;
						
			icons = new BufferedImage[12];
    		try{
				
				 icons[1] = ImageIO.read(this.getClass().getResource("B_pawn.gif"));
				 icons[3] = ImageIO.read(this.getClass().getResource("B_rook.gif"));
				 icons[5] = ImageIO.read(this.getClass().getResource("B_knight.gif"));
				 icons[7] = ImageIO.read(this.getClass().getResource("B_queen.gif"));
				 icons[9] = ImageIO.read(this.getClass().getResource("B_king.gif"));	
				 icons[11] = ImageIO.read(this.getClass().getResource("B_bishop.gif"));
				 
				 icons[0] = ImageIO.read(this.getClass().getResource("W_pawn.gif"));
				 icons[2] = ImageIO.read(this.getClass().getResource("W_rook.gif"));
				 icons[4] = ImageIO.read(this.getClass().getResource("W_knight.gif"));
				 icons[6] = ImageIO.read(this.getClass().getResource("W_queen.gif"));
				 icons[8] = ImageIO.read(this.getClass().getResource("W_king.gif"));
				 icons[10] = ImageIO.read(this.getClass().getResource("W_bishop.gif"));
			
				  
		}catch(IOException e){}	
    		
		this.currentPlayer = whitePlayer;
		this.selectedPiece1 = none;
		this._x = none;
		this._y =  none;
		this.ended = false;
		this._check = none;
		
		this.addMouseListener(this);
	}
	

	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	
	public void mousePressed(MouseEvent event) {
		int x = getSquare(event.getX());
		int y = getSquare(event.getY());

		// Don't do anything if we're not on the play zone or if game is over
		if (x == -1 || y == -1 || this.ended)
			return;

		// If no piece has been selected, select this one
		if (owned(x, y)) {
			this.selectPiece(x, y);
			this.repaint();
		}
		// If a piece is already selected, try the movement
		else
			this.attemptMove(x, y);

	}
	
	
	
	 private int getSquare(int pixel) {
		if (pixel < 660)
			return (pixel / 60);
		return -1;
	}
	
	private int selectPiece(int x, int y) {
		this._x = x;
		this._y = y;
		this.selectedPiece1 = this.boardplace[x][y];		
		return this.selectedPiece1;
	}
	
	 private boolean checkKingMove(int x, int y) {
		// The king move is just a limited queen move
		if (Math.abs(this._x - x) < 2 && Math.abs(this._y - y) < 2)
			return checkQueenMove(x, y);
		return false;
	}
	
	private boolean checkQueenMove(int x, int y) {
		// The queen move can be a rook move or a bishop move
		return checkRookMove(x, y) || checkBishopMove(x, y);
	}
	
	private boolean checkKnightMove(int x, int y) {
		if (Math.abs(this._y - y) == 2 && Math.abs(this._x - x) == 1
			|| Math.abs(this._y - y) == 1 && Math.abs(this._x - x) == 2)
			return true;
		return false;
	}
	
	private boolean checkBishopMove(int x, int y) {
		// Diagonal movement
		if (Math.abs(this._x - x) == Math.abs(this._y - y))
			return pathClear(x, y);
		    
		return false;
	}
	
	 private boolean checkRookMove(int x, int y) {
		// Vertical movement
		if (this._x == x && this._y != y ||
			this._x != x && this._y == y)
			return pathClear(x, y);
		return false;
				
	}
	
	 private boolean checkPawnMove(int x, int y)
	{
		// If pawn is white, then the check is done going up
		if (this.selectedPiece1 == whitePawn) {
			// Check vertical movement and empty square
			if (this._x == x && this._y - y == 1 && this.empty(x, y))
				return true;
			// Check vertical movement and empty square for first pawn movement
			if (this._x == x && this._y - y == 2 && this.empty(x, y)
				&& this._y == 9 && this.empty(x, y + 1))
				return true;
			// Check diagonal movement and enemy piece
			if (this._y - y == 1 && (this._x - x == 1 || x - this._x == 1)
			&& this.enemy(x, y))
				return true;
			
					
			
		}
		// If pawn is black, then the check goes down (same checks)
		if (this.selectedPiece1 == blackPawn) {
		// Check vertical movement and empty square
			if (this._x == x && y - this._y == 1 && this.empty(x, y))
				return true;
			// Check vertical movement and empty square for first pawn movement
			if (this._x == x && y - this._y == 2 && this.empty(x, y)
			&& this._y == 1 && this.empty(x, y - 1))
				return true;
			// Check diagonal movement and enemy piece
			if (y - this._y == 1 && (this._x - x == 1 || x - this._x == 1)
				&& this.enemy(x, y))
			return true;
		}	   
		
		return false;
		
		
				
		
		
	}
	
	private boolean simulateMove(int x, int y) {
		int[][] saved = new int[11][11];
		
		boolean ret = true;
		
		
		// Backup the actual board map
		for (int i = 0; i < 11; ++i)
			System.arraycopy(this.boardplace[i], 0, saved[i], 0, this.boardplace[i].length);

		// Simulate the move, return false if there is a king check
		this.movePiece(x, y);
		ret = this.checkKingCheck() ? false : true;
		
		// Restore the real board map
		for (int i = 0; i < 11; ++i)
			System.arraycopy(saved[i], 0, this.boardplace[i], 0, saved[i].length);
	return ret;
	}	
	
	 private boolean isMoveValid(int x, int y) {
		boolean ret = false;

		// Don't move over his own piece
		if (this.owned(x, y))
			{return false;}
		
		else if((x==0||x==10)&&(y==0||y==1||y==2||y==8||y==9||y==10)){
			
			return false;
		}
		
		else if((x==1||x==9)&&(y==0||y==1||y==9||y==10)){
			
			return false;
			
		}
		
		else if((x==2||x==8)&&(y==0||y==10)){
			
			return false;
			
		}

		// Is it possible for the piece to move there ?
		if (this.selectedPiece1 == whitePawn || this.selectedPiece1 == blackPawn)
			ret = checkPawnMove(x, y);
		else if (this.selectedPiece1 == whiteRook || this.selectedPiece1 == blackRook)
			ret = checkRookMove(x, y);
		else if (this.selectedPiece1 == whiteKnight || this.selectedPiece1 == blackKnight)
			ret = checkKnightMove(x, y);
		else if (this.selectedPiece1 == whiteBishop || this.selectedPiece1 == blackBishop)
			ret = checkBishopMove(x, y);
		else if (this.selectedPiece1 == whiteQueen || this.selectedPiece1 == blackQueen)
			ret = checkQueenMove(x, y);
		else if (this.selectedPiece1 == whiteKing || this.selectedPiece1 == blackKing)
			ret = checkKingMove(x, y);
		else
			return false;
		return ret && simulateMove(x, y);
	}
	
	private void movePiece(int x, int y)
	{
		
		this.boardplace[x][y] = this.boardplace[this._x][this._y];
		this.boardplace[this._x][this._y] = none;
			
	}
	
	 private boolean pieceChecking(int x, int y) {
		boolean checking = false;
		boolean found = false;
		int save_x = this._x;
		int save_y = this._y;
		int save_select = this.selectedPiece1;
		int save_current = this.currentPlayer;
		int piece_owner = this.boardplace[x][y] % 2;
		int target = (piece_owner == this.currentPlayer)?blackKing:whiteKing;

		this.selectPiece(x, y);
		this.currentPlayer = piece_owner;
		// Find enemy king and check if move is valid
		for (int i = 0; i < 11 && found == false; ++i)
			for (int j = 0; j < 11 && found == false; ++j)
			if (this.boardplace[i][j] == target) {
				checking = this.isMoveValid(i, j);
				found = true;
			}
		this._x = save_x;
		this._y = save_y;
		this.selectedPiece1 = save_select;
		this.currentPlayer = save_current;
		return checking;
	}
	
	 private boolean checkKingCheck() {
		this.switchPlayer();
		for (int x = 0; x < 11; ++x)
			for (int y = 0; y < 11; ++y)
			if (this.owned(x, y) && this.pieceChecking(x, y)) {			
				
				this.switchPlayer();
				return true;
				
		
			}
		
				
		this.switchPlayer();
		return false;
	}
	
	private boolean checkEnd() {
		boolean ret = true;
		int save_x = this._x;
		int save_y = this._y;
		int save_select = this.selectedPiece1;

		// Find the player's king
		for (int i = 0; i < 11; ++i)
			for (int j = 0; j < 11; ++j)
			if (owned(i, j)) {
				// check if it still has a valid move one the board
				this.selectPiece(i, j);
				for (int k = 0; k < 11 && ret; ++k)
				for (int l = 0; l < 11 && ret; ++l)
					// if a valid move is found, return false
					if (this.isMoveValid(k, l))
					ret = false;

			}

		this._x = save_x;
		this._y = save_y;
		this.selectedPiece1 = save_select;
		return ret;
	}
	
	private void attemptMove(int x, int y) {
		if (this.isMoveValid(x, y) && this.simulateMove(x, y)) {
			this.movePiece(x, y);

			try {
		         // Open an audio input stream.
		         File soundFile = new File ("src/move.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		         clip.stop();
		         clip.setFramePosition(0);
		         clip.start();
		        
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }	

			this.endTurn();
		}
		else
			this.repaint();
	}
	
	private int getDirection(int i, int j) {
		if (i == j)
			return 0;
		return (i < j) ? 1 : -1;
	}
	
	private boolean pathClear(int x, int y) {
		int xDirection = getDirection(x, this._x);
		int yDirection = getDirection(y, this._y);

		// don't check the point itself
		x += xDirection; 
		y += yDirection;

		// check every square until we are on the piece's square
		while (x != this._x || y != this._y) {
			if (this.empty(x, y) == false)
			return false;
			x += xDirection;
			y += yDirection;
		}
		return true;
	}
	
	 private boolean owned(int x, int y) {
		int piece = this.boardplace[x][y];

		if (piece != none && piece % 2 == this.currentPlayer)
			return true;

		
		return false;
	}
	
	 private boolean enemy(int x, int y) {						//done
		int piece = this.boardplace[x][y];
		
		if (piece != none && piece % 2 != this.currentPlayer)
			return true;
		return false;
	}
	

	private void drawGrid(Graphics2D g2d){
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				if((i==0||i==10)&&(j==3||j==5||j==7)){
					g2d.setColor(Color.BLACK);
					g2d.fillRect(60*i,60*j,60,60);
				}
				else if((i==1||i==9)&&(j==2||j==4||j==6||j==8)){
					g2d.setColor(Color.BLACK);
					g2d.fillRect(60*i,60*j,60,60);
				}
				else if((i>=2&&i<=8)&&((i+j)%2!=0)){
					g2d.setColor(Color.BLACK);
					g2d.fillRect(60*i,60*j,60,60);
				}
				else if((i==0||i==10)&&(j==0||j==1||j==2||j==8||j==9||j==10)){
					g2d.setColor(Color.PINK);
					g2d.fillRect(60*i,60*j,60,60);
					
				}
				
				else if((i==1||i==9)&&(j==0||j==1||j==9||j==10)){
					g2d.setColor(Color.PINK);
					g2d.fillRect(60*i,60*j,60,60);
					
				}
				
				else if((i==2||i==8)&&(j==0||j==10)){
					g2d.setColor(Color.PINK);
					g2d.fillRect(60*i,60*j,60,60);
				}
				
				
				
				else{
					g2d.setColor(Color.ORANGE);
					g2d.fillRect(60*i,60*j,60,60);
				}
				
				if(this.selectedPiece1!=none && i == this._x && j== this._y){
					g2d.setColor(Color.RED);
					g2d.fillRect(60*i,60*j,60,60);
				}
				
				if (this.pieceChecking(i, j)) {
					g2d.setColor(Color.YELLOW);
					g2d.fillRect(60*i,60*j,60,60);
				}
				if (this.isMoveValid(i, j)) {
					g2d.setColor(Color.cyan);
					g2d.fillRect(60*i,60*j,60,60);
				}
				
				
			}
		}//end of for
	}//end of drawGrid
	
	private void drawPieces(Graphics2D g2d){
		for(int i=0; i<11 ; i++)
			for(int j=0;j<11;j++)
				if(this.empty(i,j) ==  false)
					g2d.drawImage(this.icons[this.boardplace[i][j]],i*60,j*60,null);	
	}
	
	 private boolean empty(int x, int y) {
		if (this.boardplace[x][y] == none)
			return true;
		return false;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		drawGrid(g2d);
		drawPieces(g2d);
	}	
	
	
	JFrame fgameover = new JFrame("CHECKMATE");
	
	 private void endTurn() {      // changePlayer
		// Change the current player
		this.switchPlayer();

		// See if the current player have a king check due to precedent player
		this._check = none;
		if (this.checkKingCheck()) {
			this._check = this.currentPlayer;				
			
			
				
	         ThreadCheck.main(null);
			
			
			
			try {
		         // Open an audio input stream.
		         File soundFile = new File ("src/check.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		         clip.stop();
		         clip.setFramePosition(0);
		         clip.start();
		        
		         
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }			
			
		} else {
		}

		if (this.checkEnd()) {
			
			
			if (this._check != none) {
			} else {
			}
			this.ended = true;
			
		      fgameover.setBounds(700, 350, 315, 240);  
		      ImageIcon igameover = new ImageIcon("src/checkmate.gif");
			  fgameover.add(new JLabel(igameover, JLabel.CENTER));
			  fgameover.setVisible(true);
			  fgameover.setLocation(840, 370);
			  fgameover.setSize(340,260);
			
			 if(currentPlayer == whiteKing)
			 {
				 JLabel lblMassage = new JLabel("White Player Won The Game");		
				 gui.add(lblMassage);
				 lblMassage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
				 lblMassage.setForeground(new Color(150,248,220));
				 lblMassage.setBounds(700, 305, 320, 30);
				 
				 File log = new File("WinnerBoard.txt");
					
				 	String PlayerOne = txtPlayerOne.getText().trim();
				 	String PlayerTwo = txtPlayerTwo.getText().trim();
				    String Winner = txtPlayerOne.getText().trim();
				    
							try{
							    if(!log.exists()){
							        log.createNewFile();
							    }
							    
							    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log,true));
							    bufferedWriter.write(PlayerOne + "," + PlayerTwo + "," + Winner);
							    bufferedWriter.newLine();
							    bufferedWriter.close();

							} catch(IOException n) {
							}
				 
			 }else{
				 
				 JLabel lblMassage = new JLabel("Black Player Won");		
				 gui.add(lblMassage);
				 lblMassage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
				 lblMassage.setForeground(new Color(139, 69, 19));
				 lblMassage.setBounds(720, 305, 320, 30);
				 
				 File log = new File("WinnerBoard.txt");
					
				 	String PlayerOne = txtPlayerOne.getText().trim();
				 	String PlayerTwo = txtPlayerTwo.getText().trim();
				    String Winner = txtPlayerTwo.getText().trim();
				    
							try{
							    if(!log.exists()){
							        log.createNewFile();
							    }
							    
							    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log,true));
							    bufferedWriter.write(PlayerOne + "," + PlayerTwo + "," + Winner);
							    bufferedWriter.newLine();
							    bufferedWriter.close();

							} catch(IOException n) {
							}
				 
			 }
			
			try {
		         // Open an audio input stream.
		         File soundFile = new File ("src/checkmate.wav");
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
		         // Get a sound clip resource.
		         Clip clip = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip.open(audioIn);
		         clip.stop();
		         clip.setFramePosition(0);
		         clip.start();
		         
		         
				 
			         
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }		
			
			
		}

		// Reset selected piece
		this.selectedPiece1 = this._x = this._y = none;

		// Then repaint the GUI without selected piece
		this.repaint();
	}
	
	 private void switchPlayer() {
		this.currentPlayer ^= 1; // Bitwise operation (XOR) to switch between 0 and 1
	}	
}

public final JComponent getGui() {
    return gui;
}

@Override
public void keyPressed(KeyEvent arg0) {}

@Override
public void keyReleased(KeyEvent arg0) {}

@Override
public void keyTyped(KeyEvent arg0) {}
}