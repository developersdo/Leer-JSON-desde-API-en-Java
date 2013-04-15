Leer-JSON-desde-API-en-Java
===========================

Leyendo un api con retorno Json y parseando con Java

**Librerías usadas:** 

jettison (1.1)
- org.codehaus.jettison

stapler (1.155)
- org.kohsuke.stapler

jersey-client (1.13)
- com.sun.jersey

```java
public static void main(String []args) {
  Client client = Client.create();
	WebResource resource = client.resource("http://www.emplea.do/jobs.json");
	ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
	resource.type(MediaType.APPLICATION_JSON);
	if (response.getStatus() == 200) {
		Iterator list = JSONArray.fromObject(response.getEntity(String.class)).listIterator();
		while(list.hasNext())
			System.out.println("Item : "+ list.next());
	}else{
		throw new RuntimeException("Error " + response.getStatus());
	}
}
```
