package TestForm;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;


import snippet.Form;

public class FormTest1 {

	@Test
	public void main() throws MalformedURLException, IOException {
		Form start = new Form();
		assertNotNull(start);
	}
}
