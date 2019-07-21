package com.wwp.phonestore.back.dao;

import com.wwp.phonestore.pojo.Master;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("masterDao")
public interface MasterDao {

    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select4")
    public List<Master> getMasterList(Map<String,Object> map);

    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select5")
    public int getMasterCount(String queryname);

    @InsertProvider(type=PhoneMasterSqlProvider.class,method = "insert2")
    public int addMaster(Master master);

    @SelectProvider(type=PhoneMasterSqlProvider.class,method = "select6")
    public Master getMaster(Integer mid,String account);

    @UpdateProvider(type=PhoneMasterSqlProvider.class,method = "update2")
    public int updateMaster(Master master);

    @Delete("delete from master where id=#{mid}")
    public int delMaster(Integer mid);

    @Select("select * from master where account=#{account}")
    public Master getMasterByName(String account);



}
