package stepDefinitions.apisteps;

import Utility.RestAssuredExtension;
import io.cucumber.java.Before;

public class APIUtils 
{
	
	@Before
	public void testSetUp() 
	{
	RestAssuredExtension restAssuredExtension=new RestAssuredExtension();
	}

}
