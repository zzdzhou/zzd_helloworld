package jack.helloworld.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bootstrap")
public class BootstrapRESTController {

    @Value("${test.jack}")
    private String test;

//    @Value("${spring.config.location}")
    private String spring_config_location;

//    @Value("${spring.config.name}")
    private String spring_config_name;

    @Value("${spring.profiles.active}")
    private String spring_profiles_active;

    @GetMapping
    public Map<String, String> getConfiguredProperty() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test.jack", test);
        map.put("spring.config.location", spring_config_location);
        map.put("spring.config.name", spring_config_name);
        map.put("spring.profiles.active", spring_profiles_active);
        return map;
    }

}
