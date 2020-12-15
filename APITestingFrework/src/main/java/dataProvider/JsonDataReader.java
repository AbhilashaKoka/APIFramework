package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;
import testData.LoginDetails;


	
public class JsonDataReader {
	private final String loginFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "LoginDetails.json";
	//private List<LoginDetails> logindetails;
	
	public JsonDataReader()
	{		
	//logindetails = getLoginDetailsData();
	}
	
	
	//This is a private method,
	//which has the logic implemented to read the Customer Json 
	//and save it to the class instance variable.
	//You should be creating more methods like this if you have more test data files like getPaymentOptions(), getProducts() etc.
	public List<LoginDetails> getLoginDetailsData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;	
		try {
			bufferReader = new BufferedReader(new FileReader(loginFilePath));
			LoginDetails[] login = gson.fromJson(bufferReader, LoginDetails[].class);
			return Arrays.asList(login);
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException("Json file not found at path : " + loginFilePath);
		}
		finally {
			try { 
				if(bufferReader != null) bufferReader.close();
				}
			catch (IOException ignore) {}
		}
	}	
	//This just filter the information and return the specific customer to the test. 
    //public final LoginDetails getloginByName(String userName){
    //return logindetails.stream().filter(x -> x.username.equalsIgnoreCase(userName)).findAny().get();
   //}
	
	
  //public final LoginDetails getLoginDetailsByName(String userName){
  //for(LoginDetails login : logindetails) {
  //if(login.username.equalsIgnoreCase(userName))				
  //return login;		
  //}
  //return null;	
  //
	}

