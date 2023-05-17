package sample;

import lombok.Data;


@Data
public class MyBean {
	private String name;
	private int count;
	
	public MyBean() {
		System.out.println("MyBean 생성!!!");
	}
	
}
