package jack.helloworld.mybatis.springboot.rest;

import jack.helloworld.mybatis.springboot.mappers.LicenseMapper;
import jack.helloworld.mybatis.springboot.mappers.OrganizationMapper;
import jack.helloworld.mybatis.springboot.models.License;
import jack.helloworld.mybatis.springboot.models.Organization;
import jack.helloworld.mybatis.springboot.services.LicenseService;
import jack.helloworld.mybatis.springboot.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private LicenseService licenseService;

    @Autowired
    private OrganizationService organizationService;

    @Transactional
    @GetMapping("/update")
    public void updateLicenseAndOrganization(@RequestBody Map<String, Object> map) {
        Organization organization = (Organization) map.get("organization");
        License license = (License) map.get("license");

        if (license != null & organization != null) {
            licenseService.updateById(license.getLicenseId(), license.getLicenseAllocated());
        }

    }

}
