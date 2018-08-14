package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShoucang;

/**
 * Data access object (DAO) for domain model class TShoucang.
 * 
 * @see com.model.TShoucang
 * @author MyEclipse Persistence Tools
 */

public class TShoucangDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShoucangDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShoucang transientInstance)
	{
		log.debug("saving TShoucang instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TShoucang persistentInstance)
	{
		log.debug("deleting TShoucang instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TShoucang findById(java.lang.Integer id)
	{
		log.debug("getting TShoucang instance with id: " + id);
		try
		{
			TShoucang instance = (TShoucang) getHibernateTemplate().get(
					"com.model.TShoucang", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShoucang instance)
	{
		log.debug("finding TShoucang instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TShoucang instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShoucang as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TShoucang instances");
		try
		{
			String queryString = "from TShoucang";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShoucang merge(TShoucang detachedInstance)
	{
		log.debug("merging TShoucang instance");
		try
		{
			TShoucang result = (TShoucang) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShoucang instance)
	{
		log.debug("attaching dirty TShoucang instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TShoucang instance)
	{
		log.debug("attaching clean TShoucang instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TShoucangDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShoucangDAO) ctx.getBean("TShoucangDAO");
	}
}