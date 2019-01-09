package com.wdx.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 */
public class Pager<T> {


    /**
     * 当前页
     */
    private int pageIndex;
    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 总条数
     */
    private int total;

    private List<T> data;


    public Pager(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public boolean hasNextpage(){
        return this.getPageIndex()*this.getPageSize()>=this.total ? false:true;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static void main(String[] args) {

        Pager<String> pager1 = new Pager<String>(1,10);
        pager1.setTotal(23);
        List<String> list1 = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            list1.add("pager-1:"+pager1.getPageIndex()+"1");
        }

        Pager<String> pager2 = new Pager<String>(1,10);
        pager1.setTotal(16);
        List<String> list2 = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            list1.add("pager-2:"+pager1.getPageIndex()+"1");
        }

    }
}
