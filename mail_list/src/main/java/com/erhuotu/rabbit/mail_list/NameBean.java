package com.erhuotu.rabbit.mail_list;

import com.github.promeg.pinyinhelper.Pinyin;

/**
 * Description
 * Created by Administrator
 * Time 2018/2/26  19:56
 */

public class NameBean {
    public String nameChinese;//汉字: 梁超杰
    public String firstLetter;//首字母:  L
    public String namePinYin;//拼音:  LIANGCHAOJIE
    public NameBean(String name) {
        this.nameChinese = name;
        this.namePinYin = Pinyin.toPinyin(name, "");
        firstLetter = namePinYin.substring(0,1);
    }
}
