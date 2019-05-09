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
    //工具类，用来解决部分js加载不成功的问题
    private final String dialog="layui.define(['jquery', 'layer'], function (exports) {\n" +
            "        var $ = layui.jquery;\n" +
            "        var layer = layui.layer;\n" +
            "        var dialog = {\n" +
            "            /*确认框*/\n" +
            "            confirm: function (jsonData) {\n" +
            "                layer.confirm(jsonData.message, {\n" +
            "                    btn: ['确定', '取消'],\n" +
            "                    shade: [0.1, '#fff']\n" +
            "                }, function () {\n" +
            "                    jsonData.success && jsonData.success();\n" +
            "                }, function () {\n" +
            "                    jsonData.cancel && jsonData.cancel();\n" +
            "                });\n" +
            "            },\n" +
            "            page: function (title, url, w, h) {\n" +
            "                if (title == null || title == '') {\n" +
            "                    title = false;\n" +
            "                }\n" +
            "                ;\n" +
            "                if (url == null || url == '') {\n" +
            "                    url = \"404.html\";\n" +
            "                }\n" +
            "                ;\n" +
            "                if (w == null || w == '') {\n" +
            "                    w = '700px';\n" +
            "                }\n" +
            "                ;\n" +
            "                if (h == null || h == '') {\n" +
            "                    h = '350px';\n" +
            "                }\n" +
            "                ;\n" +
            "                var index = layer.open({\n" +
            "                    type: 2,\n" +
            "                    title: title,\n" +
            "                    area: [w, h],\n" +
            "                    fixed: false, //不固定\n" +
            "                    maxmin: true,\n" +
            "                    content: url\n" +
            "                });\n" +
            "            },\n" +
            "            /**\n" +
            "\t\t\t * 提示\n" +
            "\t\t\t * @param title\n" +
            "\t\t\t * @param obj\n" +
            "\t\t\t */\n" +
            "\t\t\ttips: function(title, obj) {\n" +
            "\t\t\t\tlayer.tips(title, obj, {\n" +
            "\t\t\t\t\ttips: [1, '#444c63'], //还可配置颜色\n" +
            "\t\t\t\t\ttime: 1000\n" +
            "\t\t\t\t});\n" +
            "\t\t\t}\n" +
            "        };\n" +
            "        //输出test接口\n" +
            "        exports('dialog', dialog);\n" +
            "    }\n" +
            ");\n";
    @RequestMapping("/**/{path}/admin/js/module/dialog.js")
    @ResponseBody
    public String dialogMapping() throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        StringBuffer sb = new StringBuffer();
        //readToBuffer(sb, path+"/static/admin/js/module/dialog.js");
        return dialog;
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
