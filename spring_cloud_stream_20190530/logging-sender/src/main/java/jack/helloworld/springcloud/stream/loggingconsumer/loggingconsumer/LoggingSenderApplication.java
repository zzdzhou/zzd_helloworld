package jack.helloworld.springcloud.stream.loggingconsumer.loggingconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
public class LoggingSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingSenderApplication.class, args);
	}

/*	@StreamListener(InboundChannel.INBOUND)
	public void handle(Person person) {
		System.out.println("[x] Received: " + person);
	}*/

	public static class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

}
