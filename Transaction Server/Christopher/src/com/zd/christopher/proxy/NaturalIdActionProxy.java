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
import com.zd.christopher.action.NaturalIdAction;
import com.zd.christopher.bean.Entity;
import com.zd.christopher.enumeration.Result;
import com.zd.christopher.json.JsonResult;

@Aspect
@Component
@Order(1)
public class NaturalIdActionProxy<TEntity extends Entity>
{
	@Resource
	private NaturalIdAction<TEntity> naturalIdAction;
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalId(..)) && !execution(public * com.zd.christopher.action.NaturalIdAction.*(..))")
    private void findByNaturalId()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalIds(..)) && !execution(public * com.zd.christopher.action.NaturalIdAction.*(..))")
    private void findByNaturalIds()
    {
    	
    }
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.zd.christopher.action..*.findByNaturalIdsByPage(..)) && !execution(public * com.zd.christopher.action.NaturalIdAction.*(..))")
    private void findByNaturalIdsByPage()
    {
    	
    }
    
    @Around("findByNaturalId()")
    public String findByNaturalIdImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	TEntity tempEntity = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList().get(0);
    	naturalIdAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	TEntity entity = naturalIdAction.findByNaturalId(tempEntity);
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entity).getBytes("UTF-8")));
    	return "success";
    }
    
    @Around("findByNaturalIds()")
    public String findByNaturalIdsImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	List<TEntity> tempEntityList = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList();
    	naturalIdAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	List<TEntity> entityList = naturalIdAction.findByNaturalIds((TEntity[]) tempEntityList.toArray());
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8")));
    	return "success";
    }
    
    @Around("findByNaturalIdsByPage())")
    public String findByNaturalIdsByPageImpl(ProceedingJoinPoint pjp) throws Throwable
    {
    	List<TEntity> tempEntityList = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getEntityList();
    	Integer count = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getCount();
    	Integer page = ((BaseAction<TEntity>) pjp.getTarget()).getJsonForm().getPage();
    	naturalIdAction.setEntityClass(((BaseAction<TEntity>) pjp.getTarget()).getEntityClass());
    	List<TEntity> entityList = naturalIdAction.findByNaturalIdsByPage((TEntity[]) tempEntityList.toArray(), count, page);
    	((BaseAction<TEntity>) pjp.getTarget()).setResult(new ByteArrayInputStream(JsonResult.constructResult(Result.SUCCESS, entityList).getBytes("UTF-8")));
    	return "success";
    }
}
