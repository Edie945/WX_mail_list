package com.erhuotu.rabbit.mail_list;

import java.util.List;

/**
 * @Description: 对汉字进行排序
 * @Author: Liangchaojie
 * @Create On 2018/2/26 12:51
 */

public class ChineseSortUtil {
    public static void sortList(List<NameBean> list){
        transferList(list);
    }

    /**
     * 进行冒泡排序
     * @param list
     */
    private static void transferList(List<NameBean> list) {
        for (int i=0;i<list.size()-1;i++){
            for (int j = 0; j < list.size() -1- i; j++) {
                exchangeNameOrder(j,list);
            }
        }
    }

    /**
     * 交换两个名字的顺序,根据首字母判断
     * @param j
     * @param list
     */
    private static void exchangeNameOrder(int j, List<NameBean> list) {
        String namePinYin1 = list.get(j).namePinYin;
        String namePinYin2 = list.get(j+1).namePinYin;

        int size = namePinYin1.length() >= namePinYin2.length() ? namePinYin2.length() : namePinYin1.length();
        for (int i=0;i<size;i++){
            char jc = namePinYin1.charAt(i);
            char jcNext = namePinYin2.charAt(i);
            if(jc<jcNext){//A在B之前就不用比较了
                break;
            }
            if(jc>jcNext){//A在B之后就直接交换,让A在前面B在后面
                NameBean nameBean=list.get(j);
                list.set(j , list.get(j+1));
                list.set(j + 1, nameBean);
                break;
            }
            //如果AB一样就继续比较后面的字母
        }
    }
}