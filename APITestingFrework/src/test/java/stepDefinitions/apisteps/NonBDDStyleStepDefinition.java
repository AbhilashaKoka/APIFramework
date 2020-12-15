package stepDefinitions.apisteps;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hamcrest.core.IsNot;
import Utility.APIConstant;
import Utility.RestAssuredExtension;
import Utility.RestAssuredExtensionv2;
import Utility.myComponent;
import cucumber.TestContext;
import io.appium.java_client.remote.NewAppiumSessionPayload;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import lombok.experimental.var;
import pojo.Address;
import pojo.Location;
import pojo.LoginBody;
import pojo.Posts;
import testData.APIConstant.ApiMethods;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class NonBDDStyleStepDefinition {
	
public static ResponseOptions<Response> response;
public static String token;


	public NonBDDStyleStepDefinition(TestContext testContext) {
		//super(testContext);
	}
	
	@Then("I should see the author name as {string} with json validation")
	public void i_should_see_the_author_name_as_with_json_validation(String string) {
	    try {
	    	
	         String resposeBody=response.getBody().asString();
	    	 assertThat(resposeBody, matchesJsonSchemaInClasspath("post.json"));
	    	
	    }catch(Exception ex) {
	    	ex.getMessage();
	    }
	}
	
	@Given("I perform GET operation with path parameter for address {string}")
	public void i_perform_GET_operation_with_path_parameter_for_address(String uri, DataTable table) {
	    try {
	    	List<List<String>> data=table.cells();
	    	Map<String , String> queryparams=new HashMap<>();
	    	queryparams.put("id", data.get(1).get(0));
	    	RestAssuredExtensionv2 restAssuredExtensionv2=new RestAssuredExtensionv2(uri, "GET", token);
	    	response=restAssuredExtensionv2.ExecuteWithQueryParams(queryparams);
	        //response=RestAssuredExtension.GetWithQueryParamsWithToken(url, queryparams,response.getBody().jsonPath().get("access_token"));
	    	System.out.println(response.getBody().print());
	    	//myComponent.getResource(url);
	    }
	    catch(Exception ex) {
	    	ex.getMessage();
	    }
	}

	@Then("I should see the street name as {string} for the {string} address")
	public void i_should_see_the_street_name_as_for_the_address(String streetName, String type) {
		try {
			    Location[] location= response.getBody().as(Location[].class);
			    System.out.println(response.getBody().print());
			    //Filter the address based on the type of addresses
			    Address address=location[0].getAddress().stream().filter(x ->x.getType().equalsIgnoreCase(type)).findFirst().orElse( null);
		        assertThat(address.getStreet(), equalTo(streetName));
		        System.out.println(response.getBody().print());
				}
			 catch(Exception ex) {
			    	ex.getMessage();
			    }
	}
	
	
	@Given("I perform GET operation for {string}")
	public void i_perform_GET_operation_for(String url) {
		 try {
			// response=RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
			 response=RestAssuredExtension.GetOpsWithToken(url, token);
			 System.out.println(response.getBody().print());
			// myComponent.getResource(url);
		     }
	   catch(Exception ex) 
			 {
		     System.out.println(ex.getStackTrace());   
			 System.out.println(ex.getMessage());
			 }
	}

	@Then("I should see the author name as {string}")
	public void i_should_see_the_author_name_as(String authorName) 
	{
		    try {
		    	//with builder pattern
		    	Posts posts=new Posts.Builder().build();
		    	Posts post=response.getBody().as(posts.getClass());
		    	assertThat(post.getAuthor(), equalTo(authorName));		    	
			    //without builder pattern
                // Posts posts=response.getBody().as(Posts.class);
                //System.out.println(response.getBody().print());
			   //assertThat(posts.getAuthor(), equalTo(authorName));
			   	 }
		   catch(Exception ex) 
		    {	   
			ex.getMessage();
		    }
	}

 @Then("I should verify the author names")
	public void i_should_verify_the_author_names() {
		 try {
			 System.out.println();	    
		      }
		   catch(Exception ex) 
		   {	   
			ex.getMessage();
		   }	    
	}

	@Then("I should  verify GET Parameter")
	public void i_should_verify_GET_Parameter() {
		 try {
			 System.out.println();	    
		      }
		   catch(Exception ex) 
		   {	   
			ex.getMessage();
		   }	    
	}

	@Then("I should  verify GET  path Parameter")
	public void i_should_verify_GET_path_Parameter() {
		 try {
			 System.out.println();	    
		     }
		   catch(Exception ex) 
		   {	   
			ex.getMessage();
		   }	    
	}

	@Then("I should  verify POST path parameter")
	public void i_should_verify_POST_path_parameter() {
		  try {
			  System.out.println();	    
		      }
		   catch(Exception ex) 
		   {	   
			ex.getMessage();
		   }	    
	}
	
	@Given("I Perform POST operation for {string} with body")
	public void i_Perform_POST_operation_for_with_body(String url, DataTable table) throws Throwable {
		 try {
			List<List<String>> data = table.cells();
	        HashMap<String, String> body = new HashMap<>();
	        body.put("name", data.get(1).get(0));
	        HashMap<String, String> pathParams = new HashMap<>();
	        pathParams.put("profileNo", data.get(1).get(1));
	        System.out.println(response.body().print());	    
	      }
	   catch(Exception ex) 
	   {	   
		ex.getMessage();
	   }	
	}

	@Then("I should see the body has name as {string}")
	public void i_should_see_the_body_has_name_as(String name) {
	    try {
	    	 assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
		    }
	   catch(Exception ex) 
	       {	   
		   ex.getMessage();
	       }	
     	}
	
	@Given("I ensure to Perform POST operation for {string} with body as")
	public void i_ensure_to_Perform_POST_operation_for_with_body_as(String url, DataTable table) {
		try {
			    List<List<String>> data = table.cells();
		        Map<String, String> body = new HashMap<>();
		        body.put("id", data.get(1).get(0));
		        body.put("title", data.get(1).get(1));
		        body.put("author", data.get(1).get(2));
		       	System.out.println(response.getBody().print());
	      }
	   catch(Exception ex) 
	   {	   
		ex.getMessage();
	   }	
	}

	@Given("I Perform DELETE operation for {string}")
	public void i_Perform_DELETE_operation_for(String url, DataTable table) {
		try {
		   	List<List<String>> data = table.cells();
	        Map<String, String> pathParams = new HashMap<>();
	        pathParams.put("postid", data.get(1).get(0));
            RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
	      }
	   catch(Exception ex) 
	   {	   
		ex.getMessage();
	   }	
	}

	@Given("I perform GET operation with path parameter for {string}")
	public void i_perform_GET_operation_with_path_parameter_for(String url, DataTable table) {
		try {
		   	List<List<String>> data = table.cells();
	        Map<String, String> pathParams = new HashMap<>();
	        pathParams.put("postid", data.get(1).get(0));
	        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
	       // myComponent.getResource(url);
            }
	   catch(Exception ex) 
	     {	   
		   ex.getMessage();
	     }	
	}

	@Then("I {string} see the body with title as {string}")
	public void i_see_the_body_with_title_as(String condition, String title) {
		try {
		   	if (condition.equalsIgnoreCase("should not"))
		         assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
	        else
	             assertThat(response.getBody().jsonPath().get("title"), is(title));
            }
	 	  //response.getEntity().consumeContent();
	   catch(Exception ex) 
	   {	   
		ex.getMessage();
	   }	
	}

	@Given("I Perform PUT operation for {string}")
	public void i_Perform_PUT_operation_for(String url, DataTable table) {
	   try {
		    List<List<String>> data = table.cells();
	        Map<String, String> body = new HashMap<>();
	        body.put("id", data.get(1).get(0));
	        body.put("title", data.get(1).get(1));
	        body.put("author", data.get(1).get(2));	        
	        Map<String, String> pathParams = new HashMap<>();
	        pathParams.put("postid", data.get(1).get(0));
	        RestAssuredExtension.PutOpsWithBodyAndPathParams(url, body, pathParams);
	       }
	   catch(Exception ex)
	   {
	    ex.getMessage();
	   }
	}

	@Given("I perform authentication operation for {string} with body")
	public void i_perform_authentication_operation_for_with_body(String url, DataTable table) {
		    List<List<String>> data = table.cells();
            //Map<String, String> body = new HashMap<>();
            //body.put("email", data.get(1).get(0));
            //body.put("password", data.get(1).get(1));  
		    LoginBody loginBody=new LoginBody();
		    loginBody.setEmail(data.get(1).get(0));
		    loginBody.setPassword(data.get(1).get(1));
	        RestAssuredExtensionv2 restAssuredExtensionv2=new RestAssuredExtensionv2(url,APIConstant.ApiMethods.POST, null);
	       //token= restAssuredExtensionv2.Authenticate(body);
	        token= restAssuredExtensionv2.Authenticate(loginBody);
	        System.out.println(token);
	        //response=RestAssuredExtension.PostOpsWithBody(url, body);
	       //myComponent.getResource(url);
	}
	
}
