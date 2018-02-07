# Api Rest con Spring
## Comandos Utiles
### Matar proceso del servidor
1. Desplegar un proceso dado un puerto

	lsof -i:8080
	
2. Matar al proceso con el comando kill

	kill PID
## Requisitos
1. Tener Instalado los repositorios de maven
2. Intsalar Spring Tools

## Creacion de un proyecto
1. File > New > Spring Starter Project > Next
2. Ingresa el nombre del proyecto y demas campos > Next
3. Seleccionar la version de Spring Boot Y Seleccionar las dependencias JPA, y Web > Next > Finish.
4. En el pom.xml anadir las dependencias
```` xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.45</version>
</dependency>
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.8.10</version>
</dependency>
<dependency>
	<groupId>javax.xml.bind</groupId>
	<artifactId>jaxb-api</artifactId>
	<version>2.3.0</version>
</dependency>
````
5. Configurar archivo application.properties del proyecto
```` 
server.port=8090
#pagina de error 404
server.error.whitelabel.enabled= false
spring.datasource.url= jdbc:mysql://localhost:3306/notas
spring.datasource.username= root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto= update
spring.jpa.hibernate.naming.strategy= org.hibernate.cfg.DefaultComponentSafeNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialecst

````

5. Integrar Swagger a Proyecto

1. Instalar las dependencias
````
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.7.0</version>
</dependency>

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.7.0</version>
</dependency>
````
2. Crear un clase ApplicationConfig y remplazar el base package asi como la informacion general del API.

```` java
@Configuration
@EnableSwagger2

public class ApplicationConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.empresa.springrest.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Paul Cuichan", "http://nodisponible.com", "ing.paul.cuixan@gmail.com");
        return new ApiInfoBuilder()
                .title("Example Api Title")
                .description("Example Api Definition")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}
````
3. En el archivo application.properties especificar el app root de la aplicacion:

`server.contextPath= /app-root`

4. Abrir la url 

`http://localhost:8090/app-root/swagger-ui.html`

5. Usar las siguientes anotacion

**Anotaciones de Controller**

* @Api: se usa para explicar cada clase de controlador.
* @ApiOperation: se usa para explicar los recursos y métodos.
* @ApiResponse: Se usa para explicar respuestas de la operación

**Anotaciones de Modelo**
 Anotación @ApiModelProperty para describir las propiedades de la clase POJO (Bean).
