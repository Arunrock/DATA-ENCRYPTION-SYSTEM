import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JLabel;


public class MsgBox extends Frame 
{
  

 Label label1 = new Label();
    	//Button button1 = new Button();
     //Button button2 = new Button();
    	String msg=" key cant be less than 64 bit ";
     MsgBox( ) {
                         
        		
        		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        		try {
jbInit();
        		} 
catch (Exception e) {
            		e.printStackTrace();
        		}
    	}

   	public void processWindowEvent(WindowEvent e) {
        		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            	cancel();
        		}
        		super.processWindowEvent(e);
    	}

    	void cancel() { 
                     this.setVisible(false);
}
 void jbInit() throws Exception {
        		this.setSize(new Dimension(444, 120));
        		this.setLayout(null);
this.addWindowListener(new WindowAdapter() {
                    	public void windowClosing(WindowEvent e) {setVisible(false);}});
        		label1.setText(msg);
        		label1.setBounds(new Rectangle(10, 50, 400, 25));
        		label1.setFont(new Font("Tahoma", 1, 14));
        		label1.setAlignment(1);
        		/*button1.setLabel("YES");
        		button1.setBounds(new Rectangle(110, 50, 80, 30));
        		button1.addActionListener(new ActionListener() {
                    		public void actionPerformed(ActionEvent e) {
                        		button1_actionPerformed(e);
                    		}
                	});
        		button2.setLabel("NO");
        		button2.setBounds(new Rectangle(200, 50, 90, 30));
        		button2.addActionListener(new ActionListener() {
                    		public void actionPerformed(ActionEvent e) {
                        	button2_actionPerformed(e); }
                	});*/
        		this.add(label1, null);
        		//this.add(button2, null);
            	//his.add(button1, null);
}
    	/*int type=0;
    	private void button2_actionPerformed(ActionEvent e) {
        		type=0;
        		setVisible(false);
    	}

    	private void button1_actionPerformed(ActionEvent e) {
        		type=1;
        		setVisible(false);
    	}*/
public static void main(String args[])
{
   MsgBox b =new MsgBox();
                            b.setVisible(true);
}
 
}
