package jack.javaee.springmvcrest20181124.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-28
 */
//@Configuration
//@EnableWebMvc
public class WebMevConfig/* implements WebMvcConfigurer*/ {


   /* @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(marshallingHttpMessageConverter());
    }

    @Bean
    public MarshallingHttpMessageConverter marshallingHttpMessageConverter() {
        return new MarshallingHttpMessageConverter();
    }*/
}


