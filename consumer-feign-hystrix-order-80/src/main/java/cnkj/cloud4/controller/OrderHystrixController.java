package cnkj.cloud4.controller;

import cnkj.cloud4.entities.CommonResult;
import cnkj.cloud4.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String getOK(@PathVariable("id") Long id) {
        return paymentFeignService.getOK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String getTimeOUt(@PathVariable("id") Long id) {
        return paymentFeignService.getTimeOut(id);

    }

}
