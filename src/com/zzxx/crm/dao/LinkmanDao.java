package com.zzxx.crm.dao;

import java.util.List;

import com.zzxx.crm.beans.Linkman;

public interface LinkmanDao {

	void save(Linkman linkman);

	List<Linkman> findAllLinkman();

	Linkman getLinkmanById(Long lkm_id);

	void update(Linkman linkman);

	void delete(Linkman linkman);

}
