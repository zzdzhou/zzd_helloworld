package jack.helloworld.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("测试连接: " + jedis.ping());
        jedis.set("name", "jack");
        jedis.set("redis client", "Java Jedis");
        System.out.println("name: " + jedis.get("name"));
        System.out.println("redis client: " + jedis.get("redis client"));

    }
}
