package dhcc.com.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangpenghui on 2019/12/3
 */
public class getHtmlInfo{

    private static int chapter = 0;

    private static String getHTMLContent( String url, String charset) throws IOException {
        //建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //使用HttpGet方式请求网址
        HttpGet httpGet = new HttpGet(url);
        //获取网址的返回结果
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //获取返回结果中的实体
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        //关闭HttpEntity流
        EntityUtils.consume(entity);
        //EntityUtils.toString默认使用ISO-8859-1解析成字符串，但是乱码，需要用ISO-8859-1重新解析会字节码，再通过charset解析成正确的字符串
        content = new String(content.getBytes("ISO-8859-1"),charset);
        //System.out.println(content);
        return content;
    }


    public static void getHospitalInfo(String url, String encoding) {
        chapter++;
        FileWriter fw = null;
        BufferedWriter bw = null;
        org.jsoup.nodes.Document document = null;
        try {
            System.out.println("获取第"+chapter+"章节");
            fw = new FileWriter("D:\\aa.txt", true);
            bw = new BufferedWriter(fw);
            String html = getHTMLContent(url, encoding);
            document = Jsoup.parse(html);
            //org.jsoup.nodes.Document document = Jsoup.parse(url); //测试
            Elements elements = document.select("div[class=noveltext]");
            String text = elements.text().toString();
            int beginIndex = text.indexOf("查看收藏列表");
            int endIndex = text.indexOf("插入书签");
            String subText = "";
            if(beginIndex >0 && endIndex>beginIndex){
                subText = text.substring(beginIndex+10, endIndex);
            }
            subText = subText.equals("")? text : subText;
            //匹配非连接英语单词的空格，进行切割换行
            String[] strArray = subText.split("\\s[^A-Za-z]");
            for(String str : strArray){
                if(!str.equals("")){
                    bw.write(str);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Elements links  = document.select("td[height=30].noveltitle a");
        System.out.println(links.toString());
        String linkHref = "";
        int num = 0;
        for (org.jsoup.nodes.Element link : links) {
            linkHref = link.attr("href");
            System.out.println(linkHref);
            num++;

            if(chapter == 1){ //获取第一章
                getHospitalInfo("http://www.jjwxc.net/"+linkHref, encoding);
            }else if(!linkHref.equals("") && num != 1){ //跳过上一章a标签
                getHospitalInfo("http://www.jjwxc.net/"+linkHref, encoding);
            }
        }

    }

    public  static void main(String[] args) throws IOException {
        /*StringBuffer sb = new StringBuffer();
        FileReader fr = new FileReader("d:\\aaa.txt");
        BufferedReader br = new BufferedReader(fr);
        String str = "";
        while((str = br.readLine()) != null) {
            sb.append(str + "\n");
        }
        String htmlstr = sb.toString();
        getHospitalInfo(htmlstr, "");
        fr.close();
        br.close();*/
        getHospitalInfo("http://www.jjwxc.net/onebook.php?novelid=25448&chapterid=1", "gb2312");
        System.out.println("爬取成功");
    }
}
