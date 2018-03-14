package com.zd.christopher.proxy;

import java.io.ByteArrayInputStream;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zd.christopher.action.BaseAction;
import com.zd.christopher.action.Many2ManyAction;
import com.zd.christopher.bean.Entity;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonResult;

@Aspect
@Component
@Scope("prototype")
@Order(1)
public class Many2ManyActionProxy<TEntity extends Entity>
{
	@Resource
	private Many2ManyAction<TEntity> many2ManyAction;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public String com.zd.christopher.action..*.update*(..)) && !execution(public boolean com.zd.christopher.action.Many2ManyAction.*(..))")
    private void update()
    {
    	
    }
	
    @Around("update()")
    public String updateImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	TEntity entity = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList().get(0);
    	String methodName = pjp.getSignature().getName();
    	String updatedField = methodName.substring(6, 7).toLowerCase() + methodName.substring(7);
    	many2ManyAction.setUpdatedField(updatedField);
    	many2ManyAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	many2ManyAction.update(entity);
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS).getBytes("UTF-8")));
    	return "success";
    }
}
