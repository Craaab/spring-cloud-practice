package cnkj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
