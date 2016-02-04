package daily.spring;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daily.spring.test.service.BusinessService;

public class BusinessTest
{
	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		applicationContext=new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		BusinessService businessService=(BusinessService) applicationContext.getBean("businessService");
		businessService.run();
//		fail("Not yet implemented");
	}

}
