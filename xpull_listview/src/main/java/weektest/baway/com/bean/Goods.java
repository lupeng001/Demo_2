package weektest.baway.com.bean;

import java.util.List;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Goods {
    private List<GoodsBean> data;

    public Goods(List<GoodsBean> data) {
        this.data = data;
    }

    public List<GoodsBean> getData() {
        return data;
    }

    public void setData(List<GoodsBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "data=" + data +
                '}';
    }
}
