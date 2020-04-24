package cnkj.cloud4.controller;

import cnkj.cloud4.entities.CommonResult;
import cnkj.cloud4.entities.Payment;
import cnkj.cloud4.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int rslt = paymentService.create(payment);
        log.info("----------create　处理结果 ：" + rslt);
        if (rslt > 0)
        {
            return new CommonResult(200, "create success1 port: " + serverPort, rslt);
        }
        else{
            return new CommonResult(444, "create failed", null);
        }
    }


    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("----------getPaymentByid　处理结果 ：" + payment);
        if (payment != null)
        {
            return new CommonResult(200, "get success port: " + serverPort, payment);
        }
        else{
            return new CommonResult(444, "get failed. id: " + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("Service~~~~~~~~~~~~~" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("ServicebuyID~~~~~~~~~~~~~" + instance.getInstanceId() + "\t" + instance.getHost());
        }
        return this.discoveryClient;
    }
}
