package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//���������ڵ�
//�׽�Ʈ �߰��߰� ���� �����丵�� �κ��� ������ üũ�Ѵ�.
public class Calculator {
	public int add(String text) {
//		if(text == null || text.isEmpty())
		if(isBlank(text))
			return 0;
//		if(text.contains(",")) {
//			String[] values = text.split(",");
//			int sum = 0;
//			for(String value : values) {
//				sum += Integer.parseInt(value);
//			}
//			return sum;
//		}//�׽�Ʈ �߰��߰� ���� �����丵�� �κ��� ������ üũ�Ѵ�.
//		return Integer.parseInt(text);
		
		//refactoring
		//String[] values = text.split(",");//����ʵ��� �޼ҵ带 ȣ���ϴ� ���� �ƴ�
		
		
//		int sum = 0;
//		for(String value : values) 
//			sum += Integer.parseInt(value);
//		return sum;
		
		//String[] values = split(text);//Ŭ������ �޼ҵ带 ȣ���ϴ� ������� ����
		//return sum(split(text));
		return sum(toInt(split(text)));
	}

	private boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}

	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);//group(0)�� text��������.
			return m.group(2).split(customDelimeter);
		}
//		else {
//			return text.split(",|:");
//		}
		return text.split(",|:");
	}

//  ���ڿ��� int�� �����ϰ� ���������� �ϰ� �ִ�.(�ΰ��� �۾��� �ϰ� ����)  
//	private int sum(String[] values) {
//		int sum = 0;
//		for(String value : values) 
//			sum += Integer.parseInt(value);
//		return sum;
//	}
	
	private int[] toInt(String[] values) {
		int[] numbers = new int[values.length];
		for(int i=0; i < values.length; i++) {
//			int number = Integer.parseInt(values[i]);
//			if(number < 0)
//				throw new RuntimeException();
			numbers[i] += toPositive(values[i]);;
		}
		return numbers;
	}

	private int toPositive(String value) {
		int number = Integer.parseInt(value);
		if(number < 0)
			throw new RuntimeException();
		return number;
	}
		
	private int sum(int[] numbers) {
		int sum = 0;
		for(int number : numbers) 
			sum += number;
		return sum;
	}
}
