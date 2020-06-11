package com.bbs.controller;

import com.bbs.utils.AliyunOSSUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 上传文件 控制器
 */
@Controller
public class UploadFileController {


    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){
        String uploadUrl = "";
        try {

            if(null != file){
                String filename = file.getOriginalFilename();

                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    uploadUrl = AliyunOSSUtil.upload(newFile);
                    //删除本地临时文件
                    deleteFile(filename);
                }

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "http://image-taogu.oss-cn-shanghai.aliyuncs.com/"+uploadUrl;
    }

    /**
     * 删除本地临时文件
     * @param fileName
     */
    public void deleteFile(String fileName){
        if (fileName != null && fileName != "") {
            File del = new File(fileName);
            del.delete();
        }
    }
}
