package com.anytec.sdproperty.controller;

/**
 * Created by xuxinjian on 17/9/18.有效
 */

import com.anytec.sdproperty.config.GeneralConfig;
import com.anytec.sdproperty.util.NUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/upload")
public class UploadImage {
    private static final Logger logger = LoggerFactory.getLogger(UploadImage.class);
    File tempPathFile;
    @Autowired
    GeneralConfig config;
    /**
     * upload image and return the image url
     *
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
//    @RequestMapping("uploadimage.do")
//    @ResponseBody
//    public String uploadImage(HttpServletRequest request,
//                                           HttpServletResponse response, HttpSession session,
//                                           @RequestParam(value = "file", required = true) MultipartFile file)
//            throws IllegalStateException, IOException {
//        logger.info("uploadImage begin");
//        String path = session.getServletContext().getRealPath("/upload");
//        System.out.println("real path: " + path);
//        String fileName = file.getOriginalFilename();
//        System.out.println("file name: " + fileName);
//        File targetFile = new File(path, fileName);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//        file.transferTo(targetFile);
//        String fileUrl = request.getContextPath() + "/upload/" + fileName;
//
//        logger.info("uploadImage success: " + fileUrl);
//        return fileUrl;
//    }

//    @RequestMapping("uploadimage.do")
//    @ResponseBody
//    public Map<String, String> uploadImage(HttpServletRequest request,
//                                           HttpServletResponse response, HttpSession session,
//                                           @RequestParam(value = "file", required = true) MultipartFile file)
//            throws IllegalStateException, IOException {
//        Map<String, String> map = new HashMap<String, String>();
//
//        logger.info("uploadImage begin");
//
//        String path = session.getServletContext().getRealPath("/upload/");
//        String fullPath = path;
//        logger.info("real path: " + path);
//        String fileName = file.getOriginalFilename();
//        fileName = NUtil.makeFilename(fileName);
//        fullPath += "/" + fileName;
//        logger.info("fullPath: " + fullPath);
//        File targetFile = new File(path, fileName);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//        file.transferTo(targetFile);
//        String fileUrl = request.getContextPath() + "/upload/" + fileName;
//
//        map.put("url", fileUrl);
//        map.put("path", path + fileName);
//
//        logger.info("uploadImage success: " + fileUrl);
//        return map;
//    }

    @RequestMapping("uploadimage.do")
    @ResponseBody
    public Map<String, String> uploadImage(HttpServletRequest request,
                                           HttpServletResponse response, HttpSession session)
            throws IllegalStateException, IOException {
        Map<String, String> map = new HashMap<String, String>();

        logger.info("开始上传单张图片");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte =
        // 1kb 1024kb=1M 1024M = 1G
        upload.setHeaderEncoding("utf-8");
        try {
            List<FileItem> list = upload.parseRequest(request);
            if(list.size() == 0 ){
                logger.info("未获取到上传的图片信息");
                return null;
            }
            for(FileItem item : list){
                if(!item.isFormField()){
                    String fileName = item.getName();
                    logger.info("filename:"+fileName);
                    fileName = NUtil.makeFilename(fileName);
                    logger.info("newfilename:"+fileName);
//                    String path = session.getServletContext().getRealPath("/upload/");
                    String path= config.getUpload_path();
                    logger.info("path:"+ path);
                    File pathFile =new File(path);
                    if(!pathFile.exists()){
                        pathFile.mkdirs();
                    }
                    File file = new File(path+fileName);
                    item.write(file);
//                    String fileUrl = request.getContextPath() + "/upload/" + fileName;
                    String fileUrl =  "/upload/" + fileName;
                    map.put("url", fileUrl);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("uploadimages.do")
    @ResponseBody
    public Map<String, List<String>> uploadImages(HttpServletRequest request,
                                                  HttpServletResponse response, HttpSession session)
            throws IllegalStateException, IOException {
        logger.info("开始上传图片文件夹");
        Map<String, List<String>> map = new HashMap<>();
        List<String> pathList =new ArrayList<>();
//        String path = session.getServletContext().getRealPath("/upload/");
        String path = config.getUpload_path();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
        factory.setRepository(tempPathFile);// 设置缓冲区目录
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;// 得到所有的文件
        try {
            items = upload.parseRequest(request);
            Iterator<FileItem> i = items.iterator();
            while (i.hasNext()) {
                FileItem fi = i.next();
                File fileForName = new File(fi.getName());
                String fileName = fileForName.getName();
                logger.info("filename:"+fileName);
                String newFileName = NUtil.makeFilename(fileName);
                logger.info("newfilename:"+newFileName);
                if (fileName != null) {
                    String filePath = path + newFileName;
                    File savedFile = new File(filePath);
                    logger.info("filepath:"+path);
                    File pathFile = new File(path);
                    if (!pathFile.exists()) {
                        pathFile.mkdirs();
                    }
                    fi.write(savedFile);
                    String personName=fileName.split("\\.")[0];
                    String fileUrl =  "/upload/" + newFileName+"#.pn#"+personName;
//                    String fileUrl = request.getContextPath() + "/upload/" + newFileName+"#.pn#"+personName;
                    pathList.add(fileUrl);
                }
            }
            System.out.print("upload succeed");
        } catch (Exception e) {
// 可以跳转出错页面
            e.printStackTrace();
        }
        map.put("imagePathList",pathList);
        return map;
    }
}
