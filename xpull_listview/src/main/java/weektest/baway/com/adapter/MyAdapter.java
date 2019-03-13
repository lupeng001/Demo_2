package weektest.baway.com.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import weektest.baway.com.bean.GoodsBean;
import weektest.baway.com.xpull_listview.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsBean> list;

    public MyAdapter(Context context, List<GoodsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item_layout,null);
            viewHolder =new ViewHolder();
            viewHolder.textView1 = convertView.findViewById(R.id.text1);
            viewHolder.imageView1 = convertView.findViewById(R.id.image1);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(list.get(position).getAuthor_name());
        Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(viewHolder.imageView1);
        return convertView;
    }
    class ViewHolder{
        private TextView textView1;
        private ImageView imageView1;
    }
}
