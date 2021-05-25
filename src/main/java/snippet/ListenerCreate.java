package snippet;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ListenerCreate implements ActionListener {
	public static File files;
	public static Scanner scan;
	@Override 
	public void actionPerformed(ActionEvent arg0) { 
		Document document = new Document(); //создание класса Document
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Check.pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
			
		document.open(); 
		
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		String string_pdf = "HI GUYS!";
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "THIS IS YOUR PDF.";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    	
	    
	    //добавление изображения в pdf
	    URL url = getClass().getResource("/picture/black.jpg"); //
	    Image img = null;
		try {
			img = Image.getInstance(url.toString());
			
			
		} catch (BadElementException e2) {
			
			e2.printStackTrace();
		} catch (MalformedURLException e2) {
			
			e2.printStackTrace();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
		img.setAbsolutePosition(10000, 500); //позиционирование изображения в PDF
		
		try {
				document.add(img);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	    
	    
		 //организация перехода на следующую строку
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
		 
		 
	    //добавление таблицы
		 PdfPTable table = new PdfPTable(4); //создание таблицы с 4 столбцами
		 addHeader(table);
		 addRows(table);
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		document.close(); //закрытие и сохранение документа PDF
		
	}

	private void addRows(PdfPTable table) {
		
		//заполнение таблицы вводимыми значения в текстовые поля на главной форме
		String cell1 = "null";
		String cell2 = "null";
		String cell3 = "null";
		String cell4 = "null";
		String cell5 = "null";
		String cell6 = "null";
		String cell7 = "null";
		
		String total1 = String.valueOf(ForRaschet.itog);
		
		cell1 = Form.inputW1.getText();
		cell2 = Form.inputW2.getText();
		cell3 = Form.inputW3.getText();
		cell4 = Form.inputW4.getText();
		cell5 = Form.input.getText();
		cell6 = Form.sk_field.getText();
		cell7 = total1;
		
		files = new File("promo.txt");			//ЧТЕНИЕ ФАЙЛА С ЛОГИНОМ И ПАРОЛЕМ
	     scan = null;
		try {
			scan = new Scanner(new FileInputStream(files));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
			  String promocode = scan.next();//Логин пользователя
		
		int sum = Integer.parseInt(cell1) + Integer.parseInt(cell2) + Integer.parseInt(cell3) + Integer.parseInt(cell4);
		String summ = String.valueOf(sum);
		
		table.addCell(summ);
	    table.addCell(cell5);
		table.addCell(promocode);
	    table.addCell(cell7);

		
	    //выше должен быть текст на русском языке, как его вывести можно посмотреть в справке.
	}

	private void addHeader(PdfPTable table) {
		Stream.of("All windows", "Square", "Promo",  "total")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
		
	}

	
}
