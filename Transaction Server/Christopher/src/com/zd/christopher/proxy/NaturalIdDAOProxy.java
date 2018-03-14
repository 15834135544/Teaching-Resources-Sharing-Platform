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
import com.zd.christopher.dao.NaturalIdDAO;

@Aspect
@Component
public class NaturalIdDAOProxy<TEntity extends Entity>
{
	@Resource
	private NaturalIdDAO<TEntity> naturalIdDAO;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalId(..)) && !execution(public * com.zd.christopher.dao.NaturalIdDAO.*(..))")
    private void findByNaturalId()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalIds(..)) && !execution(public * com.zd.christopher.dao.NaturalIdDAO.*(..))")
    private void findByNaturalIds()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.dao..*.findByNaturalIdsByPage(..)) && !execution(public * com.zd.christopher.dao.NaturalIdDAO.*(..))")
    private void findByNaturalIdsByPage()
    {
    	
    }
    
    @Around("findByNaturalId() && args(naturalId)")
    public TEntity findByNaturalIdImpl(ProceedingJoinPoint pjp, String naturalId) throws Throwable
    {
    	naturalIdDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalIdDAO.findByNaturalId(naturalId);
    }
    
    @Around("findByNaturalIds() && args(naturalIds)")
    public List<TEntity> findByNaturalIdsImpl(ProceedingJoinPoint pjp, String[] naturalIds) throws Throwable
    {
    	naturalIdDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalIdDAO.findByNaturalIds(naturalIds);
    }
    
    @Around("findByNaturalIdsByPage() && args(naturalIds, count, page)")
    public List<TEntity> findByNaturalIdsByPageImpl(ProceedingJoinPoint pjp, String[] naturalIds, Integer count, Integer page) throws Throwable
    {
    	naturalIdDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return  naturalIdDAO.findByNaturalIdsByPage(naturalIds, count, page);
    }
}
