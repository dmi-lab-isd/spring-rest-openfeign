# Spring RPC con RestTemplate o OpenFeign

- Build di entrambi i progetti (client, server): `./build-all.sh`
- Esecuzione di tutti i microservizi: `docker-compose up`
- Client: http://localhost:8080
	- APIs: http://localhost:8080/swagger-ui.html
- Server: http://localhost:8081
	- APIs: http://localhost:8081/swagger-ui.html

## Con RestTemplate
```java
@Bean
RestTemplate restTempalte() {
	return new RestTemplate();
}

// app.sum.server = http://localhost:8081
@Value("${app.sum.server}") 
String sumServer;

@Autowired
RestTemplate restTemplate;

private SumResult getRemoteSumResult(int acc, int v) {
	String endpoint = String.format("%s/server/sum/%d/%d", sumServer, acc, v);
	return restTemplate.getForObject(endpoint, SumResult.class);
}
```

## Con OpenFeign
```java
// in ClientController.java
@Autowired
SumServerClient serverClient;
...
SumResult sumResult = serverClient.getSumResult(acc,v);

// in SumServerClient.java
@FeignClient(value = "server", url = "${app.sum.server}")
public interface SumServerClient {
	@GetMapping("/server/sum/{a}/{b}")
	SumResult getSumResult(@PathVariable int a, @PathVariable int b);
}
```
