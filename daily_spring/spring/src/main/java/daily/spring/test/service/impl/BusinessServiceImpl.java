package daily.spring.test.service.impl;


import daily.spring.test.service.BusinessService;

public class BusinessServiceImpl implements BusinessService
{
	Integer businessNum;
	public void run()
	{
		System.out.println("run business service"+businessNum);
	}
	public void setBusinessNum(Integer businessNum)
	{
		this.businessNum = businessNum;
	}

}
