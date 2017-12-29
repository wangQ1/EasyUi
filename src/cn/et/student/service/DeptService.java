package cn.et.student.service;

import java.util.List;

import cn.et.student.entity.Emp;
import cn.et.student.entity.TreeNode;
import cn.et.student.utils.PageTools;

public interface DeptService {
	public abstract List<TreeNode> queryDept(Integer pid);
	
	public PageTools queryEmpByDept(Integer id, String empName, Integer page, Integer rows);
	
	public void deleteEmp(String empid);
	
	public void updateEmp(Emp emp);
	
	public void saveEmp(Emp emp);
}