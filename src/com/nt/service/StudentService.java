package com.nt.service;
import com.nt.bo.*;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;
public class StudentService {
	private StudentDAO dao;

	public StudentService () {
		dao=new StudentDAO();
	}

	public String calculateMarks(StudentDTO dto) throws Exception {
		int count=0;
		float tmarks=0.0f;
		float amarks=0.0f;
		String grade =null;
		StudentBO bo=null;
		//Business Logic
		tmarks=dto.getP1marks()+dto.getP2marks()+dto.getP3marks()+dto.getP4marks()+dto.getP5marks();
		amarks=tmarks/5.0f;

		if(amarks>90) 
			grade="A";
		else if(amarks>80)
			grade="B";
		else if(amarks>70)
			grade="C";
		else if(amarks>40)
			grade="D";
		else 
			grade="F";


		//create BO class Object
		bo=new StudentBO();
		bo.setName(dto.getName());
		bo.setCourse(dto.getCourse());
		bo.setTotal_marks(tmarks);
		bo.setAvg_marks(amarks);
		bo.setGrade(grade);

		count=dao.insert(bo);

		if(count==0)
			return "Registration failed";
		else 
			return "Registration Success";





	}




}
