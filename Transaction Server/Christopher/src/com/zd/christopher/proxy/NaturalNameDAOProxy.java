package com.zd.christopher.proxy;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.dao.EntityDAO;
import com.zd.christopher.dao.NaturalNameDAO;

@Aspect
@Component
public class NaturalNameDAOProxy<TEntity extends Entity>
{
	@Resource
	private NaturalNameDAO<TEntity> naturalNameDAO;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalName(..)) && !execution(public * com.zd.christopher.dao.NaturalNameDAO.*(..))")
    private void findByNaturalName()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalNameByPage(..)) && !execution(public * com.zd.christopher.dao.NaturalNameDAO.*(..))")
    private void findByNaturalNameByPage()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalNames(..)) && !execution(public * com.zd.christopher.dao.NaturalNameDAO.*(..))")
    private void findByNaturalNames()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalNamesByPage(..)) && !execution(public * com.zd.christopher.dao.NaturalNameDAO.*(..))")
    private void findByNaturalNamesByPage()
    {
    	
    }
    
    @Around("findByNaturalName() && args(naturalName)")
    public List<TEntity> findByNaturalNameImpl(ProceedingJoinPoint pjp, String naturalName) throws Throwable
    {
    	naturalNameDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameDAO.findByNaturalName(naturalName);
    }
    
    @Around("findByNaturalNameByPage() && args(naturalName, count, page)")
    public List<TEntity> findByNaturalNameByPageImpl(ProceedingJoinPoint pjp, String naturalName, Integer count, Integer page) throws Throwable
    {
    	naturalNameDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameDAO.findByNaturalNameByPage(naturalName, count, page);
    }
    
    @Around("findByNaturalNames() && args(naturalNames)")
    public List<TEntity> findByNaturalNamesImpl(ProceedingJoinPoint pjp, String[] naturalNames) throws Throwable
    {
    	naturalNameDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameDAO.findByNaturalNames(naturalNames);
    }
    
    @Around("findByNaturalNamesByPage() && args(naturalNames, count, page)")
    public List<TEntity> findByNaturalNamesByPageImpl(ProceedingJoinPoint pjp, String[] naturalNames, Integer count, Integer page) throws Throwable
    {
    	naturalNameDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameDAO.findByNaturalNamesByPage(naturalNames, count, page);
    }
}
