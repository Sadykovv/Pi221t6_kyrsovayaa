package snippet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class ForRaschet {
	
	public static String promocode;
	public static String skidka_on_promo;
	public static File files;
	public static Scanner scan;
	
  private String square;
  private String w1;
  private String cupon;
  private String w2;
  private String w3;
  private String w4;
  
  private boolean true1; 
  private boolean true2; 
  
  protected double san;
  protected double him;
  public static double itog;
  protected double typ;
  protected double ty;
  
  protected int sq;
  protected int x1;
  protected int x2;
  protected int x3;
  protected int x4;
  protected int skidka;

  public void raschet()   {
	  
	  files = new File("promo.txt");			//ЧТЕНИЕ ФАЙЛА С ЛОГИНОМ И ПАРОЛЕМ
	     scan = null;
		try {
			scan = new Scanner(new FileInputStream(files));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
			  promocode = scan.next();//Логин пользователя
			  skidka_on_promo = scan.next();//Пароль пользователя
			  
	        scan.close();
	        
	    

	        
	  Map<String, Integer> myMap = new HashMap<String, Integer>() {{ //купончики
		  put(promocode, Integer.parseInt(skidka_on_promo));
		  put("1000", 1000);
		  put("Ananas",1000);
		  }};		  
		  if (cupon!=null)
		  if (myMap.get(cupon)==null)
		  skidka = 0;
		  else
		  skidka=myMap.get(cupon);	 
     try {
      sq = Integer.parseInt(square); 
      x1 = Integer.parseInt(w1); 
      x2 = Integer.parseInt(w2);
      x3 = Integer.parseInt(w3);
      x4 = Integer.parseInt(w4);// Перевод вводимого срока в число
     } catch (NumberFormatException e1) {
       JOptionPane.showMessageDialog(null,"Проверьте ввод данных","Error",JOptionPane.ERROR_MESSAGE); // Окно вывода ошибки при неверно введённых данных
       return;
       }  
     typ = 1000;
    ras(); // Вызов метода     
       if (true1) {
       him = 4000; 
       }
       if (true2) {
           san = 2000; 
           }

       
   	itog = ty + sq * 40 +(x1 + x2 + x3 +x4) * 399 + him + san - skidka;
       
     JOptionPane.showMessageDialog(null,"Total: " + itog); //
     }



public void setSquare(String square) { // Считывание пользовательского ввода
this.square = square;
}

public void setW1(String w1) { // Считывание пользовательского ввода
this.w1 = w1;
}
public void setPromo(String cupon) { // Считывание пользовательского ввода
this.cupon = cupon;
}
public void setW2(String w2) { // Считывание пользовательского ввода
this.w2 = w2;
}
public void setW3(String w3) { // Считывание пользовательского ввода
this.w3 = w3;
}
public void setW4(String w4) { // Считывание пользовательского ввода
this.w4 = w4;
}
public void setTrue1(boolean true1) { // Считывание пользовательского ввода
this.true1 = true1;
}
public void setTrue2(boolean true2) { // Считывание пользовательского ввода
this.true2 = true2;
}


public abstract void ras(); // Создание абстрактного метода

}