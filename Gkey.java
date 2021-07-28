import java.io.*;
import java.security.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FileDialog.*;


public class Gkey extends Frame
{
     TextField textField1 = new TextField();
     TextField textField3 = new TextField();
     Label label3 = new Label();
      Label label6 = new Label();
      Button button1 = new Button();
     Button button2 = new Button();
      Button button4 = new Button();
     Button button5 = new Button();
     
public Gkey() throws Exception
{
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
try{
       gkey();  
}
catch(IOException io){
io.printStackTrace();
}
}
        		
public void gkey () throws Exception
{
         this.setLayout( null );
this.setSize(new Dimension(500, 500));
         	this.setBackground(new java.awt.Color(254, 215, 215));
             	this.setFont(new Font("Dialog", 0, 15));
        		this.setTitle("Key generation");
       
          textField1.setBounds(new Rectangle(80,200,180,30));
          
            textField3.setBounds(new Rectangle(80,300,180,30));
           
           button1.setBounds(new Rectangle(100,350,110,30));
           button2.setBounds(new Rectangle(300,200,110,30));
          
           button5.setBounds(new Rectangle(300,300,110,30));
           
            label3.setBounds(new Rectangle(80,270,230,30));
            
            label6.setBounds(new Rectangle(80,160,230,30));
            
            label3.setText("Select Files to Store Private Key");
           
            label6.setText("Select Files To Store Public Key");
           
            button2.setLabel("Browse ");
            button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
      button2_actionPerformed(e);
                       
            }
            });

         
                 this.addWindowListener(new WindowAdapter() {
                    	public void windowClosing(WindowEvent e) {setVisible(false);}});
               button5.setLabel("Browse ");
            button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
      button5_actionPerformed(e);
                       
            }
            });
 button1.setLabel("Generate key ");
            button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
 try{
	  gKey(e); 
}catch(Exception io){
io.printStackTrace();
}
                       
            }
            });
   this.add(textField1,null);
  
this.add(textField3,null);

this.add(button1,null);
this.add(button2,null);

this.add(button4,null);
this.add(button5,null);

this.add(label3,null);

this.add(label6,null);


}

private void button5_actionPerformed(ActionEvent e) 
{  
      FileDialog f=new FileDialog(this,"Select a file");
        			f.setVisible(true);
        			this.textField3.setText(f.getDirectory()+f.getFile());

}
private void button2_actionPerformed(ActionEvent e) 
{  
      FileDialog f=new FileDialog(this,"Select a file");
        			f.setVisible(true);
        			this.textField1.setText(f.getDirectory()+f.getFile());

}

private void button4_actionPerformed(ActionEvent e) 
{  
      this.setVisible(false);
}
 void gKey(ActionEvent e) throws Exception 
{    
     FileOutputStream io = new FileOutputStream(textField1.getText(),false);  
    
       FileOutputStream ou = new FileOutputStream(textField3.getText());
     
  //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generate the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();   
      
      //Getting the public key from the key pair
       PublicKey publicKey = pair.getPublic();
       
      byte[] a3;
       a3=publicKey.getEncoded();;
       
          io.write(a3);
         
    
      PrivateKey privateKey = pair.getPrivate();
        
         byte[] b3;
          b3=privateKey.getEncoded();;
         
              ou.write(b3);
        

 io.close();

ou.close();

}
}

