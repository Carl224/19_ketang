package com.example.t.app.util;

import com.example.t.app.entity.MyGrid_Item;
import com.example.t.app.global.MyApplication;
import com.example.t.application.dao.DaoMaster;
import com.example.t.application.dao.DaoSession;
import com.example.t.application.dao.MyGrid_ItemDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MydbUtil {
    private static MydbUtil mydbUtil;
    private final MyGrid_ItemDao myGrid_itemDao;

    public MydbUtil(String str) {
        //创建数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.mCtontext, str);
        //创建可操作数据
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        //获取数据库表管理对象
        DaoSession daoSession = daoMaster.newSession();
        //获取当前数据库操作表的对象
        myGrid_itemDao = daoSession.getMyGrid_ItemDao();


    }

    public static MydbUtil getMydbUtil(String str) {
        mydbUtil = new MydbUtil(str);
        return mydbUtil;
    }

    public void addd(List<MyGrid_Item> list) {
        myGrid_itemDao.insertInTx(list);


    }

    public void addd(MyGrid_Item myGrid_item) {

        myGrid_itemDao.insertOrReplace(myGrid_item);
    }

    public void remove(MyGrid_Item myGrid_item) {
        myGrid_itemDao.delete(myGrid_item);
    }

    public List<MyGrid_Item> query() {
        List<MyGrid_Item> list = myGrid_itemDao.queryBuilder().list();

        return list;
    }
}
