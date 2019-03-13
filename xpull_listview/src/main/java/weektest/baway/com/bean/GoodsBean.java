package weektest.baway.com.bean;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class GoodsBean {
    private String author_name;
    private String thumbnail_pic_s;

    public GoodsBean(String author_name, String thumbnail_pic_s) {
        this.author_name = author_name;
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "author_name='" + author_name + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                '}';
    }
}
