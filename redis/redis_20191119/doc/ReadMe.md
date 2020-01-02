Redis  
Spring boot


### Redis
- [x] 启动  
`redis-server`    
/usr/local/redis-5.0.5/src/redis-server

- [x] 命令行  
`redis-cli -h host -p port -a password`

- [x] 配置文件  
redis.conf  
port 6379

- [x] 最基本的命令  
`dbsize`

1. String value  
`GET key`  
return nil if not exist  
`SET key`  
override if exist 

2. Hash value

### Spring data redis
- [x] connection 

- [x] Inject RedisTemplate(byName instead of byType)
```java
@Autowired
private RedisTemplate redisTemplate;

@Autowired
private RedisTemplate<String, String> redisTemplate;

@Resource(name = "redisTemplate")
private HashOperations<String, String, Organization> hashOps;
```

- [x] provides operations views
1. ValueOperations<K, V>  

2. HashOperations<K, HK, HV>


- [ ] uses a Java-based serializer for most of its operations.  
This means that any object written or read by the template is serialized and deserialized through Java.
```java
redisTemplate.setKeySerializer(new StringRedisSerializer());
redisTemplate.setValueSerializer(new StringRedisSerializer());
redisTemplate.setHashKeySerializer(new StringRedisSerializer());
redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
```

### Spring boot redis

- [x] dependencies  
spring-boot-starter-data-redis

- [x] application.yml


- [ ] RedisTemplate
