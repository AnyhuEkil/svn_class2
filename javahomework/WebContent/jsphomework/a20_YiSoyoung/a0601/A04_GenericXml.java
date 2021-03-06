package springweb.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springweb.z01_dto.Mart;

public class A04_GenericXml {

	public static void main(String[] args) {
		String loc = "springweb/b01_di/diexp4.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(loc);
		Mart mart = ctx.getBean("mart", Mart.class);
		mart.selling();
	}
}
