package com.erhuotu.rabbit.mail_list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人字母索引Activity
 */
public class MainActivity extends AppCompatActivity implements LetterIndexView.onWordsChangeListener, AbsListView.OnScrollListener {

    private ListView peopleListView;
    private List<NameBean> peopleList;//联系人列表
    private TextView toastTexT;
    private LetterIndexView letterIndexView;
    private ContactsAdapter contactsAdapter;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setListener();
        renderView();
    }

    private void setListener() {
        handler = new Handler();
        letterIndexView.setOnWordsChangeListener(this);
        peopleListView.setOnScrollListener(this);
    }

    private void renderView() {
        contactsAdapter = new ContactsAdapter(MainActivity.this,peopleList);
        peopleListView.setAdapter(contactsAdapter);
    }

    private void initData() {
        peopleList = new ArrayList<>();
        peopleList.add(new NameBean("风四娘"));
        peopleList.add(new NameBean("阿飞"));
        peopleList.add(new NameBean("阿杰"));
        peopleList.add(new NameBean("百里守约"));
        peopleList.add(new NameBean("曹操"));
        peopleList.add(new NameBean("党中央"));
        peopleList.add(new NameBean("连城璧"));
        peopleList.add(new NameBean("萧十一郎 "));
        peopleList.add(new NameBean("沈璧君"));
        peopleList.add(new NameBean("逍遥侯"));
        peopleList.add(new NameBean("杨开泰"));
        peopleList.add(new NameBean("沈飞云"));
        peopleList.add(new NameBean("小公子"));
        peopleList.add(new NameBean("张飞"));
        peopleList.add(new NameBean("后裔"));
        peopleList.add(new NameBean("剑圣"));
        peopleList.add(new NameBean("蛮王"));
        peopleList.add(new NameBean("亚索"));
        peopleList.add(new NameBean("小鱼人"));
        peopleList.add(new NameBean("卡特"));
        peopleList.add(new NameBean("布隆"));
        peopleList.add(new NameBean("Tony"));
        peopleList.add(new NameBean("老刘"));
        peopleList.add(new NameBean("隔壁老王"));
        peopleList.add(new NameBean("虚空之眼"));
        peopleList.add(new NameBean("阿卡丽"));
        peopleList.add(new NameBean("炸弹人"));
        peopleList.add(new NameBean("那英"));
        peopleList.add(new NameBean("沙宝亮"));
        peopleList.add(new NameBean("老鼠"));
        peopleList.add(new NameBean("猴子"));
        peopleList.add(new NameBean("安妮"));
        peopleList.add(new NameBean("金克斯"));
        peopleList.add(new NameBean("拉克丝"));
        peopleList.add(new NameBean("武器"));
        peopleList.add(new NameBean("Tom"));
        peopleList.add(new NameBean("阿三"));
        peopleList.add(new NameBean("肖奈"));
        peopleList.add(new NameBean("盲僧"));
        peopleList.add(new NameBean("龙王"));
        peopleList.add(new NameBean("寒冰射手"));
        peopleList.add(new NameBean("秋名山第一打野"));
        peopleList.add(new NameBean("机器人"));
        peopleList.add(new NameBean("张无忌"));
        peopleList.add(new NameBean("张翠山"));
        peopleList.add(new NameBean("巴克"));
        peopleList.add(new NameBean("额了(⊙o⊙)…"));
        peopleList.add(new NameBean("の"));
        peopleList.add(new NameBean("嚄哦哦"));
        peopleList.add(new NameBean("哦里有"));
        peopleList.add(new NameBean("爬山虎"));
        peopleList.add(new NameBean("任职"));
        peopleList.add(new NameBean("uu"));
        peopleList.add(new NameBean("vvv"));
        peopleList.add(new NameBean("123"));
        peopleList.add(new NameBean("321"));
        peopleList.add(new NameBean("*&卡死"));
        peopleList.add(new NameBean("张果老"));
        peopleList.add(new NameBean("张一山"));

        //在这里对联系人集合进行排序
        ChineseSortUtil.sortList(peopleList);
    }

    private void initView() {
        peopleListView = findViewById(R.id.list);
        toastTexT = findViewById(R.id.tv);
        letterIndexView = findViewById(R.id.words);
    }

    @Override
    public void wordsChange(String words) {
        updateWord(words);
        updateListView(words);
    }


    /**
     * 选中了字母索引列表的任何一个字母，ListView相应的字母也得置顶
     * @param words
     */
    private void updateListView(String words) {
        for(int i=0;i<peopleList.size();i++){
            if(words.equals(peopleList.get(i).firstLetter)){
                peopleListView.setSelection(i);
                return;
            }
        }
    }


    /**
     * 更新中央的字母提示
     * @param words 首字母
     */
    private void updateWord(String words) {
        toastTexT.setText(words);
        toastTexT.setVisibility(View.VISIBLE);
        //清空之前的所有消息
        handler.removeCallbacksAndMessages(null);
        //1s后让tv隐藏
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toastTexT.setVisibility(View.GONE);
            }
        }, 500);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //当滑动列表的时候，更新右侧字母列表的选中状态
        letterIndexView.setTouchIndex(peopleList.get(firstVisibleItem).firstLetter);
    }
}
