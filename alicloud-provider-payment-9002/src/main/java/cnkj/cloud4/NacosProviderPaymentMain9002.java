package cnkj.cloud4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPaymentMain9002.class, args);
    }
}
