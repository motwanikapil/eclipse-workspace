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
