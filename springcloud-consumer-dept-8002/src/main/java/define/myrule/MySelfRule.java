package define.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class MySelfRule {
	
	@Bean
	public IRule definerule() {
		//return new RandomRule();
		return new MyownRule();
	}

}
