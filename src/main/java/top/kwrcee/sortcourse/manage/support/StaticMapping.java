package top.kwrcee.sortcourse.manage.support;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@RequestMapping
public class StaticMapping {

    @RequestMapping("/**/{path}/admin/js/module/dialog.js")
    @ResponseBody
    public String dialogMapping() throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        StringBuffer sb = new StringBuffer();
        readToBuffer(sb, path+"/static/admin/js/module/dialog.js");
        return sb.toString();
    }

    /**
     * 读取字符文件
     *
     * @param buffer
     * @param filePath
     * @throws IOException
     */
    public void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }
}
