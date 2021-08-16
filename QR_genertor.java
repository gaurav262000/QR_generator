import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QR_genertor{
	public static void main(String  arg[]) {
try {
	JFrame frame=new JFrame("QR_genretor");
	
	
	
	JTextField t1,t2,t3;  
    t1=new JTextField("Welcome to Javatpoint.");  
    t1.setBounds(50, 50, 100 ,30);
    JButton b1=new JButton("choose file");  
    b1.setBounds(150,50,100,30);  
frame.add(b1); 
b1.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){ 
	JFileChooser choose=new JFileChooser();
	choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	choose.showOpenDialog(null);
	File path=choose.getCurrentDirectory();
           t1.setText(path.getAbsolutePath());  
       }  
   });  
    t2=new JTextField("qr name");  
    t2.setBounds(50,100, 100,30);  
    t3=new JTextField("text");  
    t3.setBounds(50, 150, 100 ,30);
    
    frame.add(t1); frame.add(t2);  
    frame.add(t3);
    JButton b=new JButton("Click Here");  
    b.setBounds(50,200,95,30);  
frame.add(b); 
	frame.setSize(400, 400); 
	b.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){ 
		String file=t1.getText();
		String name=t2.getText();
		String filename=file+"\\"+name+".jpg";
		File f=new File(filename);
		System.out.println(f);
		String text=t3.getText();
		BitMatrix m;
		try {
			m = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 500, 500);
			MatrixToImageWriter.writeToFile(m, "jpg", f);
			JOptionPane.showMessageDialog(	null,new ImageIcon(f.getAbsolutePath()));
		} catch (WriterException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}  
		   });  
	
	 frame.setLayout(null);  
    frame.setLocationRelativeTo(null);  
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
//	File file=new File("C:\\Users\\Lenovo\\Desktop\\qr.jpg");
	//String path="C:\\Users\\Lenovo\\Desktop\\qr.jpg";
	

	System.out.println("done");
}
catch(Exception e) {
	e.printStackTrace();
}
	}
}
