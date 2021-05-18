package TestForm;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;

public class FormTest {


	@Test
	public void test() {
			
	JTextField input = new JTextField();
	input.setBounds(150, 83, 130, 23);

	assertTrue(input.isEditable());
			
	}

}
