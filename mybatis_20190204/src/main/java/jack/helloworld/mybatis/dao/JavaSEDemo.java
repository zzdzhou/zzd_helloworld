package jack.helloworld.mybatis.dao;

import java.io.IOException;

public class JavaSEDemo {

    public static void main(String[] args) throws IOException {
        ProductDao productDao = new ProductDao();
        EProduct product = productDao.getProductById(17);
        System.out.println(product.getSubtitle());
    }

}
