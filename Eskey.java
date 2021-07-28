import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FileDialog.*;
import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.*;

public class Eskey extends Frame
{
     TextField textField1 = new TextField();
     TextField textField2 = new TextField();
     TextField textField3 = new TextField();
     
     Label label1 = new Label();
     Label label2 = new Label();
     Label label3 = new Label();
    
     Button button1 = new Button();
     Button button2 = new Button();
     Button button3 = new Button();
     Button button4 = new Button();
     Button button5 = new Button();
     
public Eskey() throws Exception
{
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
try{
       eskey();  
}
catch(IOException io){
io.printStackTrace();
}
}
        		
public void eskey () throws Exception
{
         this.setLayout( null );
this.setSize(new Dimension(500, 500));
         	this.setBackground(new java.awt.Color(214, 255, 239));
             	this.setFont(new Font("Dialog", 0, 15));
        		this.setTitle("Symmetric key encryption");
        
          textField1.setBounds(new Rectangle(80,100,180,30));
           textField2.setBounds(new Rectangle(80,260,180,30));
           textField3.setBounds(new Rectangle(80,170,180,30));
          
           button5.setBounds(new Rectangle(300,170,110,30));
         
           button1.setBounds(new Rectangle(100,300,110,30));
          button2.setBounds(new Rectangle(300,100,110,30));
           button3.setBounds(new Rectangle(300,260,110,30));
           label1.setBounds(new Rectangle(80,70,200,30));
            label2.setBounds(new Rectangle(60,235,250,30));
            label3.setBounds(new Rectangle(80,145,170,30));
              
            label1.setText("Enter Symmetric key");
            label2.setText("Select File to Store Encrypted Key");
            label3.setText("Public key to encrypt");
           
            button2.setLabel("Browse ");
           button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
      button2_actionPerformed(e);
                       
            }
            });

            button3.setLabel("Browse ");
           button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
       button3_actionPerformed(e);
            }
            });
                      button4.setLabel("Close");
        		button4.setBounds(new Rectangle(100, 400, 110, 30));
        		button4.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    	}
                	});
 button5.setLabel("Browse ");
           button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{
      button5_actionPerformed(e);
                       
            }
            });
 
                 this.addWindowListener(new WindowAdapter() {
                    	public void windowClosing(WindowEvent e) {setVisible(false);}});
button1.setLabel("Encrypt key ");
            button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
{     
          try{
	  esKey(e); 
}catch(Exception io){
io.printStackTrace();
}
     
                       
            }
            });
   this.add(textField1,null);
   this.add(textField2,null);
 this.add(textField3,null);

this.add(button1,null);
this.add(button2,null);
this.add(button3,null);
this.add(button4,null);
this.add(button5,null);

this.add(label1,null);
this.add(label2,null);
this.add(label3,null);
 
}
private void button3_actionPerformed(ActionEvent e) 
{  
      FileDialog f=new FileDialog(this,"Select a file");
        			f.setVisible(true);
        			this.textField2.setText(f.getDirectory()+f.getFile());
}
private void button2_actionPerformed(ActionEvent e) 
{  
      FileDialog f=new FileDialog(this,"Select a file");
        			f.setVisible(true);
        			this.textField1.setText(f.getDirectory()+f.getFile());
}
private void button5_actionPerformed(ActionEvent e) 
{  
      FileDialog f=new FileDialog(this,"Select a file");
        			f.setVisible(true);
        			this.textField3.setText(f.getDirectory()+f.getFile());
      			
}

 private void esKey(ActionEvent e) throws Exception
{  
 
FileInputStream fis = new FileInputStream(textField3.getText());
FileInputStream fis1 = new FileInputStream(textField1.getText());
FileOutputStream fis2 = new FileOutputStream(textField2.getText(),false);
try
 {
     
         
File file1 = new File(textField1.getText());
byte[] data1 = new byte[(int) file1.length()];
fis1.read(data1);
File file = new File(textField3.getText());
byte[] data = new byte[(int) file.length()];
fis.read(data);
   
KeyFactory kf = KeyFactory.getInstance("RSA"); // or "EC" or whatever

PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(data));

  
  //Creating a Cipher object
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
  //Initializing a Cipher object
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
     cipher.update(data1);
  //encrypting the data
      byte[] cipherText = cipher.doFinal();
       fis2.write(cipherText);
fis.close();
 fis2.close();
fis1.close();
 }
catch(Exception ex)
 {
     ex.printStackTrace();
 }   
}
}

