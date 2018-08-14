package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TBook;

/**
 * A data access object (DAO) providing persistence and search support for TBook
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.model.TBook
 * @author MyEclipse Persistence Tools
 */

public class TBookDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TBookDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(TBook transientInstance) {
		log.debug("saving TBook instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBook persistentInstance) {
		log.debug("deleting TBook instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBook findById(java.lang.Integer id) {
		log.debug("getting TBook instance with id: " + id);
		try {
			TBook instance = (TBook) getHibernateTemplate().get(
					"com.model.TBook", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBook instance) {
		log.debug("finding TBook instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TBook instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TBook as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TBook instances");
		try {
			String queryString = "from TBook";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBook merge(TBook detachedInstance) {
		log.debug("merging TBook instance");
		try {
			TBook result = (TBook) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBook instance) {
		log.debug("attaching dirty TBook instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBook instance) {
		log.debug("attaching clean TBook instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TBookDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TBookDAO) ctx.getBean("TBookDAO");
	}
}