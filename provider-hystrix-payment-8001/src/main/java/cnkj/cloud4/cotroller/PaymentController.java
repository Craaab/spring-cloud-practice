package cnkj.cloud4.cotroller;

import cnkj.cloud4.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id){
        String rslt = paymentService.paymentInfo_OK(id);
        log.info("～～～～～～～～～～～～～Relst:" + rslt);
        return rslt;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_Timeout(@PathVariable("id") Integer id){
        String rslt = paymentService.paymentInfo_TimeOut(id);
        log.info("～～～～～～～～～～～～～Relst:" + rslt);
        return rslt;
    }


    @GetMapping("/payment/hystrix/lb/{id}")
    public String PaymentInfo_lb(@PathVariable("id") Integer id){
        String rslt = serverPort;
        log.info("～～～～～～～～～～～～～Relst:" + rslt);
        return rslt;
    }


    /**
     * 服务熔断
     * @return
     */
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Long id){
        String rslt = paymentService.circuitBreaker(id);
        log.info("～～～～～～～～～～～～～circuitBreaker:" + rslt);
        return rslt;

    }
}

