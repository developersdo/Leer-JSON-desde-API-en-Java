Leer-JSON-desde-API-en-Java
===========================

Leyendo un api con retorno Json y parseando con Java

**Librerías usadas:** 

json-lib (2.1-rev6)
- org.kohsuke.stapler

jersey-client (1.8)
- jersey-bundle

```java
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
```
