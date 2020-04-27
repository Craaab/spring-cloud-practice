package cnkj.cloud4.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFallbackHystrixService.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getOK(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String getTimeOut(@PathVariable("id") Long id);
}
