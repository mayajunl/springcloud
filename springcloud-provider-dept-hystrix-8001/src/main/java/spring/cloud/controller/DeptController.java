package spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import spring.cloud.entity.Dept;
import spring.cloud.service.DeptService;


@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptservice=null;
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept=this.deptservice.get(id);
		if(null==dept) {
			throw new RuntimeException("该ID:"+id+"没有对应的记录");
		}
		return dept;
	}
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的记录").setDb_source("no this database in mysql");
	}


}
