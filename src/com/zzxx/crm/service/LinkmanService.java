package com.zzxx.crm.service;

import java.util.List;

import com.zzxx.crm.beans.Linkman;

public interface LinkmanService {

	void addLinkman(Long cust_id, Linkman linkman);

	List<Linkman> queryAllLinkman();

	Linkman findLinkmanById(Long lkm_id);

	void modifyLinkman(Linkman linkman);

	void deleteLinkmanById(Long lkm_id);

}
