package jack.helloworld.redis.repository;


import jack.helloworld.redis.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrganizationRedisRepositoryImpl implements OrganizationRedisRepository {

    private final String HASH_KEY = "organization";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private Jackson2HashMapper hashMapper;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Organization> hashOps;

    /*@PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }*/

    @Override
    public void saveOrganization(Organization org) {
        hashOps.put(HASH_KEY, org.getOrganizationId(), org);
    }

    @Override
    public void updateOrganization(Organization org) {
        hashOps.put(HASH_KEY, org.getOrganizationId(), org);
    }

    @Override
    public void deleteOrganization(String orgId) {
        hashOps.delete(HASH_KEY, orgId);
    }

    @Override
    public Organization findOrganization(String orgId) {
        return hashOps.get(HASH_KEY, orgId);
    }

}
