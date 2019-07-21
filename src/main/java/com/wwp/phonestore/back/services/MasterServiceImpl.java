package com.wwp.phonestore.back.services;

import com.wwp.phonestore.back.dao.MasterDao;
import com.wwp.phonestore.pojo.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MasterServiceImpl implements MasterService {
    @Autowired
    private MasterDao masterDao;
    @Override
    public int getMasterCount(String queryname) {
        return masterDao.getMasterCount(queryname);
    }

    @Override
    public List<Master> getMasterList(Map<String, Object> map) {
        return masterDao.getMasterList(map);
    }

    @Override
    public boolean addMaster(Master master)
    {
        int num=masterDao.addMaster(master);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public Master getMaster(Integer mid, String account) {

        return masterDao.getMaster(mid,account);
    }

    @Override
    public boolean updateMaster(Master master)
    {
        int num=masterDao.updateMaster(master);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteMaster(Integer mid) {
        int num=masterDao.delMaster(mid);
        if(num>0)
            return true;
        return false;
    }

    @Override
    public Master getMasterByName(String account) {
        return masterDao.getMasterByName(account);
    }
}
