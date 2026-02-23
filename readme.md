- 'var' keyword came from java 10 and it provides type inference.
- spring container - manages spring beans and their lifecycle ( ioc container )
- 2 types of ioc container

1. bean factory: basic spring container
2. application context: advanced spring container with enterprise specific features.
   - easy to use in web applications
   - easy i18n
   - easy integration with spring aop

- difference between pojo, java bean and spring bean
- pojo is generally every object
- javabean means like enterprise java beans ( ejb )
- javabean should have a no argument constructor, it should have getters and setters, it should be serializable
- anything managed by spring is known as spring beans
- spring uses ioc container ( bean factory or application context ) to manage these objects

- how can I list all beans managed by spring

1. active learning
2. regular review

- @Primary - a bean should be given preference when multiple candidates are qualified
- @Qualifer - a specific bean should be auto-wired
- @Autowired - it gives the preferred bean
- @Autowirted + @Qualifier - it gives the specific bean
- @Component : an instance of class will be managed by spring framework
- Dependency : eg. GameRunner needs GamingConsole impl
- ComponentScan: scans the dependencies in the package
- Dependency Injection : identify beans, their dependencies and wire them together
	- spring beans: an object managed by spring framework
	- ioc container: manages the lifecycle of beans and dependencies
		- types of ioc - 1. application context ( mostly used ) 2. bean factory (rarely used)
	- autowiring: process of wiring in dependencies for a spring bean
	
@Component vs @Bean
where? - can be used on any java class | typically used on methods in spring config classes
ease of use - very easy. just add an annotation | you write all the code
autowiring - yes - field, setter or constructor injection | yes - method call or method paramters
who creates beans - spring framework | you write bean creation code
recommended for - instatiating beans for your own application code: @component | 1. custom business logic 2. instiating beans for 3rd party libraries: @Bean

Lazy initialization vs Eager initialization
initialization time - when it is first used | at start up of applicatoin
default - not default | default
code snippet - @Lazy or @Lazy(value = true) | @Lazy(value = false ) or absence of @Lazy
what happens if there are errors in initializing - errors will result in runtime exceptions | errors will prevent application from starting up
usage - rarely used | very frequently used
memory consumption - less ( until bean is initialized ) | all beans are initialized at startup

Spring Bean Scopes
- singleton - one object instance per spring ioc container
- prototype - possible many object instances per spring ioc container
	- scopes available only for web-aware spring application context
		- request - one object instance per single http request
		- session - one object instance per user http session
		- application - one object instance per web application runtime
		- websocket - one object instance per websocket instance

Java Singleton ( Book named Gang of Four for design patterns ) vs Spring Singleton
- java singleton - one object instance per jvm
- spring singleton - one object instance per spring ioc container

Things in Jakarta EE
- jakarta server pages ( jsp )
- jakarta standard tag library ( jstl )
- jakarta enterprise beans ( ejb )
- jakarta restful web services ( jax-rs )
- jakarta bean validation
- jakarta contexts and dependency injection ( cdi )
- jakarta persistence ( jpa )

@Component - Generic annotation application for any class
Base - for all spring stereotype annotations
specializations of @component:
- @Service - indicates that an annotated class has business logic
- @Controller - indicates that an annotated class is a "Controller"
- @Repository - indicates that an annotated class is used to retrieve and manipulate data in a database
- @Named - @Component
- @Inject - @Autowired
- pom.xml - project object model
- when we run mvn package then it validate -> compile -> test -> package
- mvn clean would clean the target folder which contains the jar file
- mvn install would copy the local jar file to local maven repository
- mvn compile would compile the source code
- mvn help:effective-pom
- mvn package: validate -> compile -> test -> package
- mvn test: validate -> compile -> test
- mvn spring-boot:run
- mvn spring-boot:build-image

- main goal of spring-boot is create production-ready applications quickly

- thing which are helping to make spring boot project faster
	- spring initializer
	- spring boot starter projects
	- auto configuration
	- spring boot devtools

- types of logging
- trace, debug, info, warning, error, off
- to create jar file right click the project then run as maven build and in goals type clean install
- then locate this jar file from terminal and type java -jar jar_file_name.jar
- add this line management.endpoints.web.exposure.include=* in application.properties to expose all actuator endpoints.
- instead of * use health,metrics so more cpu and memory is not used
- spring helps is the core framework
- spring mvc is used for web related work
- spring boot is a wrapper to use spring and spring mvc easily and also it enables non functional requirements.
- for h2 database
	- spring.h2.console.enabled=true add this line to application.properties and go to localhost:8080/h2-console
	- spring.datasource.url=jdbc:h2:mem:testdb add this to application.properties so that on every restart of server h2 database url will not change.

- if you want to see the sql used by jpa then add this line
spring.jpa.show-sql=true

- jpa is the api and hibernate is one of the popular implementations of jpa.
- w3c definition of a web service
	- software system designed to support interoperable machine-to-machine interaction over a network

- all requests first come to DispatcherServlet ( also known as front controller pattern )
- objects response gets converted to json by ResponseBody and JacksonHttpMessageConverters ( comes due to AutoConfiguration )
- Auto configuration also does the error mapping ( ErrorMvcAutoConfiguration )
- Now all the jars are available because all the jars are added to the starter projects and many things are auto configured for eg. usage of tomcat server.
- status codes
	200 - success
	201 - created
	204 - no content
	401 - unauthorized
	400 - bad request
	404 - resouce not found
	500 - server error
	
localhost:8080/swagger-ui - for api documentation

