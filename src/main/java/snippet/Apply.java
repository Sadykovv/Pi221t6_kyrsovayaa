package snippet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Apply implements ActionListener {
	public static File file;
	public static String prom;
	public static String skid;
	public static PrintWriter writer;
	@Override
	public void actionPerformed(ActionEvent arg0) {
	prom = Form.inputpromo2.getText();
	skid = Form.sk_field.getText();	
	
	file = new File("promo.txt");

	
	try {
		writer = new PrintWriter(file, "UTF-8");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		writer.println(prom);
		writer.println(skid);
		writer.close();
		

}
}