package com.qsh.controller

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 * 文件上传测试
 */
@Slf4j
@RestController
class FileUploadController {

    /**
     * 1.文件上传用MultipartFile对象接收
     * 2.获取表单中文件项，使用注解@RequestPart
     */
    @PostMapping("/upload")
    String upload(
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestPart("headImg") MultipartFile headImg,
            @RequestPart("photos") MultipartFile[] photos
    ) {
        log.info("邮箱：${email}，用户名：${username}")

        //文件处理
        log.info("头像大小：${headImg.getSize()}，上传生活照数量：${photos.length}")

        //将文件存到服务器里
        //注意：headImg一定是一个对象，必须用isEmpty()判断是否为空，直接用headImg判断不出来
        if (!headImg.isEmpty()) {
            String originalFilename = headImg.getOriginalFilename()
            headImg.transferTo(new File("D:\\StudyProjects\\temp\\${originalFilename}"))
        }

        if (photos.length > 0) {
            for (it in photos) {
                if (!it.isEmpty()) {
                    String originalFilename = it.getOriginalFilename()
                    Long size = it.getSize()
                    it.transferTo(new File("D:\\StudyProjects\\temp\\${originalFilename}"))
                }
            }
        }

        return "上传文件成功了！"
    }
}
