package com.liuchq.Moxy.utils;

import com.alibaba.fastjson.JSONObject;
import com.liuchq.Moxy.constant.MyConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: liuchq
 * @date: 2021/5/21 15:16
 * @description: 学习工具类
 */
public class MyUtils {

    private static final Logger logger = LogManager.getLogger("MyUtils");

    /**
     * 开始请求学习
     *
     * @author: liuchq
     * @date: 2021/5/21 15:17
     * @param imageUrl
     * @return: java.lang.String
     */
    public static String requestMoHttp(String imageUrl){
        String str = "";
        try {
            logger.info("开始请求moxueyuan---"+imageUrl);
            URL url = new URL(imageUrl);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            OutputStreamWriter out = null;
            //请求方式
            conn.setRequestMethod("POST");
            //设置通用的请求属性
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Connection", "Keep-Alive");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            //发送请求参数即数据
            out.write("");
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            str = br.readLine();
            if (str != null) {
                logger.info("返回值---"+str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
        }catch (Exception e){
            logger.error("请求moxueyuan出错---"+e.getMessage(),e);
        }
        return str;
    }

    /**
     * 组装参数
     * @author: liuchq
     * @date: 2020/9/8 19:03
     * @param userID 用户ID
     * @param token
     * @param eid
     * @param version  魔学院版本
     * @param courseID   课程ID
     * @param chapterID     课程ID
     * @return: java.util.Map<java.lang.String, java.lang.String>
     */
    public static Map<String, String> setParam(String userID, String token, String eid,
                                               String version, String courseID, String chapterID){
        Map<String,String> map = new HashMap<>();
        map.put("platform","pcweb");
        map.put("completed","1");
        map.put("percent","0.5");
        map.put("durgress","60");
        map.put("cumtime","60");
        map.put("usePlaybackRates","1");

        map.put("userid",userID);
        map.put("token",token);
        map.put("eid",eid);
        map.put("version",version);
        map.put("courseid",courseID);
        map.put("chapterid",chapterID);

        logger.info("setParam组装参数成功：");
        return map;
    }

    /**
     * 拼接URL
     * @author: liuchq
     * @date: 2020/9/8 19:04
     * @param url    初始地址
     * @param map     请求参数
     * @return: java.lang.String 拼接好的URL
     */
    public static String urlMakeUp(String url,Map<String,String> map){
        StringBuilder urlSB = new StringBuilder(url);

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            urlSB.append("&").append(key).append("=").append(map.get(key));
        }
        logger.info("urlMakeUp拼接URL成功："+urlSB.toString());
        return  urlSB.toString();
    }

    /**
     * 获取UUID
     * @author: liuchq
     * @date: 2021/5/26 10:56
     * @param
     * @return: java.lang.String
     */
    public static String getUUid(){
        return java.util.UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
