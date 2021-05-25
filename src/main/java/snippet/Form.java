package snippet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //���������� ��� ������� ���������
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)




//��� ������ ������� � ������������� ���������� Maven - "package shade:shade"

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
	JFrame JFrame1 = new JFrame("calculator  "); // �������� ������������ ����
	JFrame main_GUI = new JFrame("�����������");
	JFrame main_GUI2 = new JFrame("�����������");
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
	     
	JFrame1.setTitle ("Autorization"); 	//�������� ����� �����������
	JFrame1.setBounds(400,200,400,350);
	JFrame1.setResizable(false); // ������������� ������ ����
	
	JPanel auth = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
	auth.setLayout(null); 
	InputStream is = getClass().getResourceAsStream("/1.txt");				//������ ����� � ������� � �������
	Scanner scan = new Scanner(is);
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));	
		  d=scan.next();//����� ������������
          q=scan.next();//������ ������������
          h=scan.next();//����� ��������������
          j=scan.next();//������ ��������������
        scan.close();
   
       
	JButton but_login = new JButton("Enter ");								//������ �����
	but_login.setBounds(250,235,105,30);
	but_login.addActionListener(new ActionListener() {						//���������� ��������� � ������ �����	
		
		
		public void actionPerformed(ActionEvent e) {									//��������� ��������� ��� �����
			if(log.getText().equals(d) && pas.getText().equals(q)) {
				
				JOptionPane.showMessageDialog(null, "Welcome", "welcome", 1);
			but_loginActionPerformed(e);
			}
			else if (log.getText().equals(h)&&pas.getText().equals(j)) {
					JOptionPane.showMessageDialog(null, "Welcome", "welcome", 1);
					
					but_loginActionPerformed(e);
			}
			else {
            	JOptionPane.showMessageDialog(null, "Error", "Check youre login or password", 0);
            	pas.setText("");
            	log.setText("");
            
			}	
			
		}
		
			private void but_loginActionPerformed(ActionEvent e) {
				
			       
				if(log.getText().equals(d) && pas.getText().equals(q)) {       										//������� ��� ����� �������� ������������
																													//�������� ����� ������������ ��� ������� �������������
					main_GUI.setTitle ("calcilator of cleaning");										
					main_GUI.setBounds(600,600,400,400);
					main_GUI.setResizable(false);																	// ������������� ������ ����
					
					main_GUI.add(main_panel);
					main_panel.setLayout(null); 
				    JFrame1.dispose();    	
				    JPanel main_panel = new JPanel(); 																// ������ - ������������ ��� ����������� ����������� � ����
					main_panel.setLayout(null);
					main_GUI.add(main_panel);
					main_GUI.setVisible(true);
					main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										// �������� ���� JFrame � �������� Java
					

					String a = "����";
						JMenuBar menubar = new JMenuBar();
						JMenu menu = new JMenu("Menu");
						menubar.add(menu);
						JMenuItem inform = new JMenuItem("Information about developers");
						JMenuItem exit = new JMenuItem("Exit");
						menu.add(inform);
						menu.add(exit);
						main_GUI.setJMenuBar(menubar);
						ActionListener inf_listener = new Information();
						inform.addActionListener(inf_listener);	
						

						ActionListener actionListener = new Event(); //������� ���������
						exit.addActionListener(actionListener);
						
						
			     
					main_panel.add(win1);
					main_panel.add(win2);
					main_panel.add(win3);
					main_panel.add(win4);
					win1.setVisible(false);
					win2.setVisible(false);
					win3.setVisible(false);
					win4.setVisible(false);

					
					JLabel laba_info = new JLabel("Type:"); // ����������� ������ ��� �����������
					laba_info.setBounds(40,45,150,30);
					
					main_panel.add(laba_info);
					
					input = new JTextField("");
					input.setBounds(150, 83, 130, 23);
					main_panel.add(input);
					
					
					JLabel Slabel = new JLabel("Square:"); // ����������� ������ ��� �����������
					Slabel.setBounds(40,80,150,30);
					main_panel.add(Slabel);
					JLabel window= new JLabel("Cleaning window:"); // ����������� ������ ��� �����������
					window.setBounds(40,110,150,30);
					main_panel.add(window);
					JCheckBox galochka = new JCheckBox();
					galochka.setBounds(165, 115, 20, 20);
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
					JLabel window1 = new JLabel("One window"); // ����������� ������ ��� �����������
					window1.setBounds(60,170,130,30);
					window1.setVisible(false);
					main_panel.add(window1);
					JLabel window2 = new JLabel("Two windows"); // ����������� ������ ��� �����������
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
					JLabel window3 = new JLabel("Three Window"); // ����������� ������ ��� �����������
					window3.setBounds(60,320,150,30);
					window3.setVisible(false);
					main_panel.add(window3);
					JLabel window4 = new JLabel("Window Block"); // ����������� ������ ��� �����������
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
					JLabel window33 = new JLabel("Square windows"); // ����������� ������ ��� �����������
					window33.setBounds(40,170,150,30);
					window33.setVisible(false);
					main_panel.add(window33);
					JLabel service2 = new JLabel("Clean toilet"); // ����������� ������ ��� �����������
					service2.setBounds(40,190,150,30);
					main_panel.add(service2);
					JCheckBox point3 = new JCheckBox("����� 3");
					point3.setBounds(160, 195, 20, 20);
					main_panel.add(point3);
					JLabel service1 = new JLabel("Clean furniture"); // ����������� ������ ��� �����������
					service1.setBounds(40,150,150,30);
					main_panel.add(service1);
					JCheckBox point33 = new JCheckBox("����� 3.1");
					point33.setBounds(160, 155, 20, 20);
					main_panel.add(point33);
					JLabel promo = new JLabel("Enter promo:"); // ����������� ������ ��� �����������
					promo.setBounds(40,240,150,30);
					main_panel.add(promo);
					JButton button_exit = new JButton("Exit"); // ��������� ������
					button_exit.setBounds(270,290,100,40);
					main_panel.add(button_exit);
					JTextField inputpromo = new JTextField("");
					inputpromo.setBounds(150, 243, 100, 23);
					main_panel.add(inputpromo);
					JButton raschet = new JButton("calculate"); // ��������� ������
					raschet.setBounds(40,290,180,40);
					main_panel.add(raschet);
					po1.setVisible(false);
					po2.setVisible(false);
					input_san.setVisible(false);
				 main_panel.add(win1);
				 
				 
				 	JButton button_create = new JButton("Create PDF"); // ��������� ������
				 	button_create.setBounds(270,240,100,35);
				 	ActionListener actionCreate = new ListenerCreate(); //������� ��������� ��� ������ PDF
					button_create.addActionListener(actionCreate); // ��������� ��������� � ������
				 	main_panel.add(button_create);

					String[] type = {"General", "after repair","daily"};
					JComboBox box = new JComboBox(type);
						box.setBounds(120, 45, 130, 30);
						box.setVisible(true);
						main_panel.add(box);
						ActionListener actionListener1 = new Event(); //������� ���������
				    	button_exit.addActionListener(actionListener1); // ��������� ��������� � ������

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


					raschet.addActionListener(new ActionListener() // ���������
					    	{
			    		
								@Override
					 public void actionPerformed(ActionEvent e) {
			         	if (box.getSelectedIndex() == 0) { // ���� ������� �����������
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
				else if (log.getText().equals(h) && pas.getText().equals(j)){            //������� ��� ����� ������
					
					main_GUI2.setTitle("calculate of cleaning services");				//�������� ��������� �����
					main_GUI2.setBounds(400,200,400,350);
					main_GUI2.setResizable(false);
					main_GUI2.setVisible(true);
					JPanel main_panel2 = new JPanel();
					main_panel2.setLayout(null); 
					main_GUI2.add(main_panel2);
					
				    JFrame1.dispose();    
				    JButton button_exit = new JButton("Exit"); // ��������� ������
					button_exit.setBounds(270,240,100,40);
					main_panel2.add(button_exit);
					main_GUI2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ActionListener actionListener1 = new Event(); //������� ���������
			    	button_exit.addActionListener(actionListener1); // ��������� ��������� � ������
			    	
					JLabel promo2 = new JLabel("New promo:"); // ����������� ������ ��� �����������	
					promo2.setBounds(40,200,150,30);			
					main_panel2.add(promo2);				
					
					inputpromo2 = new JTextField("");			// 	���� ����� ������ ���������	
					inputpromo2.setBounds(150, 203, 100, 23);
					main_panel2.add(inputpromo2);	
					

					JLabel sk = new JLabel("sum discont:"); // ����������� ������ ��� �����������	
					sk.setBounds(40,240,150,30);			
					main_panel2.add(sk);				
					
					sk_field = new JTextField("");			// 	���� ����� ������ ���������	
					sk_field.setBounds(150, 243, 100, 23);
					main_panel2.add(sk_field);	
					
					 JButton ok = new JButton("apply"); // ��������� ������
					 ok.setBounds(270,200,100,40);
					 main_panel2.add(ok);
					 
					 ActionListener actionListener_ok = new Apply(); //������� ���������
				    	button_exit.addActionListener(actionListener_ok); // ��������� ��������� � ������
				}		
			}
			
	});
	
	
	label(auth); // ���������� �������� 
	JFrame1.add(auth);
	JFrame1.setVisible(true);
	JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
	
	auth.add(but_login);
    	
		
	}
	void label(JPanel panel) throws FileNotFoundException {																		// ������ �����������
		
		 // �������� ���������� ����
       log.setBounds(100,105,200,30); // ��������� ���������� ���� ( ��� ��������� �� ������ ������������ x,y;������, �����)
       panel.add(log); // ���������� ���������� ���� �� ������
       JLabel laba_log = new JLabel("elogin");
       laba_log.setBounds(100,80,300,30);
       panel.add(laba_log);

       JLabel laba_pass = new JLabel("enter password");
       laba_pass.setBounds(100,130,300,30);
       panel.add(laba_pass);
       pas.setBounds(100,155,200,30); //  ��������� ���������� ���� ( ��� ��������� �� ������ ������������ x,y;������, �����)
       panel.add(pas); // ���������� ���������� ���� �� ������
	
   }	
								

	public static void main(String[] args) throws IOException   { 
		
		kurs_pi = new Form();
	
}

}
