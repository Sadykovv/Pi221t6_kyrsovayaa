package snippet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//класс реализующий слушатель (ожидания нажатия кнопки)
class Event implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		System.exit(1);
		
	}

	}

