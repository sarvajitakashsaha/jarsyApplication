package snippet;

public class Snippet {
	server.port=8082
	spring.datasource.url=jdbc:mysql://localhost:3306/school
	spring.datasource.username=user
	spring.datasource.password=user
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	spring.jpa.show-sql=true
	spring.jpa.generate-ddl= true
	spring.jpa.hibernate.ddl-auto=update
	#for configuring actuator
	management.endpoints.web.exposure.include= *
}

