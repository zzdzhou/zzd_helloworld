package jack.helloworld.mybatis.springboot.services;

import jack.helloworld.mybatis.springboot.mappers.LicenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

    @Autowired
    private LicenseMapper licenseMapper;

    public void updateById(String id, Integer licenseAllocated) {
        licenseMapper.updateLicenseAllocatedById(id, licenseAllocated);
    }
}
