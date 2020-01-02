package jack.helloworld.mybatis.springboot.mappers;

import jack.helloworld.mybatis.springboot.models.Organization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper {

    Organization selectOrganization(String organizationId);
}
