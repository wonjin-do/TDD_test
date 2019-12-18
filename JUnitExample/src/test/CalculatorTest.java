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
	//alt + shift + R : rename refactoring
	private Calculator cal;//���������ڴ� private
	
	@Before //before ������̼����� �ʱ�ȭ�� �����Ѵ�. �� �׽�Ʈ���� �ʱ�ȭ�� ����ǹǷ� �׽�Ʈ�� �������� ������. 
	public void setup() {
		cal = new Calculator();
	}
	
	@Test
	public void add_null_�Ǵ�_����() {
		assertEquals(0, cal.add(null));
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void add_�����ϳ�()throws Exception {
		assertEquals(1, cal.add("1"));
	}
	@Test
	public void add_��ǥ������() throws Exception {
		assertEquals(3, cal.add("1,2"));
	}
	
	@Test
	public void add_��ǥ_�Ǵ�_�ݷ�_������()throws Exception {
		assertEquals(6, cal.add("1,2:3"));
	}
	
	@Test
	public void add_custom_������()throws Exception {
		assertEquals(6, cal.add("//;\n1;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_negative()throws Exception {
		//������ �߰ߵǸ� ��Ÿ�ӿ����� �߻����Ѷ�
		cal.add("-1,2,3");
	}

	
	@After//�׽�Ʈ ���� ó���۾�(�ڿ��ݳ���)
	public void teardown() {
		
	}

}
