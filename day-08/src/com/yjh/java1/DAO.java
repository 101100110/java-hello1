package com.yjh.java1;

import java.util.List;

/**
 * @author yjh 1600063206@qq.com
 * @version 2023/5/17 15:17
 * @since JDK8
 * DAO:data(base) access object
 *
 */
public class DAO<T>{

    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){
        return false;
    }
    //修改一条记录
    public void update(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }
}