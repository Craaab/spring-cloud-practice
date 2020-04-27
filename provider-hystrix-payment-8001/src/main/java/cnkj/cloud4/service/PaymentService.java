package cnkj.cloud4.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问方法
     */
    public String paymentInfo_OK(Integer id) {
        return "Thread: " + Thread.currentThread().getName() + "paymentInfo_OK , id: " + id + "\t" + ".......";
    }

    /**
     * 异常
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int a = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "Thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOut , id: " + id + "\t" + ".....!!!!";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {

        return "Thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler , id: " + id + "\t" + "(⊙o⊙)!";
    }

    /**
     * 服务熔断
     * @return
     */
    @HystrixCommand(fallbackMethod = "circuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String circuitBreaker(@PathVariable("id") Long id){
        if (id < 0){
            throw new RuntimeException("id is minus!!!!!!----Σ( ° △ °!!");
        }
        String serialNum = IdUtil.simpleUUID();
        return "circuitBreaker 调用成功, 流水号: " + serialNum;

    }

    public String circuitBreaker_fallback(@PathVariable("id") Long id) {
        return "circuitBreaker_fallback 调用成功: Σ( ° △ °||||||!! id :" + id;
    }
}
