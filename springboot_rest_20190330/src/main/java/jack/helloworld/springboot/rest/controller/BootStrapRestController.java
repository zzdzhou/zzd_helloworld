package jack.helloworld.springboot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/rest/bootstrap")
public class BootStrapRestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        for (Iterator<String> it = strings.iterator(); it.hasNext();) {
            String next = it.next();
            if (next == "2") {
                it.remove();
            }
        }
        System.out.println(strings);

    }

}
