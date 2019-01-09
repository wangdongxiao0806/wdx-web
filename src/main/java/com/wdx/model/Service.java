package com.wdx.model;

import com.wdx.util.Pager;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private static int total = 23;


    public Pager<Person> queryByPage1(Pager<Person> pager){

        List<Person> list = new ArrayList<Person>();
        int size = pager.getPageIndex()*pager.getPageSize() >total?total:pager.getPageIndex()*pager.getPageSize();
        for(int i =( pager.getPageIndex()-1)*pager.getPageSize();i< size ; i++){
            Person person = new Person();
            person.setName("name"+i);
            list.add(person);
        }
        pager.setData(list);
        pager.setTotal(total);
        return pager;
    }
}
