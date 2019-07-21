package com.wwp.phonestore.back.dao;



import com.wwp.phonestore.pojo.Customer;
import com.wwp.phonestore.pojo.Goods;
import com.wwp.phonestore.pojo.Master;

import java.util.Map;

public class PhoneMasterSqlProvider {

    /*
    *对customer 表操作
     */
    public String select1(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select * from customer where 1=1 ");
        if(map.get("queryname")!=null && map.get("queryname")!=""){
            sql.append(" and name Like CONCAT('%',#{queryname},'%')");
        }
        sql.append(" ORDER BY createtime DESC limit #{currentPageNo} ,#{pageSize}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select2(String queryname){
        StringBuffer sql=new StringBuffer("select count(1) as count from customer where 1=1 ");
        if(queryname!=null && queryname !=""){
            sql.append(" and name Like CONCAT('%',#{queryname},'%')");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select3(Integer cid,String account){
        StringBuffer sql=new StringBuffer("select * from customer  where 1=1 ");
        if(cid !=null){
            sql.append(" and id=#{cid}");
        }
        if(account !=null && account!=""){
            sql.append(" and account=#{account}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String insert1(Customer customer){
        StringBuffer sql=new StringBuffer("insert into customer(account,name,password,sex,age,address,birth,phone,createtime) " +
                "values(#{account},#{name},#{password},#{sex}," +
                "#{age},#{address},#{birth},#{phone},#{createtime})");
        return sql.toString();
    }
    public String update1(Customer customer){
        StringBuffer sql=new StringBuffer("update customer set name=#{name},password=#{password},sex=#{sex},age=#{age}," +
                " address=#{address},birth=#{birth},phone=#{phone} " +
                "where id=#{id}");
        return sql.toString();
    }
    /*
    *对表master 操作
     */
    public String select4(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select * from master where 1=1 ");
        if(map.get("queryname")!=null && map.get("queryname")!=""){
            sql.append(" and name Like CONCAT('%',#{queryname},'%')");
        }
        sql.append(" ORDER BY createtime DESC limit #{currentPageNo} ,#{pageSize}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select5(String queryname){
        StringBuffer sql=new StringBuffer("select count(1) as count from master where 1=1 ");
        if(queryname!=null && queryname!=""){
            sql.append(" and name Like CONCAT('%',#{queryname},'%')");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String insert2(Master master){
        StringBuffer sql=new StringBuffer("insert into master(account,name,password,sex,age,address,birth,phone,createtime) " +
                "values(#{account},#{name},#{password},#{sex}," +
                "  #{age},#{address},#{birth},#{phone},#{createtime})");
        return sql.toString();
    }
    public String select6(Integer mid,String account){
        StringBuffer sql=new StringBuffer("select *  from master where 1=1 ");
        if(mid!=null){
            sql.append(" and id=#{mid}");
        }
        if(account!=null && account!=""){
            sql.append(" and account=#{account}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String update2(Master master){
        StringBuffer sql=new StringBuffer("update master set name=#{name},password=#{password},sex=#{sex},age=#{age}, " +
                "address=#{address},birth=#{birth},phone=#{phone} " +
                "where id=#{id}");
        return sql.toString();
    }
    /*
    *对商品表goods操作
     */
    public String select7(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select g.*,gb.brandType as brandName,ct.colorType as colorName,gs.values as goodStateName from goods g, " +
                "goodsbrand gb,colortype ct,goodstate gs where 1=1 and g.brand=gb.id and g.colorId=ct.id and g.goodState=gs.id ");
        if(map.get("queryGoodName")!=null && map.get("queryGoodName")!=""){
            sql.append(" and g.goodName Like CONCAT('%',#{queryGoodName},'%')");
        }
        if(map.get("queryBrand")!=null && map.get("queryBrand")!=""){
            sql.append(" and g.brand =#{queryBrand}");
        }
        if(map.get("queryState")!=null && map.get("queryState")!="") {
            sql.append(" and g.goodState =#{queryState}");
        }
        sql.append(" ORDER BY g.id DESC limit #{currentPageNo} ,#{pageSize}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select8(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select count(1) as count from goods g where 1=1 ");
        if(map.get("queryGoodName")!=null && map.get("queryGoodName")!=""){
            sql.append(" and g.goodName Like CONCAT('%',#{queryGoodName},'%')");
        }
        if(map.get("queryBrand")!=null && map.get("queryBrand")!=""){
            sql.append(" and g.brand =#{queryBrand}");
        }
        if(map.get("queryState")!=null && map.get("queryState")!="") {
            sql.append(" and g.goodState =#{queryState}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String insert3(Goods goods){
        StringBuffer sql=new StringBuffer("insert into goods(goodName,brand,colorId,price,stock,specs,cpu,goodState,src) " +
                " values(#{goodName},#{brand},#{colorId},#{price},#{stock},#{specs}, " +
                "#{cpu},#{goodState},#{src})");
        return sql.toString();
    }
    public String select9(Integer gid){
        StringBuffer sql=new StringBuffer("select g.*,gb.brandType as brandName,ct.colorType as colorName,gs.values as goodStateName from goods g, " +
                "goodsbrand gb,colortype ct,goodstate gs where 1=1 and g.brand=gb.id  " +
                " and g.colorId=ct.id and g.goodState=gs.id and g.id=#{gid} ");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String update3(Goods goods){
        StringBuffer sql=new StringBuffer("update goods set goodName=#{goodName}, " +
                "brand=#{brand},colorId=#{colorId},price=#{price},stock=#{stock}, " +
                "specs=#{specs},cpu=#{cpu},src=#{src} where id=#{id}");
        return sql.toString();
    }

    /*
    *对订单表order操作
     */
    public String select10(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select o.*,c.name as customerName,os.values as orderStateName from  " +
                " `order` o,customer c,orderstate os where 1=1 and o.customerId=c.id and o.orderState=os.id ");
        if(map.get("queryName")!=null && map.get("queryName")!=""){
            sql.append(" and c.name Like CONCAT('%',#{queryName},'%')");
        }
        if(map.get("queryOrderNo")!=null && map.get("queryOrderNo")!=""){
            sql.append(" and o.orderNo=#{queryOrderNo}");
        }
        if(map.get("queryOrderState")!=null && map.get("queryOrderState")!=""){
            sql.append(" and o.orderState=#{queryOrderState}");
        }
        sql.append(" ORDER BY createdate DESC limit #{currentPageNo} ,#{pageSize}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select11(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select count(1) as count from  " +
                " `order` o,customer c,orderstate os where 1=1 and o.customerId=c.id and o.orderState=os.id ");
        if(map.get("queryName")!=null && map.get("queryName")!=""){
            sql.append(" and c.name Like CONCAT('%',#{queryName},'%')");
        }
        if(map.get("queryOrderNo")!=null && map.get("queryOrderNo")!=""){
            sql.append(" and o.orderNo=#{queryOrderNo}");
        }
        if(map.get("queryOrderState")!=null && map.get("queryOrderState")!=""){
            sql.append(" and o.orderState=#{queryOrderState}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select12(Integer oid){
        StringBuffer sql=new StringBuffer("select o.*,c.name as customerName,os.values as orderStateName from  " +
                " `order` o,customer c,orderstate os where o.customerId=c.id  " +
                "and o.orderState=os.id and o.id=#{oid}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select13(Integer oid){
        StringBuffer sql=new StringBuffer("select og.*,g.*,gb.brandType as brandName, " +
                " ct.colorType as colorName from ordergoods og,goods g,goodsbrand gb,colortype ct " +
                " where g.brand=gb.id and g.colorId=ct.id and og.goodsId=g.id and og.orderId=#{oid}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    /*
    *对购物车标shoppingcar操作
     */
    public String select14(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select sc.*,c.name as customerName,g.goodName,g.src, " +
                " g.price,g.specs,gb.brandType as brandName,ct.colorType as colorName " +
                " from  shoppingcar sc,customer c,goods g,goodsbrand gb,colortype ct where 1=1 " +
                " and sc.goodId=g.id and sc.customerId=c.id and g.brand=gb.id and g.colorId=ct.id");
        if(map.get("queryGoodsName")!=null && map.get("queryGoodsName")!=""){
            sql.append(" and g.goodName Like CONCAT('%',#{queryGoodsName},'%')");
        }
        if(map.get("queryCustomerName")!=null && map.get("queryCustomerName")!=""){
            sql.append(" and c.name Like CONCAT('%',#{queryCustomerName},'%')");
        }
        if(map.get("queryBrand")!=null && map.get("queryBrand")!=""){
            sql.append(" and g.brand=#{queryBrand}");
        }
        sql.append(" ORDER BY createdate DESC limit #{currentPageNo} ,#{pageSize}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select15(Map<String,Object> map){
        StringBuffer sql=new StringBuffer("select count(1) as count from  shoppingcar sc, " +
                " customer c,goods g,goodsbrand gb,colortype ct where 1=1 " +
                " and sc.goodId=g.id and sc.customerId=c.id and g.brand=gb.id and g.colorId=ct.id");
        if(map.get("queryGoodsName")!=null && map.get("queryGoodsName")!=""){
            sql.append(" and g.goodName Like CONCAT('%',#{queryGoodsName},'%')");
        }
        if(map.get("queryCustomerName")!=null && map.get("queryCustomerName")!=""){
            sql.append(" and c.name Like CONCAT('%',#{queryCustomerName},'%')");
        }
        if(map.get("queryBrand")!=null && map.get("queryBrand")!=""){
            sql.append(" and g.brand=#{queryBrand}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select16(Integer sid){
        StringBuffer sql=new StringBuffer("select sc.*,c.name as customerName,g.goodName,g.src," +
                " g.price,g.specs,gb.brandType as brandName,ct.colorType as colorName " +
                " from  shoppingcar sc,customer c,goods g,goodsbrand gb,colortype ct where 1=1  " +
                "and sc.goodId=g.id and sc.customerId=c.id and g.brand=gb.id and g.colorId=ct.id and sc.id=#{sid}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }


}
