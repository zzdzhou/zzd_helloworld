## 错误日志
Artifact jpa_20190224:war exploded: java.lang.Exception: {"WFLYCTL0080: 失败的服务" => {"jboss.deployment.unit.\"jpa_20190224-1.0-SNAPSHOT.war\".undertow-deployment" 
=> "java.lang.RuntimeException: org.springframework.beans.factory.UnsatisfiedDependencyException: 
Error creating bean with name 'bootstrapServlet': Unsatisfied dependency expressed through field 'userDao'; 
nested exception is org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'userDao' defined in VFS resource [\"/C:/Users/zzd16/Desktop/zzd_helloworld/jpa_20190224/target/jpa_20190224-1.0-SNAPSHOT/WEB-INF/classes/jack/helloworld/jpa/dao/UserDao.class\"]: 
Post-processing of merged bean definition failed; 
nested exception is java.lang.IllegalStateException: Persistence annotations are not supported on `static fields`

## 错误代码
@Repository
public class UserDao {

    @PersistenceContext
    private static EntityManager em;
    
## 解决
private static EntityManager em;  去掉 static