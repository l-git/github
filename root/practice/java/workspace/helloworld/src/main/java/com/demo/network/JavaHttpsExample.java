package com.demo.network;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class JavaHttpsExample
{

    public static void main(String[] args) throws Exception {
    	
    	
    	//Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",8888));
        String httpsURL = "";
        URL myUrl = new URL(httpsURL);
        HttpURLConnection conn = (HttpURLConnection)myUrl.openConnection();
        
        
       // conn.setRequestProperty("cookie", "pgv_pvi=7033464832; RK=HCljFwU7s9; pgv_pvid=3046721478; o_cookie=2367739262; pac_uid=1_2367739262; ptisp=ctc; ptcz=838358a48dc5d2430124d8069c521951e8cdc15ef4dfc2316d9a7de06a3ad166; uin=o2367739262; skey=@dVOdbWOYv; pt2gguin=o2367739262; p_uin=o2367739262; pt4_token=ZLyxdqFuS0nWuNvcBa1IIZyQGyOs8C19oIBLW-dqfPg_; p_skey=od-w8puRlhdCT9XMvVXo0iEbCGGvNRMiRnWZVR8Q4UY_; wimrefreshrun=0&; qm_antisky=-1927228034&c8020e7589e72f427395f76e228fc6ae00022decae8d89a53feb20cf508b0a90; qm_flag=0; qqmail_alias=2367739262@qq.com; sid=-1927228034&e926bdb192db7a5c2d8aba2eee0920b8,qb2QtdzhwdVJsaGRDVDlYTXZWWG8waUViQ0dHdk5STWlSbldaVlI4UTRVWV8.; qm_username=2367739262; qm_lg=qm_lg; qm_domain=https://mail.qq.com; qm_ptsk=-1927228034&@dVOdbWOYv; foxacc=-1927228034&0; ssl_edition=sail.qq.com; edition=mail.qq.com; qm_loginfrom=-1927228034&clientread; username=-1927228034&2367739262; CCSHOW=000001; new_mail_num=-1927228034&0; webp=1");
        
        
        System.out.println(conn.getResponseCode());
        
        
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }

        br.close();
    }

}
