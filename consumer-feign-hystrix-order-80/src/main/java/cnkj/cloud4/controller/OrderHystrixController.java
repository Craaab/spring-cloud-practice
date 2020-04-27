package cnkj.cloud4.controller;

import cnkj.cloud4.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallbackHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String getOK(@PathVariable("id") Long id) {
        return paymentFeignService.getOK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "getTimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
//    @HystrixCommand
    public String getTimeOUt(@PathVariable("id") Long id) {
        return paymentFeignService.getTimeOut(id);
    }

    public String getTimeOutHandler(@PathVariable("id") Long id) {
        return "Thread: " + Thread.currentThread().getName() + "getTimeOutHandler , id: " + id + "\t" + "/(ㄒoㄒ)/~~";
    }

    // global fallback

    public String defaultFallbackHandler() {
        return "Thread: " + Thread.currentThread().getName() + "defaultFallbackHandler " + "\t" + "O(∩_∩)O哈哈~ /(ㄒoㄒ)/~~";
    }


}
