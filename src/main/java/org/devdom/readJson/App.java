package org.devdom.readJson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Iterator;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONArray;

public class App 
{
    public static void main(String []args) {

        final String URL = "http://www.emplea.do/jobs.json";
        Client client = Client.create();
        WebResource resource = client.resource(URL);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        resource.type(MediaType.APPLICATION_JSON);
        
        if (response.getStatus() == 200) {
            Iterator list = JSONArray.fromObject(response.getEntity(String.class)).listIterator();
            while(list.hasNext())
                System.out.println("Item : "+ list.next());
        }else
            throw new RuntimeException("Error " + response.getStatus());
    }
}