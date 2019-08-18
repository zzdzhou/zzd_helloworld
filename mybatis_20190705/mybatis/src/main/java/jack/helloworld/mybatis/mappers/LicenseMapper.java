package jack.helloworld.mybatis.mappers;

import jack.helloworld.mybatis.models.License;

public interface LicenseMapper {

    License getLicenseById(String id);

    License selectLicenseWithOrganization(String id);
}
