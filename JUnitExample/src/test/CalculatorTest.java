package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {
	//ctrl + F11 로 실행
	//alt + 방향키 : 코드이동
	//ctrl + alt + 방향키 : 코드복사이동
	//alt + shift + R : rename refactoring
	private Calculator cal;//접근제어자는 private
	
	@Before //before 어노테이션으로 초기화를 진행한다. 매 테스트마다 초기화가 진행되므로 테스트의 독립성을 보장함. 
	public void setup() {
		cal = new Calculator();
	}
	
	@Test
	public void add_null_또는_빈문자() {
		assertEquals(0, cal.add(null));
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void add_숫자하나()throws Exception {
		assertEquals(1, cal.add("1"));
	}
	@Test
	public void add_쉽표구분자() throws Exception {
		assertEquals(3, cal.add("1,2"));
	}
	
	@Test
	public void add_쉼표_또는_콜론_구분자()throws Exception {
		assertEquals(6, cal.add("1,2:3"));
	}
	
	@Test
	public void add_custom_구분자()throws Exception {
		assertEquals(6, cal.add("//;\n1;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_negative()throws Exception {
		//음수가 발견되면 런타임에러를 발생시켜라
		cal.add("-1,2,3");
	}

	
	@After//테스트 이후 처리작업(자원반납등)
	public void teardown() {
		
	}

}
