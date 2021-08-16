import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QR_reader {
public static void main(String arg[]) {
	 try {
JFileChooser choose=new JFileChooser();
choose.showOpenDialog(null);
File path=choose.getSelectedFile();
			//String path="C:\\Users\\Lenovo\\Desktop\\qr.jpg";
		BufferedImage image=ImageIO.read(new FileInputStream(path));
			 BinaryBitmap img=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)) );
			Result result= new MultiFormatReader().decode(img);
			System.out.println(result.getText());
		JOptionPane.showMessageDialog(null, result.getText(),"QR - DATA",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(path.getAbsolutePath()) );	
		} catch (Exception e) {
			// TODO: handle exception

}
}}
