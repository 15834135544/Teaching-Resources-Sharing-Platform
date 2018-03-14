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
import com.zd.christopher.transaction.NaturalIdTransaction;

@Aspect
@Component
public class NaturalIdTransactionProxy<TEntity extends Entity>
{
	@Resource
	private NaturalIdTransaction<TEntity> naturalIdTransaction;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalId(..)) && !execution(public * com.zd.christopher.transaction.NaturalIdTransaction.*(..))")
    private void findByNaturalId()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalIds(..)) && !execution(public * com.zd.christopher.transaction.NaturalIdTransaction.*(..))")
    private void findByNaturalIds()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.transaction..*.findByNaturalIdsByPage(..)) && !execution(public * com.zd.christopher.transaction.NaturalIdTransaction.*(..))")
    private void findByNaturalIdsByPage()
    {
    	
    }
    
    @Around("findByNaturalId() && args(entity)")
    public TEntity findByNaturalIdImpl(ProceedingJoinPoint pjp, TEntity entity) throws Throwable
    {
    	naturalIdTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalIdTransaction.findByNaturalId(entity);
    }
    
    @Around("findByNaturalIds() && args(entities)")
    public List<TEntity> findByNaturalIdsImpl(ProceedingJoinPoint pjp, TEntity[] entities) throws Throwable
    {
    	naturalIdTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalIdTransaction.findByNaturalIds(entities);
    }
    
    @Around("findByNaturalIdsByPage() && args(entities, count, page)")
    public List<TEntity> findByNaturalIdsByPageImpl(ProceedingJoinPoint pjp, TEntity[] entities, Integer count, Integer page) throws Throwable
    {
    	naturalIdTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return naturalIdTransaction.findByNaturalIdsByPage(entities, count, page);
    }
}
