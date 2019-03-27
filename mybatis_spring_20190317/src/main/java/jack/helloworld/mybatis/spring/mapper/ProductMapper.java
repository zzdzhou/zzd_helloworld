package jack.helloworld.mybatis.spring.mapper;

import jack.helloworld.mybatis.spring.pojos.EProduct;

public interface ProductMapper {

    EProduct selectOne(Integer id);
}


