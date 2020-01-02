package jack.helloworld.mybatis.web.mappers;

import jack.helloworld.mybatis.web.models.Organization;

public interface OrganizationMapper {

    Organization selectOrganization(String organizationId);
}
