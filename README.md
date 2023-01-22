# api-bb-developers :point_left:

Documentation of the APIs on the BB Developers Portal (API to query Active Account, Generation of PIX Billing, Authorization of Automatic Debit, Batch Payments).

System requirements :computer:
-------------------

All you need to build this project is Java 11.0 or better, Maven 3.1 or better, dependency spring-boot-starter-webflux(Reactive Streams Spring Boot).

Documentation :open_book:
-------------------

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html

https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux

https://developers.bb.com.br/home

https://apoio.developers.bb.com.br/sandbox/spec/5fe1eb75aa41dd001200981a

Code :thinking:
-------------------------
```
WebClient client = WebClient.create(br.com.bb.developers.util.endpoints.EndPoint.ENDPOINT_PIX_COBRANCA);
		
		Mono<Pix> object = client.put()
				.uri(builder -> builder.path("/cob/")
				.queryParam("gw-dev-app-key","chave-developer")
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
