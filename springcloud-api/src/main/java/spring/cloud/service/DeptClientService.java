package spring.cloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.cloud.entity.Dept;

@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServicefallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list();
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(Dept dept);

}
