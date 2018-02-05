# Api Rest con Spring
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

5.