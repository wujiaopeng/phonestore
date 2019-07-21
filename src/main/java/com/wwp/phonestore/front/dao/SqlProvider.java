package com.wwp.phonestore.front.dao;

import com.wwp.phonestore.pojo.Customer;
import com.wwp.phonestore.pojo.Order;

import java.util.Map;

public class SqlProvider {
    /*
     *对商品表goods操作
     */
    public String select1(Integer bid){
        StringBuffer sql=new StringBuffer("select g.*,gb.brandType as brandName,ct.colorType as colorName,gs.values as goodStateName from goods g, " +
                "goodsbrand gb,colortype ct,goodstate gs where 1=1 and g.brand=gb.id and g.colorId=ct.id and g.goodState=gs.id ");
        if(bid!=null && bid !=0){
            sql.append(" and g.brand =#{bid}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select2(Integer gid){
        StringBuffer sql=new StringBuffer("select g.*,gb.brandType as brandName,ct.colorType as colorName,gs.values as goodStateName from goods g, " +
                "goodsbrand gb,colortype ct,goodstate gs where 1=1 and g.brand=gb.id and " +
                " g.colorId=ct.id and g.goodState=gs.id and g.id=#{gid}");

        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select3(Integer gid){
        StringBuffer sql=new StringBuffer("select cm.*,c.name as cName from comment cm,customer c where 1=1 and " +
                " cm.cId=c.id and gId = #{gid} order by createtime desc");

        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String select4(Integer cid){
        StringBuffer sql=new StringBuffer("select sc.*,c.name as customerName,g.goodName,g.src, " +
                " g.price,g.specs,g.stock,gb.brandType as brandName,ct.colorType as colorName " +
                " from  shoppingcar sc,customer c,goods g,goodsbrand gb,colortype ct where 1=1 " +
                " and sc.goodId=g.id and sc.customerId=c.id and g.brand=gb.id and g.colorId=ct.id " +
                " and sc.customerId =#{cid}");

        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
    public String insert1(Order order){
        StringBuffer sql=new StringBuffer("insert into `order`(orderNo,customerId,total,createdate,orderState,address,phone) " +
                " values(#{orderNo},#{customerId},#{total},#{createdate},#{orderState},#{address},#{phone})");

        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }

    public String select5(Integer oid){
        StringBuffer sql=new StringBuffer("select o.*,c.name as customerName from  " +
                " `order` o,customer c where o.customerId=c.id  " +
                " and o.id=#{oid}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }
   public String select6(Integer oid){
        StringBuffer sql=new StringBuffer("select og.*,g.*,gb.brandType as brandName, " +
                " ct.colorType as colorName from ordergoods og,goods g,goodsbrand gb,colortype ct " +
                " where g.brand=gb.id and g.colorId=ct.id and og.goodsId=g.id and og.orderId=#{oid}");
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }

    public String select7(Integer cid,Integer state){
        StringBuffer sql=new StringBuffer("select o.*,os.values as orderStateName from  " +
                " `order` o,orderstate os where 1=1 " +
                " and  o.orderState=os.id and o.customerId=#{cid} ");
        if(state!=null){
            sql.append(" and o.orderState=#{state}");
        }
        System.out.println("=============================="+sql.toString());
        return sql.toString();
    }

    public String insert2(Customer customer){
        StringBuffer sql=new StringBuffer("insert into customer(account,name,password,sex,age,address,birth,phone,createtime) " +
                "values(#{account},#{name},#{password},#{sex}," +
                "#{age},#{address},#{birth},#{phone},#{createtime})");
        return sql.toString();
    }
}
