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


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ThreadCheck extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	  private Timer timer;
	  private ImageIcon Array[];
	  private int delay=60 ,totalframe = 79,currentimage = 0;
	  Thread runner;
	  static private JFrame frame;
	  
	  public static void main(String[] args) {
		  frame = new JFrame("Check!");
		  ThreadCheck s = new ThreadCheck();
		  frame.add(s);
		  frame.setVisible(true);
		  frame.setLocation(840, 370);
		  frame.setSize(340,260);
	  }
	  
  public ThreadCheck() {
	  Array = new ImageIcon[totalframe];
	   for(int i = 0 ; i < Array.length ; i++) {
		   Array[i] = new ImageIcon("ThreadCheck/check"+i+".gif");
	   }
	   timer = new Timer(delay,this);
    
	   timer.start();
 }

  public void paint(Graphics g) {
   super.paint(g);
   if(currentimage>=Array.length) {
	   timer.stop();
	   frame.dispose();
   }else 
   
	   Array[currentimage].paintIcon(this, g, 0, 0);
   currentimage++;
  }

@Override
public void actionPerformed(ActionEvent e) {
	repaint();
}
}