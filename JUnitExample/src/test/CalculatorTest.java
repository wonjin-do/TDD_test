package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {
	//ctrl + F11 �� ����
	//alt + ����Ű : �ڵ��̵�
	//ctrl + alt + ����Ű : �ڵ庹���̵�
	private Calculator cal;//���������ڴ� private
	
	@Before //before ������̼����� �ʱ�ȭ�� �����Ѵ�. �� �׽�Ʈ���� �ʱ�ȭ�� ����ǹǷ� �׽�Ʈ�� �������� ������. 
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
	
	@After//�׽�Ʈ ���� ó���۾�(�ڿ��ݳ���)
	public void teardown() {
		System.out.println("teardown!");
	}

}
