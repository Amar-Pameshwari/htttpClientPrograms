package httpclient_MainExecution;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;

import com.fasterxml.jackson.annotation.JsonProperty;

public class httpClient_PostMethod 
{
	@JsonProperty ("Agora-Subscription-Key")
	public static String key = "48dfe6a704414f4c9f61b37a6b983fd7";

	public CloseableHttpResponse postCall(String Url) throws IOException , JSONException,ClientProtocolException, URISyntaxException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post_method = new HttpPost(); 
		URI uri = new URIBuilder(post_method.getURI()).addParameter("Agora-Subscription-Key", key).build();
		post_method.setURI(uri);
		CloseableHttpResponse response  = httpClient.execute(post_method);
		return response;
	}
}
