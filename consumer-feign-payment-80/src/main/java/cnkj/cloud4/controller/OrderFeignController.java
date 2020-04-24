package cnkj.cloud4.controller;

import cnkj.cloud4.entities.CommonResult;
import cnkj.cloud4.entities.Payment;
import cnkj.cloud4.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPayment(id);

    }

}
