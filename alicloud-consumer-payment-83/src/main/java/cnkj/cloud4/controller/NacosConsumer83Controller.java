package cnkj.cloud4.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosConsumer83Controller {
    @Value("${server.port}")
    private  String serverPort;

    @Value("${service-url.nacos-user-service}")
    private  String serverURL;

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getServerPort(@PathVariable Long id) {
        return restTemplate.getForObject(serverURL + "/payment/nacos/get/" + id, String.class);
    }

    public String getServerURL() {
        return serverURL;
    }
}
