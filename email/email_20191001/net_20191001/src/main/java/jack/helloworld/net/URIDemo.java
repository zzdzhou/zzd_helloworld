package jack.helloworld.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIDemo {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        URI uri = new URI("http://www.baidu.com/java/../openbsd/../index.jsp");
        System.out.println("Raw: " + uri);
        URI normalized = uri.normalize();
        System.out.println("Normalized: " + normalized);
        final URI BASE = new URI("http://www.baidu.com");
        System.out.println("Relative to " + BASE + ": " + BASE.relativize(uri));

        URL url = new URL(normalized.toString());
        System.out.println("URL: " + url);

        URI uri1 = new URI("bean:wonder");
        System.out.println(uri1);
    }
}
