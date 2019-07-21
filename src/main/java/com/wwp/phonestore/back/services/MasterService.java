package com.wwp.phonestore.back.services;

import com.wwp.phonestore.pojo.Master;

import java.util.List;
import java.util.Map;

public interface MasterService {

    public int getMasterCount(String queryname);

    public List<Master> getMasterList(Map<String,Object> map);

    public boolean addMaster(Master master);

    public Master getMaster(Integer mid,String account);

    public boolean updateMaster(Master master);

    public boolean deleteMaster(Integer mid);

    public Master getMasterByName(String account);
}
