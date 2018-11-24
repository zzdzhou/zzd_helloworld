package jack.ws.jaxrs.cxf.springboot.cxf_springboot_20180323;

import jack.ws.jaxrs.cxf.springboot.cxf_springboot_20180323.service.HelloWorld;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CxfRestApplication {

	@Autowired
	private Bus bus;

	public static void main(String[] args) {
		SpringApplication.run(CxfRestApplication.class, args);
	}

	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean sfb = new JAXRSServerFactoryBean();
		sfb.setBus(bus);
		sfb.setAddress("/");
//		sfb.setServiceBeans(Arrays.asList(new HelloWorld()));
		sfb.setServiceBean(new HelloWorld());
//		sfb.setFeatures(Arrays.asList(new LoggingFeature()));
		return sfb.create();
	}

}
