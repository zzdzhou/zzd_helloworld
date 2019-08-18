package jack.helloworld.springcloud.config.client.rest;

import jack.helloworld.springcloud.config.client.utils.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertiesRest {

    @Autowired
    private ApplicationProperties appProperties;

    @GetMapping("/get")
    public String getProperties(@RequestParam String key) {
        return appProperties.getExample();
    }
}
