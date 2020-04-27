package cnkj.cloud4.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackHystrixService implements PaymentHystrixService {
    @Override
    public String getOK(Long id) {
        return "PaymentFallbackHystrixService ; -------------- getOK -----------";
    }


    @Override
    public String getTimeOut(Long id) {
        return "PaymentFallbackHystrixService ; -------------- getTimeOut -----------";
    }
}
