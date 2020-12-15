package Utility;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import java.util.HashMap;
import org.hamcrest.core.Is;

import io.restassured.http.ContentType;

public class BDDStyleMethod {
	
	 public static void SimpleGETPost(String postNumber){
		   given().
	               contentType(ContentType.JSON).
	        when().
	               get(String.format("http://localhost:3000/posts/%s", postNumber)).
	       then().
	              body("author", is("Abhilasha"));
	    }

	    public static void PerformContainsCollection(){
	        given().
	                contentType(ContentType.JSON).
	        when().
	                get("http://localhost:3000/posts/").
	        then().
	                body("author", containsInAnyOrder("Abhilasha", "Amita", "Anirudha")).statusCode(200);
	    }

	    public static void PerformPathParameter() {

	        given().
	                contentType(ContentType.JSON).
	        with().
	                pathParams("post", 1).
	        when().
	                get("http://localhost:3000/posts/{post}").
	        then().
	                body("author", containsString("Abhilasha"));
	    }

	    public static void PerformQueryParameter(){
	        given().
	                contentType(ContentType.JSON).queryParam("id", 1).
	        when().
	                get("http://localhost:3000/posts/").
	        then().
	                body("author", hasItem("Karthik KK"));
	    }

	    public static void PerformPOSTWithBodyParameter() {
	        HashMap<String,String> postContent = new HashMap<>();
	        postContent.put("id", "5");
	        postContent.put("title", "Abhilasha");
	        postContent.put("author", "Abhilasha");

	        given().
	        contentType(ContentType.JSON).
	        with().
	                body(postContent).
	        when().
	                post("http://localhost:3000/posts").
	        then().
	                body("author", Is.is("Abhilasha"));
	    } 

}
