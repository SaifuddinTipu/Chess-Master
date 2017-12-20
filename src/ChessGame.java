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
//  We	received help from  no 	assitance 	in	developing	and	 debugging  our  program.	
//****************************************************************************************


import java.awt.EventQueue;
import javax.swing.JFrame;



public class ChessGame extends JFrame
{
	public ChessGame() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		
		new ChessGame();
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {                
				ChessGui s = new ChessGui();
				s.setVisible(true);                 
         
            }
        });
    }	
	
}

