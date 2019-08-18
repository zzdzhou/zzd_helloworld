package jack.helloworld.mybatis.springboot.mappers;

import jack.helloworld.mybatis.springboot.models.License;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LicenseMapper {

    void updateLicenseAllocatedById(@Param("id") String id, @Param("licenseAllocated") Integer licenseAllocated);

}
