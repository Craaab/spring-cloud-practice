package cnkj.cloud4.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问方法
     */
    public String paymentInfo_OK(Integer id) {
        return "Thread" + Thread.currentThread().getName() + "paymentInfo_OK , id: " + id + "\t" + ".......";
    }

    /**
     * 异常
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Thread" + Thread.currentThread().getName() + "paymentInfo_TimeOut , id: " + id + "\t" + ".....!!!!";
    }
}
// abcdefgshishishishissshshisshssssshishijijishishihimiwenroohis his