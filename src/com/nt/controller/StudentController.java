package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

@WebServlet("/stdpcs")
public class StudentController extends HttpServlet {


	private StudentService service;

	@Override
	public void init() throws ServletException {
		service=new StudentService();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StudentVO vo=null;
		StudentDTO dto=null;
		PrintWriter pw=null;
		String name=null;
		String course=null;
		String result=null;
		//General Setting

		pw=res.getWriter();
		res.setContentType("text/html");


		//read form data and store into VO object
		vo=new StudentVO();
		   vo.setName(req.getParameter("name"));
		 vo.setCourse(req.getParameter("course"));
		vo.setP1marks(req.getParameter("mk1"));
		vo.setP2marks(req.getParameter("mk2"));
		vo.setP3marks(req.getParameter("mk3"));
		vo.setP4marks(req.getParameter("mk4"));
		vo.setP5marks(req.getParameter("mk5"));
		


		//convert VO CLass Object Into DTO
		dto=new StudentDTO();
		dto.setName(vo.getName());
		dto.setCourse(vo.getCourse());
		dto.setP1marks(Float.parseFloat(vo.getP1marks()));
		dto.setP2marks(Float.parseFloat(vo.getP2marks()));
		dto.setP3marks(Float.parseFloat(vo.getP3marks()));
		dto.setP4marks(Float.parseFloat(vo.getP4marks()));
		dto.setP5marks(Float.parseFloat(vo.getP5marks()));

		// USe Service Class 
		try {
			result=service.calculateMarks(dto);
			pw.println("<h1 style='color:red,text-align=centre'>Result::"+result+"</h1>");

		}//try
		catch(Exception e) {
			pw.println("Internal Problem Try-again");
			e.printStackTrace();
		}// catch 


		//add hyperlink
		pw.print("<br><br <a href='input.html'>HOME</a>");
		pw.close();



	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
