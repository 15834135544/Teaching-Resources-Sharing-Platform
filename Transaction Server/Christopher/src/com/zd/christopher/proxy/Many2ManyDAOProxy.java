package com.zd.christopher.proxy;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.zd.christopher.bean.Entity;
import com.zd.christopher.dao.EntityDAO;
import com.zd.christopher.dao.Many2ManyDAO;

@Aspect
@Component
public class Many2ManyDAOProxy<TEntity extends Entity>
{
	@Resource
	private Many2ManyDAO<TEntity> many2ManyDAO;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public boolean com.zd.christopher.dao..*.update*(..)) && !execution(public boolean com.zd.christopher.dao.Many2ManyDAO.*(..))")
    private void update()
    {
    	
    }
	
    @Around("update() && args(entity)")
    public boolean updateImpl(ProceedingJoinPoint pjp, TEntity entity) throws Throwable
    {
    	String methodName = pjp.getSignature().getName();
    	String updatedField = methodName.substring(6, 7).toLowerCase() + methodName.substring(7);
    	many2ManyDAO.setUpdatedField(updatedField);
    	many2ManyDAO.setEntityClass(((EntityDAO<TEntity>) pjp.getTarget()).getEntityClass());
    	return many2ManyDAO.update(entity);
    }
}
