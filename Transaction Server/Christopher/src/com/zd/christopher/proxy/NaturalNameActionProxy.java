package com.zd.christopher.proxy;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zd.christopher.action.BaseAction;
import com.zd.christopher.action.NaturalNameAction;
import com.zd.christopher.bean.Entity;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonResult;

@Aspect
@Component
@Order(1)
public class NaturalNameActionProxy<TEntity extends Entity>
{
	@Resource
	private NaturalNameAction<TEntity> naturalNameAction;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalName(..)) && !execution(public * com.zd.christopher.action.NaturalNameAction.*(..))")
    private void findByNaturalName()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalNameByPage(..)) && !execution(public * com.zd.christopher.action.NaturalNameAction.*(..))")
    private void findByNaturalNameByPage()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalNames(..)) && !execution(public * com.zd.christopher.action.NaturalNameAction.*(..))")
    private void findByNaturalNames()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalNamesByPage(..)) && !execution(public * com.zd.christopher.action.NaturalNameAction.*(..))")
    private void findByNaturalNamesByPage()
    {
    	
    }
    
    @Around("findByNaturalName()")
    public String findByNaturalNameImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	TEntity tempEntity = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList().get(0);
    	naturalNameAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	List<TEntity> entityList = naturalNameAction.findByNaturalName(tempEntity);
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8")));
    	return "success";
    }
    
    @Around("findByNaturalNameByPage()")
    public String findByNaturalNameByPageImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	TEntity tempEntity = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList().get(0);
    	Integer count = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getCount();
    	Integer page = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getPage();
    	naturalNameAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	List<TEntity> entityList = naturalNameAction.findByNaturalNameByPage(tempEntity, count, page);
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8")));
    	return "success";
    }
    
    @Around("findByNaturalNames()")
    public String findByNaturalNamesImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	List<TEntity> tempEntityList = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList();
    	naturalNameAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	List<TEntity> entityList = naturalNameAction.findByNaturalNames((TEntity[]) tempEntityList.toArray());
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8")));
    	return "success";
    }
    
    @Around("findByNaturalNamesByPage()")
    public String findByNaturalNamesByPageImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	List<TEntity> tempEntityList = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList();
    	Integer count = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getCount();
    	Integer page = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getPage();
    	naturalNameAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	List<TEntity> entityList = naturalNameAction.findByNaturalNamesByPage((TEntity[]) tempEntityList.toArray(), count, page);
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8")));
    	return "success";
    }
}
