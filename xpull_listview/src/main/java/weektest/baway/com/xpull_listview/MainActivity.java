package weektest.baway.com.xpull_listview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import weektest.baway.com.adapter.MyAdapter;
import weektest.baway.com.bean.Goods;
import weektest.baway.com.bean.GoodsBean;
import weektest.baway.com.util.MyUtil;
public class MainActivity extends BaseActivity {
private PullToRefreshListView p_listview;
private String url = "http://www.xieast.com/api/news/news.php?page=";
private int page = 1;
private List<GoodsBean> list = new ArrayList<GoodsBean>();
    private MyAdapter myAdapter;

    @Override
    protected void initData() {
        myAdapter = new MyAdapter(MainActivity.this,list);
        p_listview.setAdapter(myAdapter);
        MyData(page);
    }

    private void MyData(int p) {
        String murl = url+p;
        MyUtil.MyTask(murl, new MyUtil.MyScank(){
            @Override
            public void getData(String str) {
                Log.i("aaa","sss"+str);
                JsonParsers(str);
            }
        });
    }

    private void JsonParsers(String str) {
        Gson gson =new Gson();
        Goods fromJson = gson.fromJson(str, Goods.class);
        List<GoodsBean> data = fromJson.getData();
        list.addAll(data);
        myAdapter.notifyDataSetChanged();
        p_listview.onRefreshComplete();
    }

    @Override
    protected void initView() {
    p_listview =fvid(R.id.p_listview);
    p_listview.setMode(PullToRefreshBase.Mode.BOTH);
    p_listview.setScrollingWhileRefreshingEnabled(true);
    p_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            list.clear();

        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

        }
    });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}
