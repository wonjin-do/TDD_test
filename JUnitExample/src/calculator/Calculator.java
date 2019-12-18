package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//프러덕션코드
//테스트 중간중간 뭔가 리팩토링할 부분이 없는지 체크한다.
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
//		}//테스트 중간중간 뭔가 리팩토링할 부분이 없는지 체크한다.
//		return Integer.parseInt(text);
		
		//refactoring
		//String[] values = text.split(",");//멤버필드의 메소드를 호출하는 것이 아닌
		
		
//		int sum = 0;
//		for(String value : values) 
//			sum += Integer.parseInt(value);
//		return sum;
		
		//String[] values = split(text);//클래스의 메소드를 호출하는 방식으로 변경
		//return sum(split(text));
		return sum(toInt(split(text)));
	}

	private boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}

	private String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);//group(0)은 text변수값임.
			return m.group(2).split(customDelimeter);
		}
//		else {
//			return text.split(",|:");
//		}
		return text.split(",|:");
	}

//  문자열을 int로 변경하고 덧셈연산을 하고 있다.(두가지 작업을 하고 있음)  
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
