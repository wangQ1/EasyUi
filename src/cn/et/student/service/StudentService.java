package cn.et.student.service;

import cn.et.student.entity.Student;
import cn.et.student.utils.PageTools;

public interface StudentService {
	public PageTools queryStudent(String sname,Integer page,Integer rows);
	public void deleteStudent(String sid);
	public void updateStudent(Student stu);
	public void saveStudent(Student student);
}