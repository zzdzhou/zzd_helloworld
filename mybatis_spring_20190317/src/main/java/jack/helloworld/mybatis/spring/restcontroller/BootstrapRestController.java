package jack.helloworld.mybatis.spring.restcontroller;

import jack.helloworld.mybatis.spring.mapper.ProductMapper;
import jack.helloworld.mybatis.spring.pojos.EProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis-spring")
public class BootstrapRestController {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/hello")
    @Transactional(timeout = 1)
    public EProduct hello(@RequestParam(name = "productId") Integer productId) throws InterruptedException {
        EProduct eProduct = productMapper.selectOne(productId);
        Thread.sleep(2000);
        return eProduct;
    }

}
