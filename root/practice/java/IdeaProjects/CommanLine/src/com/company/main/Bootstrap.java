package com.company.main;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

/**
 * Created by Galapagos on 2016/5/6.
 */
public class Bootstrap {
    public static void main(String args[]){

        Bootstrap htmlToWord=new Bootstrap();
        try {
            htmlToWord.htmlToWord2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ok");

    }

    public void htmlToWord2() throws Exception {
        InputStream bodyIs = new FileInputStream("E:\\pd\\bootstrap.html");
        /*InputStream cssIs = new FileInputStream("f:\\1.css");*/
        String body = this.getContent(bodyIs);
        StringBuffer html=new StringBuffer();
        html.append("<html><head><base href=\"http://www.runoob.com/try/demo_source/\" target=\"_blank\">\n" +
                "<style type=\"text/css\">");


        int i;
        InputStream inputStream=new FileInputStream(new File("e:/pd/bootstrap.css"));
        while((i=inputStream.read())!=-1){

            html.append((char)i);

        }
        html.append("</style></head><body>");

        html.append(body);

        html.append("</body></html>");
        OutputStream outputStream=new FileOutputStream(new File("e:/pd/bootstrap.txt"));
        outputStream.write(html.toString().getBytes());
       /* String css = this.getContent(cssIs);*/
        //拼一个标准的HTML格式文档
       /* String content = "<html><head><style>" + css + "</style></head><body>" + body + "</body></html>";*/
        InputStream is = new ByteArrayInputStream(html.toString().getBytes("gbk"));
        OutputStream os = new FileOutputStream("E:\\pd\\bootstrap.doc");
        this.inputStreamToWord(is, os);
    }

    /**
     * 把is写入到对应的word输出流os中
     * 不考虑异常的捕获，直接抛出
     * @param is
     * @param os
     * @throws IOException
     */
    private void inputStreamToWord(InputStream is, OutputStream os) throws IOException {
        POIFSFileSystem fs = new POIFSFileSystem();
        //对应于org.apache.poi.hdf.extractor.WordDocument
        fs.createDocument(is, "WordDocument");
        fs.writeFilesystem(os);
        os.close();
        is.close();
    }

    /**
     * 把输入流里面的内容以UTF-8编码当文本取出。
     * 不考虑异常，直接抛出
     * @param ises
     * @return
     * @throws IOException
     */
    private String getContent(InputStream... ises) throws IOException {
        if (ises != null) {
            StringBuilder result = new StringBuilder();
            BufferedReader br;
            String line;
            for (InputStream is : ises) {
                br = new BufferedReader(new InputStreamReader(is, "gbk"));
                while ((line=br.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        }
        return null;
    }
}
