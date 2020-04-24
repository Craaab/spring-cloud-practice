package cnkj.cloud4.service.impl;

import cnkj.cloud4.dao.PaymentDao;
import cnkj.cloud4.entities.Payment;
import cnkj.cloud4.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById (@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
