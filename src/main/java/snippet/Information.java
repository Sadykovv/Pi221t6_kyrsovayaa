package snippet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class Information implements ActionListener {

public static String name = "Состав команды:";
@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
public void actionPerformed(ActionEvent e) {

JFrame inf_Frame = new JFrame("Main"); // создание графического окна
inf_Frame.setTitle ("Информация");
inf_Frame.setBounds(150,120,400,300);
inf_Frame.setResizable(false); // фиксированный размер окна



JPanel inf_panel = new JPanel();
inf_panel.setLayout(null);
inf_Frame.add(inf_panel);


inf_Frame.setVisible(true);


JLabel Label_info1 = new JLabel(name);
Label_info1.setBounds(15,30,100,20);
inf_panel.add(Label_info1);

JLabel Label_info2 = new JLabel("Садыков Алишер Абдувалиевич №19150093");
Label_info2.setBounds(70,60,300,20);
inf_panel.add(Label_info2);

JLabel Label_info3 = new JLabel("Гусева Диана Артемовна №19150089");
Label_info3.setBounds(70,90,300,20);
inf_panel.add(Label_info3);

JLabel Label_info4 = new JLabel("Барбашин Илья Дмитриевич №19130621");
Label_info4.setBounds(70,120,300,20);
inf_panel.add(Label_info4);


JLabel Label_info5 = new JLabel("Васильева Кристина Ринатовна №19130012");
Label_info5.setBounds(70,150,300,20);
inf_panel.add(Label_info5);



}

}