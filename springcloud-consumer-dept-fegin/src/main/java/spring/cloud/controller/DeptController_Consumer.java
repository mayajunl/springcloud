package spring.cloud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import spring.cloud.entity.Dept;
import spring.cloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	
	//private static final String prefix="http://localhost:7001";
	//private static final String prefix="http://MICROSERVICECLOUD-DEPT";
    @Autowired
	private DeptClientService dService;
	
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
    	return dService.get(id);
    }
    @RequestMapping(value="/consumer/dept/lsit")
    public List<Dept> list(){
    	return dService.list();
    }
    
    @RequestMapping(value="/consumer/dept/add")
    public Object add(Dept dept) {
    	return dService.add(dept);
    }

}
