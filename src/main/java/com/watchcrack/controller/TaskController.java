package com.watchcrack.controller;

import com.hebtu.entity.*;
import com.hebtu.utils.FtpUtil;
import com.hebtu.utils.LogUtils;
import com.hebtu.utils.ZIPUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TaskController extends BaseController{
    private Logger logger = LogUtils.getInstance(TaskController.class);
    @GetMapping("/ctask")
    public String ctask(Map<String, Object> map){
        if (loginUser!=null&&loginUser.getGroupId()>=2) {
            List<Task> tasks = taskService.queryAll(Task.builder().createUserId(loginUser.getUserId()).build());
            FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
            List<College> colleges = collegeService.queryAll();
            List<Major> majors  = majorService.queryAll();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            Integer year=new Integer(sdf.format(date));
            Integer grade[] = new Integer[5];
            for (int i = 0; i < grade.length; i++) {
               grade[i]= year-i;
            }
            map.put("grade",grade);
            map.put("colleges",colleges);
            map.put("majors",majors);
            map.put("statistics", statistics);
            map.put("tasks", tasks);
            return "u-admin/ctask";
        }else {
            return "forward:/";
        }
    }
    /**
     * @Description 创建一个Task
     *
     */
    @GetMapping("/createTask")
    public void creatTask(@RequestParam("taskName") String taskName, @RequestParam("grade") String grade, @RequestParam(required = false) Integer major, @RequestParam(required = false) String notice, @RequestParam(required = false) Integer deadtime) {
        //权限判断
        if(loginUser.getGroupId()>=2){
            try {
                //同年级同班同学
                List<Integer> userIds = userService.queryByGrade(grade,major);
                //创建作业
                if(notice==null||notice=="")
                {notice= "没有通知";}
                //这个时间没设置好
                Task task = Task.builder().createUserName(loginUser.getUserName()).createUserId(loginUser.getUserId()).taskName(taskName)
                        .notice(notice).deadTime(getDay(deadtime)).build();
                logger.info(task.toString());
                if (taskService.insert(task)) {
                    logger.info("作业创建成功"+task);
                    //给学生添加作业
                    for (int i = 0; i < userIds.size(); i++) {
                        Integer userId = userIds.get(i);
                        taskUserService.insert(TaskUser.builder().taskId(task.getTaskId()).userId(userId).build());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                logger.info("创建作业失败了");
            }
        }
    }
    /**
     * @Description 查看我的task
     *
     */
    @GetMapping("/task")
    public String toTaskPage(Map<String, Object> map) {
        //我的作业
        List<TaskUser> mytask = taskUserService.queryByUserId(loginUser.getUserId());
        //通过tasks获取作业详情
        HashSet<Integer> taskIds  =new HashSet<>();
        List<Task> tasks =new ArrayList<>();
        for (int i = 0; i < mytask.size(); i++) {
            Integer taskId =  mytask.get(i).getTaskId();
            taskIds.add(taskId);
        }
        for (Integer taskId : taskIds) {
            tasks.add(taskService.queryByTaskId(taskId));
        }
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("tasks",tasks);
        return "u-admin/task";
    }

    /**
     * @Description 根据taskid 查询当前task下已经上传了什么文件。
     */
    @GetMapping("/task-files")
    public String toTaskPage(Integer taskId, Map<String, Object> map) {
        //查询我的当前taskid下的作业
        List<TaskUser> taskUser = taskUserService.queryAll(TaskUser.builder()
                .userId(loginUser.getUserId()).taskId(taskId).build());
        logger.info(taskUser.toString());
        //查询出fildId，并放入该列表中
        List<Integer> fileIds = new ArrayList<>();
        for (TaskUser taskfile : taskUser) {
            Integer fileId= taskfile.getMyFileId();
            if (fileId!=null) {
                fileIds.add(fileId);
            }
        }
        //再根据具体fileId查询出具体文件
        List<MyFile> files = new ArrayList<>();
        for (Integer fileId : fileIds) {
            files.add(myFileService.getFileByFileId(fileId));
        }
        Task task = taskService.queryByTaskId(taskId);
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("statistics", statistics);
        map.put("files",files);
        map.put("task",task);
        logger.info("files:"+files.size());
        return "u-admin/task-files";
    }
    @GetMapping("/ctask-files")
    public String toCTaskPage(Integer taskId, Map<String, Object> map) {
        //权限判断
        Task task = taskService.queryByTaskId(taskId);
        if (!task.getCreateUserId().equals(loginUser.getUserId())){
            return "redirect:/index";
        }
        //查询我的当前taskid下的作业
        List<TaskUser> taskUser = taskUserService.queryByTaskId(taskId);
        //查询出fildId，并放入该列表中
        List<TaskFile> files = new ArrayList<>();
        List<User> noUpUser = new ArrayList<>();
        for (TaskUser taskfile : taskUser) {
            Integer fileId= taskfile.getMyFileId();
            if (fileId!=null) {
                files.add(TaskFile.builder().file(myFileService.getFileByFileId(fileId))
                        .user(userService.queryById(taskfile.getUserId())).build());
            }else {
                noUpUser.add(userService.queryById(taskfile.getUserId()));
            }
        }
        FileStoreStatistics statistics = myFileService.getCountStatistics(loginUser.getFileStoreId());
        map.put("noUpUser",noUpUser);
        map.put("statistics", statistics);
        map.put("files",files);
        map.put("task",task);
        return "u-admin/ctask-files";
    }


    /**
     * @Description 作业上传页面
     * @Author ylj
     * @Date 15:16 2020/4/21
     * @Param taskId
     * @return java.lang.String
     **/
    @PostMapping("/uploadTaskFile")
    @ResponseBody
    public Map<String, Object> uploadTaskFile(@RequestParam("file") MultipartFile files,Integer taskid) {
        Map<String, Object> map = new HashMap<>();
        FileStore store = fileStoreService.getFileStoreByUserId(loginUser.getUserId());
        Integer folderId  = fileFolderService.getMyTaskFolderId(store.getFileStoreId());
        //Integer taskid = Integer.valueOf(request.getHeader("taskid"));
        String name = files.getOriginalFilename().replaceAll(" ","");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        String path = loginUser.getUserId()+"/"+dateStr +"/"+folderId;
        Integer sizeInt = Math.toIntExact(files.getSize() / 1024);
        //是否仓库放不下该文件
        if(store.getCurrentSize()+sizeInt > store.getMaxSize()){
            logger.error("上传失败!仓库已满。");
            map.put("code", 503);
            return map;
        }
        //处理文件大小
        String size = String.valueOf(files.getSize()/1024.0);
        int indexDot = size.lastIndexOf(".");
        size = size.substring(0,indexDot);
        int index = name.lastIndexOf(".");
        String tempName = name.substring(index);
        name = name.substring(0,index);
        //获得文件类型
        int type = getType(tempName.toLowerCase());
        String postfix = tempName.toLowerCase();
        try {
            //提交到FTP服务器
            boolean b = FtpUtil.uploadFile("/"+path, name + postfix, files.getInputStream());

            if (b){
                //上传成功
                logger.info("文件上传成功!"+files.getOriginalFilename());
                //删除空文件记录
                taskUserService.deleteKong(taskid,loginUser.getUserId());
                //向数据库文件表写入数据
                MyFile taskfile=MyFile.builder()
                        .myFileName(name).fileStoreId(loginUser.getFileStoreId()).myFilePath(path)
                        .downloadTime(0).uploadTime(new Date()).parentFolderId(folderId).
                                size(Integer.valueOf(size)).type(type).postfix(postfix).build();
                myFileService.addFileByFileStoreId(taskfile);
                //更新仓库表的当前大小
                fileStoreService.addSize(store.getFileStoreId(),Integer.valueOf(size));
                //向Taskuser里面写入当前的文件id
                taskUserService.insert(TaskUser.builder().taskId(taskid).userId(loginUser.getUserId())
                        .myFileId(taskfile.getMyFileId()).build());
                try {
                    Thread.sleep(5000);
                    map.put("code", 200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                logger.error("文件上传失败!"+files.getOriginalFilename());
                map.put("code", 504);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    public int getType(String type){
        if (".txt".equals(type)||".doc".equals(type)||".docx".equals(type)
                ||".wps".equals(type)||".word".equals(type)||".html".equals(type)||".pdf".equals(type)){
            return  1;
        }else if (".bmp".equals(type)||".gif".equals(type)||".jpg".equals(type)
                ||".pic".equals(type)||".png".equals(type)||".jepg".equals(type)||".webp".equals(type)
                ||".svg".equals(type)){
            return 2;
        } else if (".avi".equals(type)||".mov".equals(type)||".qt".equals(type)
                ||".asf".equals(type)||".rm".equals(type)||".navi".equals(type)||".wav".equals(type)
                ||".mp4".equals(type)){
            return 3;
        } else if (".mp3".equals(type)||".wma".equals(type)){
            return 4;
        } else {
            return 5;
        }
    }

    @GetMapping("/downloadTaskAll")
    public void downloadTask(@RequestParam Integer taskId) throws Exception {
        //权限判断
        Task task = taskService.queryByTaskId(taskId);
        if (!task.getCreateUserId().equals(loginUser.getUserId())){
            return ;
        }
        //ftp:文件的目录
        String  tempFTP="/root/temp/"+taskId+"/";
        //zip的目录
        String  zipfolder= "/root/zip/";
        //查询我的当前taskid下的作业
        List<TaskUser> taskUser = taskUserService.queryByTaskId(taskId);
        //查询出fildId，并放入该列表中
        List<MyFile> files = new ArrayList<>();
        for (TaskUser taskfile : taskUser) {
            Integer fileId= taskfile.getMyFileId();
            if (fileId!=null) {
                files.add(myFileService.getFileByFileId(fileId));
            }
        }
        //开始下载到本地文件夹中temp
        for (MyFile myFile : files) {
           String remotePath = myFile.getMyFilePath();
            String fileName = myFile.getMyFileName()+myFile.getPostfix();
            try {
                File temp= new File(tempFTP);
                if (!temp.exists()){
                    temp.mkdir();
                }
               //去FTP上拉取
               boolean flag = FtpUtil.downloadFile("/" + remotePath,
                       fileName,tempFTP+fileName
               );
               if (flag) {
                    myFileService.updateFile(
                            MyFile.builder().myFileId(myFile.getMyFileId()).downloadTime(myFile.getDownloadTime() + 1).build());
                    logger.info("文件下载成功!" + myFile);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String zipfile=zipfolder+task.getTaskName()+".zip";
        ZIPUtil.packToolFiles(tempFTP,zipfile);
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(task.getTaskName()+".zip", "UTF-8"));
        File file = new File(zipfile);
        FileInputStream fin = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int i = -1;
        while ((i = fin.read(buffer)) != -1){
            os.write(buffer, 0, i);
        }
        fin.close();
        os.close();
        deleteDir(tempFTP);
        deleteDir(zipfile);
    }
    @GetMapping("/deleteTask")
    public String deleteTask(Integer taskId){
        taskService.deleteById(taskId);
        taskUserService.deleteByTaskId(taskId);
        return "redirect:/ctask";
    }

    public static Date getDay(Integer day) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        date = calendar.getTime();
        return date;
    }
    public static void deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if(file.isFile())
        {
            file.delete();
        }else
        {
            File[] files = file.listFiles();
            if(files == null)
            {
                file.delete();
            }else
            {
                for (int i = 0; i < files.length; i++)
                {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }




}
