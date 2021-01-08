package com.njtech.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @autor jianz
 * @create 2021-01-07 23:41
 * @desc
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/servlet/upload.do"})
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 保存返回结果
        Map<String, String> ret = new HashMap<>();

        String uploadPath = req.getServletContext().getRealPath("upload/");
        // 判断文件夹是否存在
        File savePath = new File(uploadPath);
        if (!savePath.exists()) {
            // 不存在则创建目录
            savePath.mkdir();
        }

        // 判断文件表单格式
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(req);
                boolean isFound = false;
                for (FileItem item : fileItems) {
                    if (!item.isFormField()) {// 文件字段
                        // 获取文件名称，使用uuid+文件名，防止重名替换
                        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + item.getName();
                        // TODO: 判断文件大小与文件类型
                        // 图片后缀
                        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                        long size = item.getSize();
                        if(!(".jpg".equals(fileSuffix)||".jfif".equals(fileSuffix))){
                            ret.put("type", "error");
                            ret.put("msg", "请上传图片！");
                            break;
                        }
                        if(size > 10*1024*1024){
                            ret.put("type", "error");
                            ret.put("msg", "上传图片太大，请上传小于10M的图片！");
                            break;
                        }
                        File tempFile = new File(fileName);
                        File saveFile = new File(uploadPath, tempFile.getName());
                        // 保存文件
                        item.write(saveFile);
                        ret.put("type", "success");
                        ret.put("msg", "图片上传成功");
                        ret.put("filePath", req.getServletContext().getContextPath() + "/upload/");
                        ret.put("fileName", fileName);
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    ret.put("type", "error");
                    ret.put("msg", "请选择要上传的文件！");
                }
            } catch (Exception e) {
                ret.put("type", "error");
                ret.put("msg", "上传图片出现异常：" + e.getMessage());
            }
        } else {
            ret.put("type", "error");
            ret.put("msg", "上传格式有误！");
        }
        // 格式化输出结果
        String sRet = JSON.toJSONString(ret);
        resp.setContentType("text/html;charset=utf-8");
        // 返回结果给客户端
        PrintWriter out = resp.getWriter();
        out.print(sRet);
        out.close();
    }
}
