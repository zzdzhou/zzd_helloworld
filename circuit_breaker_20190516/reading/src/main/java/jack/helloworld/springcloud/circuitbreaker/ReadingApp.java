package jack.helloworld.springcloud.circuitbreaker;

import jack.helloworld.springcloud.circuitbreaker.clientinterceptors.ReadingListInterceptor;
import jack.helloworld.springcloud.circuitbreaker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class ReadingApp {

    @Autowired
    private BookService bookService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, ReadingListInterceptor readingListInterceptor) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setInterceptors(Collections.singletonList(readingListInterceptor));
        System.out.println("ReadingApp#restTemplate() restTemplate = " + restTemplate);
        return restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(ReadingApp.class, args);
    }

    @GetMapping("/to-read")
    public String readingList() {
        return bookService.readingList();
    }

    @GetMapping("/read-portal")
    public String readingListPortal() {
        return bookService.readingListPortal();
    }
}
