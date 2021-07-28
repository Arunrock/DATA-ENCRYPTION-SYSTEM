import java.io.*;
import java.nio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FileDialog;


public class Dec extends Dialog {
    	  TextField textField1 = new TextField();
           TextField textField2 = new TextField();
          TextField textField3 = new TextField();
    	 Label label1 = new Label();
    	 Button button1 = new Button();
    	 Button button2 = new Button();
    	 Button button3 = new Button();
         Button button4 = new Button();
         Button button5 = new Button();
    	 Scrollbar scrollbar1 = new Scrollbar();
    	 Label label5 = new Label();
          Label label6 = new Label();
          Label label7 = new Label();


    	public Dec(Frame parent, String title, boolean modal) {
        		super(parent, title, modal);
        		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        		try {
            		Dec();
        		} 
catch (Exception e) { e.printStackTrace(); }
    	}

    	private void Dec() throws Exception {
        		this.setSize(new Dimension(629, 629));
        		this.setLayout( null );
        		this.setFont(new Font("Dialog", 0, 16));
        		this.setBackground(new Color(214, 255, 239));
        		this.setBounds(new Rectangle(150, 10, 629, 400));
        		this.addWindowListener(new WindowAdapter() {
                    	public void windowClosing(WindowEvent e) {
                       		setVisible(false); } 
});
        	textField1.setBounds(new Rectangle(90, 60, 400, 30));
        	textField1.setFont(new Font("Tahoma", 0, 14));
                textField2.setBounds(new Rectangle(90, 130, 400, 30));
        	textField2.setFont(new Font("Tahoma", 0, 14));
                 textField3.setBounds(new Rectangle(90, 210, 400, 30));
        	textField3.setFont(new Font("Tahoma", 0, 14));
        	label1.setText("File:");
        	label1.setBounds(new Rectangle(50, 60, 35, 30));
        	label1.setFont(new Font("Tahoma", 0, 16));
                label6.setText("select file which has symmetric key");
        	label6.setBounds(new Rectangle(90, 100, 250, 30));
                label7.setText("select file to store decrypt data");
        	label7.setBounds(new Rectangle(90, 170, 240, 30));
        	label6.setFont(new Font("Tahoma", 0, 16));
                
        	button1.setLabel("Browse....");
        	button1.setBounds(new Rectangle(493, 60, 110, 30));
        	button1.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
                    button1_actionPerformed(e); }
      	});

        	button2.setLabel("Decrypt");
        	button2.setBounds(new Rectangle(240, 250, 110, 30));
        	button2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
                    button2_actionPerformed(e); }
           });
        	button3.setLabel("Close");
        	button3.setBounds(new Rectangle(493, 300, 110, 30));
        	button3.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent e) {
          		button3_actionPerformed(e); }
           });
                button4.setLabel("Browse....");
        		button4.setBounds(new Rectangle(493, 130, 110, 30));
        		button4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {button4_actionPerformed(e);}});
                button5.setLabel("Browse....");
        	button5.setBounds(new Rectangle(493, 210, 110, 30));
        	button5.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
                    button5_actionPerformed(e); }
      	});
        	scrollbar1.setBounds(new Rectangle(120, 340, 480, 30));
        	scrollbar1.setOrientation(0);
        	scrollbar1.setVisibleAmount(5);
        	scrollbar1.setBlockIncrement(5);
        	scrollbar1.setMaximum(255);
        	scrollbar1.setVisible(false);
        	label5.setText("Please wait....");
        	label5.setBounds(new Rectangle(5, 290, 110, 30));
        	label5.setFont(new Font("Tahoma", 0, 16));
        	label5.setVisible(false);

        	this.add(label5, null);
                 this.add(label6, null);
                this.add(label7, null);
        	this.add(scrollbar1, null);
        	this.add(button3, null);
                 this.add(button4, null);
                 this.add(button5, null);
        	this.add(button2, null);
        	this.add(button1, null);
        	this.add(label1, null);
        	this.add(textField1, null);
                this.add(textField2, null);
                 this.add(textField3, null);
}

    	protected void processWindowEvent(WindowEvent e) {
        		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            	cancel();
        		}
        		super.processWindowEvent(e);
    	}

    	void cancel() { }
private void button1_actionPerformed(ActionEvent e) {
        		FileDialog f=new FileDialog(this,"Select a file");
        		f.setVisible(true);
        		this.textField1.setText(f.getDirectory()+f.getFile());
    	}
    	private void button2_actionPerformed(ActionEvent e) {
try{
				           Decryt();  
}catch(IOException io){
io.printStackTrace();
}
			
		           //Run Scrollbar
			
                 this.scrollbar1.setVisible(true);
		this.label5.setVisible(true);
		runScrollbar();
		this.scrollbar1.setVisible(false);
		this.label5.setVisible(false);
            		//Done
        		
		}
		
		void Decryt() throws IOException,FileNotFoundException
		{
                    
                        FileInputStream io = new FileInputStream(textField2.getText());
                       File file1 = new File(textField2.getText());
                         byte[] data1 = new byte[(int) file1.length()];
                          io.read(data1);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
                      byte[] data2= {(byte)'L'}; 
                     baos.write(data1);
                      baos.write(data2);
                         byte[] data3 = baos.toByteArray();
                         
                           long  s =ByteBuffer.wrap(data3).getInt();
                        s = (s < 0 ? -s : s);
			FileOutputStream uo = new FileOutputStream(textField3.getText());
			   FileInputStream oi = new FileInputStream(textField1.getText());
                          if (data1.length>=8)
                      {
			    int n = 0; 
			   while((n = oi.read())!=-1)
			   { 
                              
                              if (n!=-1)
                              {  
                                    System.out.println(" cipher text"+     (char)n);
                                      System.out.println("ascii value of cipher text"+     n);
                                  
                                    long b=0;
                                          long k = (n -s ) % 128;
                                          if(k<0)
                                         {
                                            b = k+128;
                                          }
                                          else
                                           {
                                             b=k;
                                            }
					   char ch1 = (char)b;
                                           System.out.println("plain text"+   ch1); 
                                           System.out.println("ascii value of plain text"+    (int)ch1); 
                                           int i1 = ch1;
				  uo.write(i1); 
                               }
                            else
                           {
                               System.out.println("End of file");      
                                   }
				   
			   } 
                          oi.close();
                          uo.close(); 
                     }
         else{
               
                   MsgBox b =new MsgBox();
                            b.setVisible(true);

                }
		   } 
     	   
private void runScrollbar() {
       		try{
          		for(int i=1;i<=255;i++) {
                    		this.scrollbar1.setValue(i);
                    		Color c=new Color(i,0,0);
                    		this.scrollbar1.setBackground(c);
                    		Thread.sleep(10);
    		}
        	}
catch(Exception ee){}
    	}

     	private void button3_actionPerformed(ActionEvent e) {
        		this.setVisible(false);
    	}
 private void button4_actionPerformed(ActionEvent e) {
        		FileDialog f=new FileDialog(this,"Select a file");
        		f.setVisible(true);
        		this.textField2.setText(f.getDirectory()+f.getFile());
    	}
 private void button5_actionPerformed(ActionEvent e) {
        		FileDialog f=new FileDialog(this,"Select a file");
        		f.setVisible(true);
        		this.textField3.setText(f.getDirectory()+f.getFile());
    	}
}

