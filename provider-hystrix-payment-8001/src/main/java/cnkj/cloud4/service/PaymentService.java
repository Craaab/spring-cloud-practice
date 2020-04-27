package cnkj.cloud4.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

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
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler")
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOut , id: " + id + "\t" + ".....!!!!";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {

        return "Thread: " + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler , id: " + id + "\t" + "(⊙o⊙)!";
    }
}
// abcdefgshishishishissshshisshssssshishijijishishihimiwenroohis his