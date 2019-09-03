package com.zzxx.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zzxx.crm.beans.User;

public interface UserDao {


	List<User> findUserDetachedCriteria(DetachedCriteria dc);

}
