import java.awt.*;
import java.awt.event.*;

public class Main extends Frame 
{
Button button1 = new Button();
 Button button2 = new Button();
    	 Button button3 = new Button();
 	 Button button4 = new Button();
    	 Button button5 = new Button();
         Button button6 = new Button();
         

     Main() 
{
        		try 
{
            		Home();
        		} 
catch (Exception e) 
{
            		e.printStackTrace();
        	}
}

private void Home() throws Exception 
{
             	this.setLayout( null );
this.setSize(new Dimension(500, 500));
         	this.setBackground(new java.awt.Color(254, 215, 215));
             	this.setFont(new Font("Dialog", 0, 15));
        		this.setTitle("Data Encryption System");
        		this.addWindowListener(new WindowAdapter() {
                    	public void windowClosing(WindowEvent e) 
{
                        	this_windowClosing(e);
                    	}
}); 
	button1.setLabel("Encrypt ");
button1.setBounds(new Rectangle(135, 45, 205, 35));
      	button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
                       button1_actionPerformed(e);
            }
            });
     	button2.setLabel("Decrypt ");
       	button2.setBounds(new Rectangle(135, 90, 205, 35));
   	button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            button2_actionPerformed(e);
            }
            });
        	button3.setLabel("Exit");
        	button3.setBounds(new Rectangle(135, 355, 205, 35));
        	button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {button3_actionPerformed(e);}});
         button4.setLabel("Encrypt Symmetric key ");
button4.setBounds(new Rectangle(135,135, 205, 35));
      	button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
               try{
	  button4_actionPerformed(e); 
}catch(Exception io){
io.printStackTrace();
}   
            }
            });
button5.setLabel("Decrypt Symmetric key ");
button5.setBounds(new Rectangle(135, 180 ,205, 35));
      	button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
                      
	  button5_actionPerformed(e); 
  
            }
            });

button6.setLabel("Generate key ");
button6.setBounds(new Rectangle(135, 225, 205, 35));
      	button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
      button6_actionPerformed(e);
            }
            });
     	   
        	this.add(button1, null);
        	this.add(button2, null);
       	       this.add(button3, null);
                this.add(button4, null);
                 this.add(button5, null);
                  this.add(button6, null);
          	}
   
    	public static void main(String[] args) 
{
        		(new Main()).setVisible(true);
}
  	private void this_windowClosing(WindowEvent e) 
{
        		System.exit(0);
    	}
private void button1_actionPerformed(ActionEvent e) 
{
       		Enc f=new Enc(this,"File Encryption",true);
      		this.setVisible(false);
      		f.setVisible(true);
       		this.setVisible(true);
}

 	private void button2_actionPerformed(ActionEvent e) 
{
    		Dec f=new Dec(this,"File Decryption",true);
      		this.setVisible(false);
   		f.setVisible(true);
     		this.setVisible(true);
}
  	
private void button3_actionPerformed(ActionEvent e) 
{
        		System.exit(0);
    	}
public void button6_actionPerformed(ActionEvent e) 
{
    try{
	Gkey f = new Gkey();
  this.setVisible(false);
       f.setVisible(true);
       	this.setVisible(true); 	
}catch(Exception io){
io.printStackTrace();
}
}

 void button4_actionPerformed(ActionEvent e) 
{
    try{
	Eskey f = new Eskey();
  this.setVisible(false);
       f.setVisible(true);
       	this.setVisible(true); 	
}catch(Exception io){
io.printStackTrace();
}  
}     
 void button5_actionPerformed(ActionEvent e) 
{
    try{
	Dskey f = new Dskey();
  this.setVisible(false);
       f.setVisible(true);
       	this.setVisible(true); 	
}catch(Exception e1){
e1.printStackTrace();
}  
}     		
      		
       		
    		
      		

}

