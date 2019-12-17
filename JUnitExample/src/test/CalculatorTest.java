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
	private Calculator cal;//접근제어자는 private
	
	@Before //before 어노테이션으로 초기화를 진행한다. 매 테스트마다 초기화가 진행되므로 테스트의 독립성을 보장함. 
	public void setup() {
		cal = new Calculator();
		System.out.println("setup!");
	}
	
	@Test
	public void add() {
		assertEquals(3, cal.add(2,1));
		System.out.println("add!");
	}

	@Test
	public void div() {
		assertEquals(3, cal.div(9,3));
		System.out.println("div!");
	}
	
	@After//테스트 이후 처리작업(자원반납등)
	public void teardown() {
		System.out.println("teardown!");
	}

}
