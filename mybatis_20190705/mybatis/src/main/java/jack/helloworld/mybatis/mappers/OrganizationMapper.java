package jack.helloworld.mybatis.mappers;

import jack.helloworld.mybatis.models.Organization;

public interface OrganizationMapper {

    Organization selectOrganization(String organizationId);
}
