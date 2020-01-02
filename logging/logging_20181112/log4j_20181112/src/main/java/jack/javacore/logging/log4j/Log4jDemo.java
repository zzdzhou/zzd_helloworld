package jack.javacore.logging.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-12
 */
public class Log4jDemo {

    private static final Logger logger = LogManager.getLogger(Log4jDemo.class);

    public static void main(String[] args) {
        logger.info("Hello, world!");
    }

}
