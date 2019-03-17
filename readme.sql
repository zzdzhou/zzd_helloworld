-- jdbc_20190208 
(
	ok / jdbc(DataSource) + JNDI + mysql + Jboss EAP 7.2 + Servlet / jdbc(establish connection by DriverManager)
)

-- jpa_applicationmanaged_entitymanager_20190217 
(
	ok / mysql + jpa(application-managed EntityManager)(Hibernate)

)

-- mvcjpa_20140415  / 20180415
(
	ok / Spring mvc + spring framework data access - JPA(hibernate) + thymeleaf
	## LocalContainerEntityManagerFactoryBean
	## org.apache.commons.dbcp2.BasicDataSource
	
	
	/src/main/resources/META-INF/persistence.xml
)

-- mybatis_20190204
(
	ok /mybatis + Java SE 

)
	
-- servlet_jta_20190223
(
	ok / Servlet + JTA + Jboss EAP 7.2
	JTA_20190222.vsdx /51.7 Transactions in Web Components
	
	## EAP-7.0-Configuration_Guide-en-US.pdf / CHAPTER 14. CONFIGURING TRANSACTIONS
	XA datasources are already JTA capable by default
	
	## JNDI 获取 UserTransaction
	InitialContext ctx = new InitialContext();
	userTx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
	
	## @Resource 注入
	Resource injection enables you to inject any resource available in the JNDI namespace
	into any container-managed object, such as a servlet, an enterprise bean, or a managed
	bean. 
	
	@Resource
	private UserTransaction userTx;
	
	## EAP-7.0-Developing_EJB_Applications-en-US.pdf
	11.7. TRANSACTIONS USAGE IN PRACTICE
	
	?? How to use @Resource
)
	
-- spring_orm_jpa_20190220
(
	ok
	servlet + jpa + mysql + Spring(Spring framework data access /ORM-JAP)
	
	## LocalContainerEntityManagerFactoryBean
		links to an existing JDBC DataSource instead of DataSource JNDI lookup
		keeping the JDBC configuration in {@code persistence.xml}

)

-- spring_orm_jpa_20190224
(
	ok
	servlet + jpa + mysql + Spring(Spring framework data access /ORM-JPA /Obtaining an EntityManagerFactory from JNDI)
	
	## Obtaining an EntityManagerFactory from JNDI 
	## Jboss EAP binds EntityManagerFactory with JNDI name
	
	## IoC /Java-based container configuration /@ImportResource("classpath:spring_beans.xml") 
	## how to use Spring IoC in Servlet, use @Autowired in Servelt class
	## web applicaton launch procedures /Servlet EventListener /AnnotationConfigWebApplicationContext /web.xml
	## Spring DAOs with @PersistenceUnit and @PersistenceContext 
	
	## JPA Criteria API
	
	## Spring transaction
	/JtaTransactionManager / use JTA in a Java EE container, then you use a container DataSource, obtained through JNDI
	/declarative transaction /@EnableTransactionManagement /@Transactional(readOnly = true, timeout = 60)

)