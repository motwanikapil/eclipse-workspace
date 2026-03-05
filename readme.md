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

- hypermedia as the engine of application state ( hateoas )
	- telling user what other links they can access
	- HAL ( JSON hypertext application language) - simple format that gives a consistent and easy way to hyperlink between resources in your api.
	- spring hateoas - generate hal responses with hyperlinks to resources
	
- filtering
	- static filtering: same filtering for a bean across different REST api
	- for json it can be done using JsonIgnore and JsonIgnoreProperties("field1") ( class level )

- spring boot actuator: monitor and manage your application in your production
- spring boot starter actuator: starter to add spring boot actuator to your application.
- it provides no of endpoints
- /health for health, /metrics for metrics, /beans for list of beans and /mappings for request mappings
- docker command to run mysql container
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=social-media-user --env MYSQL_PASSWORD=dummypassword --env MYSQL_DATABASE
=social-media-database --name mysql --publish 3306:3306 mysql:8-oracle

### Spring Security
- the following are the filter chains the request go through
1. all requests should be authenticated
2. if a request is not authenticated, a web page is shown
3. CSRF -> it affects POST , PUT

the above is the default filter chain, if we want to modify filter chain then we need to make the chain again
- we will make configuration and we make a bean in that and we make a filterchain in the bean

- what is aspect of programming
- spring aop - not a complete aop solution but very popular
- only works with spring beans
- intercept method calls to spring beans
- AspectJ - complete aop solution
- it gives lot of flexibility

- compile time
	- advice - what code to execute ( what )
		eg. logging, authenticatoin
	- pointcut - expression that identifies method calls to be intercepted ( when )
		eg. execution(com.in28minutes.aop.data.*.*(..)) ( execution pointcut )
	- what + when = aspect
	- weaver is the framework that implements aop
	- join point - when pointcut condition is true, the advice is executed. A specific execution instance of an advice is called a join point.
	- @After - so something after a method is executed irrespective of whether:
		1. method executes successfully
		2. method throws an exception
	- @AfterReturning - do something only when a method returns successfully
	- @AfterThrowing - Do something only when a method throws an exception
	- @Around - do something around a method execution

### Gradle
- plugins
 - gradle core is small and all the other things are plugins
 - java plugin: adds tasks: compileJava, test, jar ( defines default layout )
 - spring boot plugin: adds bootRun, bootJar, bootBuildImage and imports spring boot dependencies
 - dependency management plugin: maven-like dependency management
 - task graph: gradle calculates the most efficient order to run tasks
 - custom tasks: define custom tasks 

 ```
     docker container run -d -p 5000:5000 in28min/hello-world-nodejs:0.0.1.RELEASE
    docker container run -d -p 5000:5000 in28min/hello-world-java:0.0.1.RELEASE
    docker container run -d -p 5000:5000 in28min/hello-world-python:0.0.1.RELEASE
    docker container ls 
    docker image ls
    docker container stop cc
    docker container run -d -p 5001:5000 in28min/hello-world-nodejs:0.0.1.RELEASE
    docker container run -d -p 5002:5000 in28min/hello-world-nodejs:0.0.1.RELEASE
    docker container run -p 5003:5000 in28min/hello-world-nodejs:0.0.1.RELEASE
    docker container run -p 5003:5000 in28min/hello-world-nodejs:0.0.1.RELEASE
     
    docker --version
    docker container ls
    docker build -t in28min/hello-world-docker:v1 .
    docker image list
    docker run -d -p 5000:5000 in28min/hello-world-docker:v1
    docker build -t in28min/hello-world-docker:v2 .
    docker container run -d -p 5000:5000 in28min/hello-world-docker:v2
    docker build -t in28min/hello-world-docker:v3 .
    docker container run -d -p 5000:5000 in28min/hello-world-docker:v3
    docker build -t in28min/hello-world-docker:v4 .
```

