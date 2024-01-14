# api-bb-developers :point_left:

BB Developers is a platform for creating and management of applications that use Banco do Brasil APIs.

Register account from https://www.bb.com.br/site/developers/ then contract the API (API to query Active Account, Generation of PIX Billing, Authorization of Automatic Debit, Batch Payments).

System requirements :computer:
-------------------

1. Java 8.0 or better, 
2. Maven 3.1 or better, 
3. Dependency spring-boot-starter-webflux reactive streams.

Running :electric_plug:
-------------------

1. Open terminal and navigate to your project
2. Execute  ``` ./mvnw clean install  ```
3. Finally  ``` ./mvnw spring-boot:run -DskipTests=true ```

Documentation :books:
-------------------

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html

https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux

https://apoio.developers.bb.com.br/referency/post/5f4f8342b71fb5001268c9ac

https://apoio.developers.bb.com.br/sandbox/spec/5fe1eb75aa41dd001200981a

Code :pencil:
-------------------------
```
WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_PIX_COBRANCA);
		
		Mono<Pix> object = client.put()
				.uri(builder -> builder.path("/cob/")
				.queryParam("gw-dev-app-key","gw_dev_app_key")
				.build())
				.header("Authorization" ,bearer)
				.header("Content-Type", "application/json")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.bodyValue(pix)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> {
	                 return Mono.error(new NotFoundException("Deu zica erro 404"));
	                 })
				.onStatus(HttpStatus::is5xxServerError, response -> {
	                 return Mono.error(new ErrorInternalException("Deu zica erro 500"));
	                 })
				.bodyToMono(Pix.class);

```
<img src="https://github.com/fredyefra/api-bb-developers-miscellaneous/blob/master/src/main/resources/img/image-pix.jpg" alt="My-cool-logo"/>
