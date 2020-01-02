package jack.helloworld.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class ProductDao {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            String resources = "mybatis-config.xml";
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resources));
        }
        return sqlSessionFactory;
    }

    public EProduct getProductById(Integer productId) throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        EProduct eProduct;
        try {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            eProduct = productMapper.selectOne(productId);
        } finally {
            sqlSession.close();
        }
        return eProduct;
    }

}
