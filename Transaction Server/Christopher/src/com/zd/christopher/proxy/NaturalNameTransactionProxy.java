package com.zd.christopher.proxy;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.transaction.BaseTransaction;
import com.zd.christopher.transaction.NaturalNameTransaction;

@Aspect
@Component
public class NaturalNameTransactionProxy<TEntity extends Entity>
{
	@Resource
	private NaturalNameTransaction<TEntity> naturalNameTransaction;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalName(..)) && !execution(public * com.zd.christopher.transaction.NaturalNameTransaction.*(..))")
    private void findByNaturalName()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalNameByPage(..)) && !execution(public * com.zd.christopher.transaction.NaturalNameTransaction.*(..))")
    private void findByNaturalNameByPage()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalNames(..)) && !execution(public * com.zd.christopher.transaction.NaturalNameTransaction.*(..))")
    private void findByNaturalNames()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalNamesByPage(..)) && !execution(public * com.zd.christopher.transaction.NaturalNameTransaction.*(..))")
    private void findByNaturalNamesByPage()
    {
    	
    }
    
    @Around("findByNaturalName() && args(entity)")
    public List<TEntity> findByNaturalNameImpl(ProceedingJoinPoint pjp, TEntity entity) throws Throwable
    {
    	naturalNameTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameTransaction.findByNaturalName(entity);
    }
    
    @Around("findByNaturalNameByPage() && args(entity, count, page)")
    public List<TEntity> findByNaturalNameByPageImpl(ProceedingJoinPoint pjp, TEntity entity, Integer count, Integer page) throws Throwable
    {
    	naturalNameTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameTransaction.findByNaturalNameByPage(entity, count, page);
    }
    
    @Around("findByNaturalNames() && args(entities)")
    public List<TEntity> findByNaturalNamesImpl(ProceedingJoinPoint pjp, TEntity[] entities) throws Throwable
    {
    	naturalNameTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameTransaction.findByNaturalNames(entities);
    }
    
    @Around("findByNaturalNamesByPage() && args(entities, count, page)")
    public List<TEntity> findByNaturalNamesByPageImpl(ProceedingJoinPoint pjp, TEntity[] entities, Integer count, Integer page) throws Throwable
    {
    	naturalNameTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalNameTransaction.findByNaturalNamesByPage(entities, count, page);
    }
}
