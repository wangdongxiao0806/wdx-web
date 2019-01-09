package com.wdx.model;

import com.wdx.util.Pager;

public class Test {

    private static Service service = new Service();


    public static void main(String[] args) {

        int pageIndex = 1;
        int pageSize = 10;
        int pageTotal = 1;
//        for(int i = pageIndex ; i <= pageTotal ;i++) {
            Pager<Person> pager = new Pager<Person>(3, pageSize);

            Pager<Person> result1 = service.queryByPage1(pager);
            if(!result1.hasNextpage()) {
                for (Person person : result1.getData()) {
                    System.out.println(person.getName());
                }
                int min =result1.getPageIndex()*result1.getPageSize()-result1.getTotal();
                System.out.println(min);
                int pageSize2 = pageSize+min;
                Pager<Person> pager2 = new Pager<Person>(1, pageSize2);
                Pager<Person> result2 = service.queryByPage1(pager2);
                for(int j = 0 ; j < min ; j++){
                    result1.getData().add(result2.getData().get(j));
                }
                for (Person person : result1.getData()) {
                    System.out.println(person.getName());
                }

//            }
            pageTotal =result1.getTotal()/result1.getPageSize()+1;
        }


    }

}
