package spring.cloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import spring.cloud.entity.Dept;
@Component
public class DeptClientServicefallbackFactory  implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {

			@Override
			public Dept get(long id) {
				// TODO Auto-generated method stub
				return  new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的记录").setDb_source("no this database in mysql");
			}

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}};
	}


}
