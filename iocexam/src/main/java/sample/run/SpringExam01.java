package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {

	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성전!!");
//		ApplicationContext context = new ClassPathXmlApplicationContext("exam01.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		System.out.println("ApplicationContext 생성후!!");
		
		
		MyBean bean1 = (MyBean)	context.getBean("myBean");   //DL 
		
		bean1.setName("kang");
		
		System.out.println(bean1.getName());
		
		MyBean bean2 = context.getBean("myBean",MyBean.class);
		
//		MyBean bean3 = context.getBean(MyBean.class);
		
		bean2.setName("kim");
		
		System.out.println(bean2.getName());
		
		if(bean1 == bean2)
			System.out.println("같은 인스턴스 입니다^^");
		
		System.out.println(bean1);
		
		MyBean bean4 = context.getBean("myBean2",MyBean.class);
		
		System.out.println(bean4);
		
		
	}

}
