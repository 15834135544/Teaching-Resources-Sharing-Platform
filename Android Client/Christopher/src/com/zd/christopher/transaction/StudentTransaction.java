package com.zd.christopher.transaction;

import java.util.List;

import com.zd.christopher.bean.Student;

public class StudentTransaction extends BaseTransaction<Student> implements IStudentTransaction
{
	public StudentTransaction()
	{
		entityClass = Student.class;
	}

	public Student findByNaturalId(Student entity)
	{
		return null;
	}

	public List<Student> findByNaturalIds(Student[] entities)
	{
		return null;
	}

	public List<Student> findByNaturalIdsByPage(Student[] entities, Integer count, Integer page)
	{
		return null;
	}

	public List<Student> findByNaturalName(Student entity)
	{
		return null;
	}

	public List<Student> findByNaturalNameByPage(Student entity, Integer count, Integer page)
	{	
		return null;
	}

	public List<Student> findByNaturalNames(Student[] entities)
	{
		return null;
	}
	
	public List<Student> findByNaturalNamesByPage(Student[] entities, Integer count, Integer page)
	{	
		return null;
	}
}
