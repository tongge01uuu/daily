package daily.daily;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daily.account.common.domain.User;
import daily.account.service.UserService;

public class AccountTest
{

	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		applicationContext=new ClassPathXmlApplicationContext("spring-config.xml"); 
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
		UserService userService=(UserService)applicationContext.getBean("userService");
		User user=new User();
		user.setName("test-mybatis");
		user.setDescription("mybatis");
		user.setSex(0);
		userService.add(user);
//		fail("Not yet implemented");
	}

}
