package cn.et.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Emp;
import cn.et.student.entity.Result;
import cn.et.student.entity.TreeNode;
import cn.et.student.service.DeptService;
import cn.et.student.utils.PageTools;
@Controller
public class DeptController {
	@Autowired
	DeptService ds;
	@ResponseBody
	@RequestMapping("/qd")
	//@RequestParam(required=false)����������Խ��500����������������Ҫ��?sname=xxxҲ��������
	public List<TreeNode> queryDept(Integer id){
		return ds.queryDept(id);
	}
	@ResponseBody
	@RequestMapping("/qe")
	public PageTools queryEmp(Integer id, String ename, Integer page,Integer rows){
		return ds.queryEmpByDept(id, ename, page, rows);
	}
	@ResponseBody
	@RequestMapping(value="/delEmp/{empid}",method=RequestMethod.DELETE)
	public Result deleteEmp(@PathVariable String empid){
		Result re = new Result();
		re.setCode(1);
		try {
			ds.deleteEmp(empid);
		} catch (Exception e) {
			re.setCode(0);
			re.setMessage("ɾ��ʧ��");
		}
		return re;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updEmp/{id}",method=RequestMethod.PUT)
	public Result updateEmp(@PathVariable Integer id,Emp emp){
		emp.setId(id);
		Result re = new Result();
		re.setCode(1);
		try {
			ds.updateEmp(emp);
		} catch (Exception e) {
			re.setCode(0);
			re.setMessage("�޸�ʧ��");
		}
		return re;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public Result saveSutdent(Emp emp){
		Result re = new Result();
		re.setCode(1);
		try {
			ds.saveEmp(emp);
		} catch (Exception e) {
			re.setCode(0);
			re.setMessage("����ʧ��");
		}
		return re;
	}
}
