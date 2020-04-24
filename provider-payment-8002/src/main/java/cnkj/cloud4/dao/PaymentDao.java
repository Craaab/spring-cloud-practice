package cnkj.cloud4.dao;

import cnkj.cloud4.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    //aaa
    public Payment getPaymentById(@Param("id") Long id);
}
