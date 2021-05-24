package snippet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*; // Библиотека для GUI (построена на основе awt)




//для сборки проекта с зависимостями используем Maven - "package shade:shade"

public class Form {

	public static Form kurs_pi;
	public static JTextField input;
	public static JTextField inputW1;
	public static JTextField inputW2;
	public static JTextField inputW3;
	public static JTextField inputW4;
	private final JTextField log = new JTextField();
	private static JTextField pas = new JTextField();
	
	public static JTextField inputpromo2 =  new JTextField();
	public static JTextField sk_field =  new JTextField();
			
	private JPanel main_panel = new JPanel(); 
	private JPanel main_panel2 = new JPanel(); 
	public static String d;
	public static String q;
	public static String h;
	public static String j;
	JFrame JFrame1 = new JFrame("calculator"); // создание графического окна
	JFrame main_GUI = new JFrame("Калькулятор");
	JFrame main_GUI2 = new JFrame("Калькулятор");
	Raschet ras = new Raschet();
	int X = 30;
	int Z = 60;
	int Y = 300;


	public Form() throws MalformedURLException, IOException {
		JLabel win1 = new JLabel();
		 ImageIcon icon = new ImageIcon(ImageIO.read(this.getClass().getResource("/picture/win_01.jpg")));
		 win1.setIcon(icon);
		 win1.setBounds(60,160,200,200);
		
		 JLabel win2 = new JLabel();
		 ImageIcon icon2 = new ImageIcon(ImageIO.read(this.getClass().getResource("/picture/win_02.jpg")));
		 win2.setIcon(icon2);
	     win2.setBounds(220,160,200,200);
	        
	     JLabel win3 = new JLabel();
	     ImageIcon icon3 = new ImageIcon(ImageIO.read(this.getClass().getResource("/picture/win_03.jpg")));
		 win3.setIcon(icon3);
	     win3.setBounds(60,310,200,200);
	        
	     JLabel win4 = new JLabel();
		 ImageIcon icon4 = new ImageIcon(ImageIO.read(this.getClass().getResource("/picture/win_04.jpg")));
		 win4.setIcon(icon4);
	     win4.setBounds(220,310,200,200);
	     
	JFrame1.setTitle ("Авторизация"); 	//СОЗДАНИЕ ФОРМЫ АВТОРИЗАЦИИ
	JFrame1.setBounds(400,200,400,350);
	JFrame1.setResizable(false); // фиксированный размер окна
	
	JPanel auth = new JPanel(); // Панель - используется для организации компонентов в окне
	auth.setLayout(null); 
	InputStream is = getClass().getResourceAsStream("/1.txt");				//ЧТЕНИЕ ФАЙЛА С ЛОГИНОМ И ПАРОЛЕМ
	Scanner scan = new Scanner(is);
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));	
		  d=scan.next();//Логин пользователя
          q=scan.next();//Пароль пользователя
          h=scan.next();//Логин администратора
          j=scan.next();//Пароль администратора
        scan.close();
   
       
	JButton but_login = new JButton("Войти");								//КНОПКА ВХОДА
	but_login.setBounds(250,235,105,30);
	but_login.addActionListener(new ActionListener() {						//ДОБАВЛЕНИЕ СЛУШАТЕЛЯ К КНОПКЕ ВХОДА	
		
		
		public void actionPerformed(ActionEvent e) {									//НАПИСАНИЕ СЛУШАТЕЛЯ ДЛЯ ВХОДА
			if(log.getText().equals(d) && pas.getText().equals(q)) {
				
				JOptionPane.showMessageDialog(null, "Вы успешно вошли", "Добро пожаловать, вы вошли как обычный пользователь", 1);
			but_loginActionPerformed(e);
			}
			else if (log.getText().equals(h)&&pas.getText().equals(j)) {
					JOptionPane.showMessageDialog(null, "Вы успешно вошли", "Добро пожаловать, вы вошли как администратор", 1);
					
					but_loginActionPerformed(e);
			}
			else {
            	JOptionPane.showMessageDialog(null, "Пожалуйста, проверьте правильность написания логина и пароля", "Не удается войти", 0);
            	pas.setText("");
            	log.setText("");
            
			}	
			
		}
		
			private void but_loginActionPerformed(ActionEvent e) {
				
			       
				if(log.getText().equals(d) && pas.getText().equals(q)) {       										//условие для входа простого пользователя
																													//Создание формы калькулятора для обычных пользователей
					main_GUI.setTitle ("Калькулятор клининговых услуг");										
					main_GUI.setBounds(600,600,400,400);
					main_GUI.setResizable(false);																	// фиксированный размер окна
					
					main_GUI.add(main_panel);
					main_panel.setLayout(null); 
				    JFrame1.dispose();    	
				    JPanel main_panel = new JPanel(); 																// Панель - используется для организации компонентов в окне
					main_panel.setLayout(null);
					main_GUI.add(main_panel);
					main_GUI.setVisible(true);
					main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										// закрытие окна JFrame и процесса Java
					

					String a = "Меню";
						JMenuBar menubar = new JMenuBar();
						JMenu menu = new JMenu("Меню");
						menubar.add(menu);
						JMenuItem inform = new JMenuItem("Информация о разработчиках");
						JMenuItem exit = new JMenuItem("Выход");
						menu.add(inform);
						menu.add(exit);
						main_GUI.setJMenuBar(menubar);
						ActionListener inf_listener = new Information();
						inform.addActionListener(inf_listener);	
						

						ActionListener actionListener = new Event(); //создаем слушатель
						exit.addActionListener(actionListener);
						
						
			     
					main_panel.add(win1);
					main_panel.add(win2);
					main_panel.add(win3);
					main_panel.add(win4);
					win1.setVisible(false);
					win2.setVisible(false);
					win3.setVisible(false);
					win4.setVisible(false);

					
					JLabel laba_info = new JLabel("Тип уборки:"); // Отображение текста или изображения
					laba_info.setBounds(40,45,150,30);
					
					main_panel.add(laba_info);
					
					input = new JTextField("");
					input.setBounds(150, 83, 130, 23);
					main_panel.add(input);
					
					
					JLabel Slabel = new JLabel("Площадь уборки:"); // Отображение текста или изображения
					Slabel.setBounds(40,80,150,30);
					main_panel.add(Slabel);
					JLabel window= new JLabel("Мытье окон :"); // Отображение текста или изображения
					window.setBounds(40,110,150,30);
					main_panel.add(window);
					JCheckBox galochka = new JCheckBox();
					galochka.setBounds(120, 115, 20, 20);
					main_panel.add(galochka);
					JRadioButton po1 = new JRadioButton("");
					po1.setBounds(115, 145, 20, 20);
					main_panel.add(po1);
					JRadioButton po2 = new JRadioButton("");
					po2.setBounds(340, 145, 20, 20);
					main_panel.add(po2);
					ButtonGroup group = new ButtonGroup();
					group.add(po1);
					group.add(po2); 
					JLabel window1 = new JLabel("Одностворчатое окно"); // Отображение текста или изображения
					window1.setBounds(60,170,130,30);
					window1.setVisible(false);
					main_panel.add(window1);
					JLabel window2 = new JLabel("Двухстворчатое окно"); // Отображение текста или изображения
					window2.setBounds(220,170,150,30);
					window2.setVisible(false);
					main_panel.add(window2);
					
					inputW1 = new JTextField("");
					inputW1.setBounds(60, 195, 30, 23);
					inputW1.setVisible(false);
					main_panel.add(inputW1);
					
					inputW2 = new JTextField("");
					inputW2.setBounds(220, 195, 30, 23);
					inputW2.setVisible(false);
					main_panel.add(inputW2);
					JLabel window3 = new JLabel("Трехстворчатое окно"); // Отображение текста или изображения
					window3.setBounds(60,320,150,30);
					window3.setVisible(false);
					main_panel.add(window3);
					JLabel window4 = new JLabel("Оконный блок"); // Отображение текста или изображения
					window4.setBounds(220,320,150,30);
					window4.setVisible(false);
					main_panel.add(window4);
					inputW3 = new JTextField("");
					inputW3.setBounds(60, 345, 30, 23);
					inputW3.setVisible(false);
					main_panel.add(inputW3);
					inputW4 = new JTextField("");
					inputW4.setVisible(false);
					inputW4.setBounds(220, 345, 30, 23);
					main_panel.add(inputW4);
					JTextField input_san = new JTextField("0");
					input_san.setBounds(190, 195, 30, 23);
					main_panel.add(input_san);
					JLabel window33 = new JLabel("Площадь окон"); // Отображение текста или изображения
					window33.setBounds(40,170,150,30);
					window33.setVisible(false);
					main_panel.add(window33);
					JLabel service2 = new JLabel("чистка сан-узла"); // Отображение текста или изображения
					service2.setBounds(40,190,150,30);
					main_panel.add(service2);
					JCheckBox point3 = new JCheckBox("Пункт 3");
					point3.setBounds(160, 195, 20, 20);
					main_panel.add(point3);
					JLabel service1 = new JLabel("Химчистка мебели"); // Отображение текста или изображения
					service1.setBounds(40,150,150,30);
					main_panel.add(service1);
					JCheckBox point33 = new JCheckBox("Пункт 3.1");
					point33.setBounds(160, 155, 20, 20);
					main_panel.add(point33);
					JLabel promo = new JLabel("Ввести промокод:"); // Отображение текста или изображения
					promo.setBounds(40,240,150,30);
					main_panel.add(promo);
					JButton button_exit = new JButton("Выход"); // добавляем кнопку
					button_exit.setBounds(270,290,100,40);
					main_panel.add(button_exit);
					JTextField inputpromo = new JTextField("");
					inputpromo.setBounds(150, 243, 100, 23);
					main_panel.add(inputpromo);
					JButton raschet = new JButton("Рассчитать стоимость"); // добавляем кнопку
					raschet.setBounds(40,290,180,40);
					main_panel.add(raschet);
					po1.setVisible(false);
					po2.setVisible(false);
					input_san.setVisible(false);
				 main_panel.add(win1);
				 
				 
				 	JButton button_create = new JButton("Create PDF"); // добавляем кнопку
				 	button_create.setBounds(270,240,100,35);
				 	ActionListener actionCreate = new ListenerCreate(); //создаем слушатель для кнопки PDF
					button_create.addActionListener(actionCreate); // добавляем слушатель к кнопке
				 	main_panel.add(button_create);

					String[] type = {"генеральная", "после ремонта","ежедневная"};
					JComboBox box = new JComboBox(type);
						box.setBounds(120, 45, 130, 30);
						box.setVisible(true);
						main_panel.add(box);
						ActionListener actionListener1 = new Event(); //создаем слушатель
				    	button_exit.addActionListener(actionListener1); // добавляем слушатель к кнопке

					galochka.addActionListener(new ActionListener() {
						public  void actionPerformed(ActionEvent actionEvent) {
							if (galochka.isSelected()) {
								main_GUI.setBounds(600,600,400,400 + X);
								service1.setBounds(40,150 + X,150,30);
								service2.setBounds(40,190 + X,150,30);
								point33.setBounds(160, 155 + X, 20, 20);
								point3.setBounds(160, 195 + X, 20, 20);
								button_exit.setBounds(270,290 + X,100,40);
								raschet.setBounds(40,290 + X,180,40);
								promo.setBounds(40,240 + X,150,30);
								inputpromo.setBounds(150, 243 + X, 150, 23);
								button_create.setBounds(270,240 + X,100,35);
								win1.setVisible(true);
								win2.setVisible(true);
								win3.setVisible(true);
								win4.setVisible(true); 
								window1.setVisible(true);
								window2.setVisible(true);
								window3.setVisible(true);
								window4.setVisible(true);
								inputW1.setVisible(true);
								inputW2.setVisible(true);
								inputW3.setVisible(true);
								inputW4.setVisible(true);
								main_GUI.setBounds(600,600,400,400 + Y);
								service1.setBounds(40,150 + Y,150,30);
								service2.setBounds(40,190 + Y,150,30);
								point33.setBounds(160, 155 + Y, 20, 20);
								point3.setBounds(160, 195 + Y, 20, 20);
								button_exit.setBounds(270,290 + Y,100,40);
								raschet.setBounds(40,290 + Y,180,40);
								promo.setBounds(40,240 + Y,150,30);
								inputpromo.setBounds(150, 243 + Y, 100, 23);
								button_create.setBounds(270,240 + Y,100,35);
								input_san.setBounds(190, 195 + Y, 30, 23);
								window33.setVisible(false);;
							}
							else {
								main_GUI.setBounds(600,600,400,400 );
								service1.setBounds(40,150,150,30);
								service2.setBounds(40,190,150,30);
								point33.setBounds(160, 155, 20, 20);
								point3.setBounds(160, 195, 20, 20);
								button_exit.setBounds(270,290,100,40);
								raschet.setBounds(40,290,180,40);
								promo.setBounds(40,240,150,30);
								inputpromo.setBounds(150, 243, 100, 23);
								input_san.setBounds(190, 195, 30, 23);
								button_create.setBounds(270,240,100,35);
								po1.setVisible(false);
								po2.setVisible(false);
								win1.setVisible(false);
								win2.setVisible(false);
								win3.setVisible(false);
								win4.setVisible(false);
								window1.setVisible(false);
								window2.setVisible(false);
								window3.setVisible(false);
								window4.setVisible(false);
								inputW1.setVisible(false);
								inputW2.setVisible(false);
								inputW3.setVisible(false);
								inputW4.setVisible(false);
								window33.setVisible(false);
								
							}
						}
					});


					raschet.addActionListener(new ActionListener() // слушатель
					    	{
			    		
								@Override
					 public void actionPerformed(ActionEvent e) {
			         	if (box.getSelectedIndex() == 0) { // если выбрана генеральная
			         		Raschet rasch = new Raschet();
			         		rasch.setSquare(input.getText()); 
			         		rasch.setW1(inputW1.getText());
			         		rasch.setW2(inputW2.getText());
			         		rasch.setW3(inputW3.getText());
			         		rasch.setW4(inputW4.getText());
			         		rasch.setPromo(inputpromo.getText());
			         		rasch.setTrue1(point33.isSelected());
			         		rasch.setTrue2(point3.isSelected());
			         		rasch.raschet();
			         		
			         	} else if (box.getSelectedIndex() == 1) { 
			         		Raschet1 rasch = new Raschet1();
			         		rasch.setSquare(input.getText()); 
			         		rasch.setW1(inputW1.getText());
			         		rasch.setW2(inputW2.getText());
			         		rasch.setW3(inputW3.getText());
			         		rasch.setPromo(inputpromo.getText());
			         		rasch.setW4(inputW4.getText());
			         		rasch.setTrue1(point33.isSelected());
			         		rasch.setTrue2(point3.isSelected());
			         		rasch.raschet();
			         	}
			         	else if (box.getSelectedIndex() == 2) {
			         		Raschet2 rasch = new Raschet2();
			         		rasch.setSquare(input.getText());
			         		rasch.setW1(inputW1.getText());
			         		rasch.setW2(inputW2.getText());
			         		rasch.setPromo(inputpromo.getText());
			         		rasch.setW3(inputW3.getText());
			         		rasch.setW4(inputW4.getText());
			         		rasch.setTrue1(point33.isSelected());
			         		rasch.setTrue2(point3.isSelected());
			         		rasch.raschet();
			         	}
					 }
				});	
					}
				else if (log.getText().equals(h) && pas.getText().equals(j)){            //условие для входа админа
					
					main_GUI2.setTitle("Калькулятор клининговых услуг");				//Создание админской формы
					main_GUI2.setBounds(400,200,400,350);
					main_GUI2.setResizable(false);
					main_GUI2.setVisible(true);
					JPanel main_panel2 = new JPanel();
					main_panel2.setLayout(null); 
					main_GUI2.add(main_panel2);
					
				    JFrame1.dispose();    
				    JButton button_exit = new JButton("Выход"); // добавляем кнопку
					button_exit.setBounds(270,240,100,40);
					main_panel2.add(button_exit);
					main_GUI2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ActionListener actionListener1 = new Event(); //создаем слушатель
			    	button_exit.addActionListener(actionListener1); // добавляем слушатель к кнопке
			    	
					JLabel promo2 = new JLabel("Новый промокод:"); // Отображение текста или изображения	
					promo2.setBounds(40,200,150,30);			
					main_panel2.add(promo2);				
					
					inputpromo2 = new JTextField("");			// 	ПОЛЕ ВВОДА НОВОГО ПРОМОКОДА	
					inputpromo2.setBounds(150, 203, 100, 23);
					main_panel2.add(inputpromo2);	
					

					JLabel sk = new JLabel("Сумма скидки:"); // Отображение текста или изображения	
					sk.setBounds(40,240,150,30);			
					main_panel2.add(sk);				
					
					sk_field = new JTextField("");			// 	ПОЛЕ ВВОДА НОВОГО ПРОМОКОДА	
					sk_field.setBounds(150, 243, 100, 23);
					main_panel2.add(sk_field);	
					
					 JButton ok = new JButton("Применить"); // добавляем кнопку
					 ok.setBounds(270,200,100,40);
					 main_panel2.add(ok);
					 
					 ActionListener actionListener_ok = new Apply(); //создаем слушатель
				    	button_exit.addActionListener(actionListener_ok); // добавляем слушатель к кнопке
				}		
			}
			
	});
	
	
	label(auth); // Размещение надписей 
	JFrame1.add(auth);
	JFrame1.setVisible(true);
	JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
	
	auth.add(but_login);
    	
		
	}
	void label(JPanel panel) throws FileNotFoundException {																		// ПАНЕЛЬ АВТОРИЗАЦИИ
		
		 // создание текстового поля
       log.setBounds(100,105,200,30); // параметры текстового поля ( его положение на панели относительно x,y;ширину, длину)
       panel.add(log); // Добавление текстового поля на панель
       JLabel laba_log = new JLabel("Введите логин");
       laba_log.setBounds(100,80,300,30);
       panel.add(laba_log);

       JLabel laba_pass = new JLabel("Введите пароль");
       laba_pass.setBounds(100,130,300,30);
       panel.add(laba_pass);
       pas.setBounds(100,155,200,30); //  параметры текстового поля ( его положение на панели относительно x,y;ширину, длину)
       panel.add(pas); // Добавление текстового поля на панель
	
   }	
								

	public static void main(String[] args) throws IOException   { 
		
		kurs_pi = new Form();
	
}

}
