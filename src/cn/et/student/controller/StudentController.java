package cn.et.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Result;
import cn.et.student.entity.Student;
import cn.et.student.service.StudentService;
import cn.et.student.utils.PageTools;

@Controller
public class StudentController {
	@Autowired
	StudentService ss;
	@ResponseBody
	@RequestMapping("/qs")
	//@RequestParam(required=false)����������Խ��500����������������Ҫ��?sname=xxxҲ��������
	public PageTools queryStudent(String sname, Integer page, Integer rows){
		return ss.queryStudent(sname, page, rows);
	}
	
	@ResponseBody
	@RequestMapping(value="/delStu/{sid}",method=RequestMethod.DELETE)
	public Result deleteSutdent(@PathVariable String sid){
		Result re = new Result();
		re.setCode(1);
		try {
			ss.deleteStudent(sid);
		} catch (Exception e) {
			re.setCode(0);
			re.setMessage("ɾ��ʧ��");
		}
		return re;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updStu/{sid}",method=RequestMethod.PUT)
	public Result updateSutdent(@PathVariable Integer sid,Student stu){
		stu.setSid(sid);
		Result re = new Result();
		re.setCode(1);
		try {
			ss.updateStudent(stu);
		} catch (Exception e) {
			re.setCode(0);
			re.setMessage("�޸�ʧ��");
		}
		return re;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/saveStu",method=RequestMethod.POST)
	public Result saveSutdent(Student stu){
		Result re = new Result();
		re.setCode(1);
		try {
			ss.saveStudent(stu);
		} catch (Exception e) {
			re.setCode(0);
			re.setMessage("����ʧ��");
		}
		return re;
	}
	/*@ResponseBody ������һ���ļ��ϴ�����
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Result saveStudent(Student student,MultipartFile myImage){
		Result r=new Result();
		r.setCode(1);
		try {
			String fileName=myImage.getOriginalFilename();
			File destFile=new File("E:\\myImage\\"+fileName);
			myImage.transferTo(destFile);
			//���ú�̨save
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		
		return r;
	}*/
}
