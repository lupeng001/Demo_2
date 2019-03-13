package weektest.baway.com.util;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyUtil {
    public static String getWord(String url){
        try {
            URL url1 =new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            int code = connection.getResponseCode();
            if (code==200){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String bt1 = "";
                String bt2 = "";
                while ((bt1= reader.readLine())!=null){
                    bt2+=bt1;
                }
                return bt2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public interface MyScank{
        void getData(String str);
    }
    public static void MyTask(String url, final MyScank myScank){
        new AsyncTask<String,Void,String>(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                myScank.getData(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                return MyUtil.getWord(strings[0]);
            }
        }.execute(url);
    }
}
