package com.zd.christopher.proxy;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.transaction.BaseTransaction;
import com.zd.christopher.transaction.Many2ManyTransaction;

@Aspect
@Component
public class Many2ManyTransactionProxy<TEntity extends Entity>
{
	@Resource
	private Many2ManyTransaction<TEntity> many2ManyTransaction;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public boolean com.zd.christopher.transaction..*.update*(..)) && !execution(public boolean com.zd.christopher.transaction.Many2ManyTransaction.*(..))")
    private void update()
    {
    	
    }
    
    @Around("update() && args(entity)")
    public boolean updateImpl(ProceedingJoinPoint pjp, TEntity entity) throws Throwable
    {
    	String methodName = pjp.getSignature().getName();
    	String updatedField = methodName.substring(6, 7).toLowerCase() + methodName.substring(7);
    	many2ManyTransaction.setUpdatedField(updatedField);
    	many2ManyTransaction.setEntityClass(((BaseTransaction<TEntity>) pjp.getTarget()).getEntityClass());
    	return many2ManyTransaction.update(entity);
    }
}
