package jack.helloworld.redis.repository;

import jack.helloworld.redis.model.Organization;
import org.springframework.stereotype.Repository;

public interface OrganizationRedisRepository {

    void saveOrganization(Organization org);

    void updateOrganization(Organization org);

    void deleteOrganization(String orgId);

    Organization findOrganization(String orgId);
}
