package jack.helloworld.mybatis.web.mappers;

import jack.helloworld.mybatis.web.models.License;

public interface LicenseMapper {

    License getLicenseById(String id);

    License selectLicenseWithOrganization(String id);
}
