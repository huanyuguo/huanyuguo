package com.byzoro.dao.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.byzoro.dao.TaskDao;
import com.byzoro.entity.TaskEntity;



/**
 * 任务信息持久层实现
 */
public class TaskDaoImpl implements TaskDao {
	// TODO: 存放任务信息
	private ConcurrentMap<String, TaskEntity> map = null;

	public TaskDaoImpl(int size) {
		map = new ConcurrentHashMap<>(size);
	}

	@Override
	public TaskEntity get(String id) {
		return map.get(id);
	}

	@Override
	public Collection<TaskEntity> getAll() {
		return map.values();
	}

	@Override
	public int add(TaskEntity taskEntity) {
		String id = taskEntity.getId();
		if (id != null && !map.containsKey(id)) {
			map.put(taskEntity.getId(), taskEntity);
			if(map.get(id)!=null)
			{
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int remove(String id) {
		if(map.remove(id) != null){
			return 1;
		};
		return 0;
	}

	@Override
	public int removeAll() {
		int size = map.size();
		try {
			map.clear();
		} catch (Exception e) {
			return 0;
		}
		return size;
	}

	@Override
	public boolean isHave(String id) {
		return map.containsKey(id);
	}

}
