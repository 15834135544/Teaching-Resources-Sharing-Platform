package com.zd.christopher.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.christopher.bean.Student;
import com.zd.christopher.dao.IStudentDAO;
@Service
public class StudentTransaction extends BaseTransaction<Student> implements IStudentTransaction
{
	@Resource
	private IStudentDAO studentDAO;
	
	@PostConstruct
	public void init()
	{
		entityClass = Student.class;
	}

	public Student findByNaturalId(Student entity)
	{
		return studentDAO.findByNaturalId(entity.getStudentId());
	}

	public List<Student> findByNaturalIds(Student[] entities)
	{
		List<String> idList = new ArrayList<String>();
		for(Student student : entities)
			idList.add(student.getStudentId());
		return studentDAO.findByNaturalIds((String[]) idList.toArray());
	}

	public List<Student> findByNaturalIdsByPage(Student[] entities, Integer count, Integer page)
	{
		List<String> idList = new ArrayList<String>();
		for(Student student : entities)
			idList.add(student.getStudentId());
		return studentDAO.findByNaturalIdsByPage((String[]) idList.toArray(), count, page);
	}

	public List<Student> findByNaturalName(Student entity)
	{
		return studentDAO.findByNaturalName(entity.getStudentName());
	}

	public List<Student> findByNaturalNameByPage(Student entity, Integer count, Integer page)
	{	
		return studentDAO.findByNaturalNameByPage(entity.getStudentName(), count, page);
	}

	public List<Student> findByNaturalNames(Student[] entities)
	{
		List<String> nameList = new ArrayList<String>();
		for(Student student : entities)
			nameList.add(student.getStudentName());
		return studentDAO.findByNaturalNames((String[]) nameList.toArray());
	}
	
	public List<Student> findByNaturalNamesByPage(Student[] entities, Integer count, Integer page)
	{	
		List<String> nameList = new ArrayList<String>();
		for(Student student : entities)
			nameList.add(student.getStudentName());
		return studentDAO.findByNaturalNamesByPage((String[]) nameList.toArray(), count, page);
	}
}
