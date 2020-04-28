package cnkj.cloud4.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController9002 {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Nacooooos -----echo----- " + string + ": " + serverPort;
    }

    @GetMapping(value = "/payment/nacos/get/{id}")
    public String getId(@PathVariable Long id) {
        return "Nacooooos -----echo----- " + id + ": " + serverPort;
    }

}
