package com.watchcrack.controller;

import com.hebtu.entity.FileFolder;
import com.hebtu.entity.FileStore;
import com.hebtu.entity.User;
import com.hebtu.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录控制器
 * @Author xw
 * @Date 18:19 2020/2/25
 * @Param  * @param null
 * @return
 **/
@Controller
public class LoginController extends BaseController {

    private Logger logger = LogUtils.getInstance(LoginController.class);
    @PostMapping("/login")
    public String login(String studentId , String password){
        User user = null;
        user = userService.queryByStudentId(studentId);
        if(user != null && new String(user.getPwd()).equals(new String(DigestUtils.md5Digest(password.getBytes()))) ) {
            session.setAttribute("loginUser", user);
            return "redirect:/index";
        }else {
            //error= "账号密码错误";
            logger.info("账号密码错误");
            return "index";
        }
    }
    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String regist(String StudentId ,String password ){
        //根据表单提交的用户名，查询是否含有该用户
        //设置用户信息
        User user = userService.queryByStudentId(StudentId);
        if (user == null){
            user = User.builder().studentId(StudentId).userName("游客").pwd(DigestUtils.md5Digest(password.getBytes())).groupId(1).build();
            if (userService.insert(user)){
                logger.info("注册用户成功！当前注册用户" + user);
                FileStore store = FileStore.builder().userId(user.getUserId()).build();
                if (fileStoreService.addFileStore(store) == 1){
                    user.setFileStoreId(store.getFileStoreId());
                    userService.update(user);
                    logger.info("注册仓库成功！当前注册仓库" + store);
                    //同时创建一个作业文件夹
                    fileFolderService.addFileFolder(FileFolder.builder().fileFolderName("已提交的作业")
                            .fileStoreId(store.getFileStoreId()).time(new Date()).parentFolderId(0).build());
                }
                session.setAttribute("loginUser",user);
                return "redirect:/index";
            } else {
                logger.info("注册用户失败！");
                //map.put("error","账号注册失败");
            }
        }else {
            //账号已经存在
            logger.info("账号已经存在！");
            //map.put("error","账号已经存在");
        }
        return "forward:/login";
    }
    @GetMapping("/logout")
    public String logout() {
        logger.info("用户退出登录！");
        session.invalidate();
        return "redirect:/";
    }

}
