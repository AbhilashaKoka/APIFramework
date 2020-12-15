package Utility;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

    public class myComponent 
    {
	public static PoolingClientConnectionManager connectionManager;
	public static HttpClient client;
	public static  HttpResponse  httpResponse;	
	public static int statusCode;
	public static InputStream inputStream = null;
	    
 

	//This method can be called concurrently by several threads
    public static InputStream getResource(String uri){
	        try {
	        	connectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createDefault());
	        	connectionManager.setMaxTotal(200);
	        	connectionManager.setDefaultMaxPerRoute(200);
		         client = new DefaultHttpClient(connectionManager);
		        HttpParams params = client.getParams();
		        HttpConnectionParams.setConnectionTimeout(params, 20000);
		        HttpConnectionParams.setSoTimeout(params, 15000);
	        	HttpGet method = new HttpGet(uri);
	            httpResponse=client.execute(method);
	           	statusCode = httpResponse.getStatusLine().getStatusCode();
	            if (HttpStatus.SC_OK == statusCode)
	            {
	               inputStream = httpResponse.getEntity().getContent();
	            } 
	            else 
	            { 
	               EntityUtils.consume(httpResponse.getEntity());
	            }
	            return inputStream;
	            }	        
	        catch (Exception e)
	        {   
	          throw new RuntimeException(e);
	        }
	    }
	}

