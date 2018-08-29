/*
 * Copyright (c) 2010-2018 300.cn All Rights Reserved
 *
 * File:BaseDao.java Project: spring-boot-starter-framework
 * 
 * Creator: gaopeng@300.cn 
 * Date:2018年8月29日 下午1:27:35
 * 
 */
package cn.cebest.framework.support;

import java.util.List;

/**
 * @author gaopeng@300.cn
 * @version 2018年8月29日 下午1:27:35
 */
public interface BaseDao<T> {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	T selectById(Long id);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	T selectById(String id);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	T selectById(Integer id);

	/**
	 * 根据pid查询
	 * 
	 * @param pid
	 * @return
	 */
	List<T> selectByParentId(Integer id);

	/**
	 * 查询单条信息
	 * 
	 * @param entity
	 * @return
	 */
	List<T> selectByEntity(T entity);

	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	List<T> selectAll();

	/**
	 * 根据拼装条件进行查询
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> selectByConditions(BaseCriteria criteria);

	/**
	 * 插入单条信息
	 * 
	 * @param entity
	 * @return
	 */
	int insert(T entity);

	/**
	 * 批量插入信息
	 * 
	 * @param list
	 * @return
	 */
	int batchInsert(List<T> list);

	/**
	 * 修改单条信息
	 * 
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * 删除单条信息
	 * 
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 删除单条信息
	 * 
	 * @param id
	 * @return
	 */
	int delete(String id);

	/**
	 * 删除单条信息
	 * 
	 * @param id
	 * @return
	 */

	int delete(Integer id);

	/**
	 * 批量删除信息
	 * 
	 * @param array
	 * @return
	 */
	int batchDeleteArray(Long[] array);

	/**
	 * 批量删除信息
	 * 
	 * @param array
	 * @return
	 */
	int batchDeleteArray(Integer[] array);

	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return
	 */
	int batchDeleteList(List<Integer> list);

	/**
	 * 批量查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> batchSelectList(List<Integer> ids);

}
