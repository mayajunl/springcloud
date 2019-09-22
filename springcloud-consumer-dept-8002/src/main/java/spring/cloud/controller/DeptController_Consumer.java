package spring.cloud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import spring.cloud.entity.Dept;

@RestController
public class DeptController_Consumer {
	
	//private static final String prefix="http://localhost:7001";
	private static final String prefix="http://MICROSERVICECLOUD-DEPT";
	@Autowired
	private RestTemplate resttemplate; 
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return resttemplate.postForObject(prefix+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/{id}")
	public Dept get(@PathVariable("id")Long id) {
		return resttemplate.getForObject(prefix+"/dept/get/"+id,Dept.class);
	}
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return resttemplate.getForObject(prefix+"/dept/list", List.class);
	}
	@RequestMapping(value="/consumer/dept/discovery",method=RequestMethod.GET)
	public Object discovery() {
		return resttemplate.getForObject(prefix+"/dept/discovery", Object.class);
	}

}
