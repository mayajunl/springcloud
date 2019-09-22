package spring.cloud.service;

import java.util.List;

import spring.cloud.entity.Dept;



public interface DeptService {
	public boolean add(Dept dept);
	public Dept get(Long id);
	public List<Dept> list();

}
