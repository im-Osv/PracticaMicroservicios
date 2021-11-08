#Práctica Microservicios

La aplicación se ejecuta como un Java Application en PracticaMicroserviciosApplication.
1. Cree la aplicación en Spring Initializr con las dependencias en Web y DevTools.
2. Cree una clase para declarar un Java Bean referente al mensaje que se va a mostrar:

```
private String message;

public HelloWorldBean(String message) {
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public String toString() {
	return String.format("HelloWorldBean [message=%s]", message);
}
```
3. Cree la clase Controller para poder llamar al servicio Rest y desplegar los mensajes solicitados

```
@RestController
public class HelloWorldController {

	@GetMapping(path = "/api/sps/helloworld/v1/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello SPS, this is the message: %s", name));
	}
}

```

5. Cambie el puerto del servidor a 8090 en el archivo src/resources/application.properties
6. Al desplegar la aplicación será con la URL localhost:8090//api/sps/helloworld/v1/{name}
En el cual {name} va el mensaje que quieran enviar y se mostrará JSON de esta forma:

```json
{"message":"Hello SPS, this is the message: {name}"}
```

