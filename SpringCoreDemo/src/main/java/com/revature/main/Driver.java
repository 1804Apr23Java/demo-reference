package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;

public class Driver {

	public static void main(String[] args) {
		
		//allow us to access IoC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		funWithBears(ac);
		
		//close AC after you're done
		((AbstractApplicationContext) ac).close();
	}

	public static void funWithBears(ApplicationContext ac) {
		
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		
		Bear b2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b2.methodInBear();
		
		Bear b3 = (BearWithAutoByName) ac.getBean("autoBearByName");
		b3.methodInBear();
		
		Bear b4 = (BearWithAutoByType) ac.getBean("autoBearByType");
		b4.methodInBear();
		
		Bear b5 = (AutowiredBear) ac.getBean("autowiredBear");
		b5.methodInBear();
		
		
	}
}
