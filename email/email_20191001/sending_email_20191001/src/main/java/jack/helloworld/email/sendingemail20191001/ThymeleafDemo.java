package jack.helloworld.email.sendingemail20191001;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;

public class ThymeleafDemo {

    public static void main(String[] args) {
        // IContext : payload(all the data/variables required) and locale
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack!");
        Context context = new Context(Locale.SIMPLIFIED_CHINESE, map);

        // ITemplateResolver
        /*ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".txt");
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setForceTemplateMode(true);
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");*/

        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);

        // ITemplateEngine: assembles ITemplateResolver's, processes template with a template name, IContext,
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        String processed = templateEngine.process("hello world, hello [[${name}]]", context);
        System.out.println(processed);

        try (BufferedWriter out = new BufferedWriter(new FileWriter(
                System.getProperty("user.dir") + File.separator
                        + "sending_email_20191001/src/main/resources/output/text.txt"))) {
            out.write(processed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir") + File.separator + "resources/output/thymeleaf.html");
    }

}
