package annotaion;

public class Service {
	@PrintAnnotion
	public void method1() {
		System.out.println("method1 실행");
	}
	@PrintAnnotion("*")
	public void method2() {
		System.out.println("method2 실행");
	}
	@PrintAnnotion(value = "%", number = 10)
	public void method3() {
		System.out.println("method3 실행");
	}

}
