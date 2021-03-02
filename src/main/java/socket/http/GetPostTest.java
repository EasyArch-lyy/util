package socket.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {

    /**
     * 向指定URL发送GET请求
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL resultUrl = new URL(urlName);
            // 打开和URL之间的连接
            URLConnection conn = resultUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Kepp-ALive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0; Windows NT 5.1; SV1)");
            // 建立实际的连接
            conn.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            try (
                    // 定义BufferedReader输入流来读取URL的响应
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (IOException e) {
            System.out.println("发送GET请求出现异常!"+e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 向指定URL发送POST方法请求
     */
    public static String sendPost(String url, String param) {
        String result = "";
        try {
            URL realURL = new URL(url);
            URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try(
                    // 获取URLConnection对象对应的输出流
                    PrintWriter out = new PrintWriter(conn.getOutputStream())){
                out.print(param);
                out.flush();
            }
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {

                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = GetPostTest.sendGet("http://localhost:8080/abc/a.jsp", null);
        System.out.println(s);
        String s1 = GetPostTest.sendPost("http://localhost:8080/abc/login.jsp", "name=xxx&pass=xxx");
        System.out.println(s1);
    }
}
