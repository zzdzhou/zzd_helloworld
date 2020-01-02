package jack.helloworld.redis.restcontroller;

import jack.helloworld.redis.model.Organization;
import jack.helloworld.redis.repository.OrganizationRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationRestController {

    @Autowired
    private OrganizationRedisRepository orgRedisRepo;

    @PutMapping
    public void saveOrg(@RequestBody Organization org) {
        orgRedisRepo.saveOrganization(org);
    }

}
