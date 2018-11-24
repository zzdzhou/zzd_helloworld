package jack.ws.jaxrs.cxf.springboot.cxf_springboot_20180323.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
@Service
public class HelloWorld {

    @Path("/html")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<HTML>\n" +
                "<head>\n" +
                "\t<title>Hello World!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>jax-rs, hello world!</h1>\n" +
                "</body>\n" +
                "</HTML>";
    }
}
