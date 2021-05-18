package information.test;

import static org.junit.Assert.*;


import org.junit.Test;

import snippet.Information;

public class TestInformation {

@Test
public void test() {
String obr1 = "Состав команды:";
assertEquals(obr1,Information.name);

}

}
