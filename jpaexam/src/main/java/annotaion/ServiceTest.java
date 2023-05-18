package annotaion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceTest {

	public static void main(String[] args) {
		Method[] declaredMethods =	Service.class.getDeclaredMethods();
		
		Service service = new Service();
		
		for (Method method : declaredMethods) {
			
			if(method.isAnnotationPresent(PrintAnnotion.class)) {
				PrintAnnotion printAnnotion =	method.getAnnotation(PrintAnnotion.class);
				
				System.out.println("[" + method.getName() + "]");
				
				for(int i = 0; i < printAnnotion.number(); i++) {
					System.out.print(printAnnotion.value());
				}
				System.out.println();
			}
			
			try {
				method.invoke(service);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
