# workpan

### 首先
这是一个基于moti-cloud网盘的一个二次开发

### 注意
拉取项目到本地后，你需要修改一下配置信息

- `application.yml`：修改数据源信息
- `config.DruidConfig`：修改druid登录的用户名和密码
- `utils.FtpUtil`：修改FTP服务器的基本信息

### 项目主要功能
- 文件的管理，上传、下载、重命名、删除、查看统计数据、分类管理等。
- 文件夹的管理，创建、删除、重命名。
- 文件的分享，支持通过链接和二维码的分享方式。
- 作业的创建、上传、批量下载、以及查看未交
### 使用哪些技术

#### 前端

- HTML、CSS、JavaScript、JQuery
- BootStrap以及多个插件
- 提交作业的那个页面使用了elementUI组件
#### 后端

- SpringBoot + MyBatis
- ThymeLeaf 模板引擎
- Ftp工具类、二维码工具类

#### 部署

- xx云轻量应用服务器
- Docker 环境
- FTP 服务
- MySQL 数据库

### 福利

[Docker搭建FTP服务](https://www.bilibili.com/video/av87259459)

[使用Docker部署SpringBoot应用](https://www.bilibili.com/video/av88690709)

### 欢迎关注原作者的B站账号

[我是莫提](https://space.bilibili.com/301320288)

[我的个人博客](http://xuewei.world)

有什么问题也可以联系我本人：[QQ](1102624408)

### 写在最后

- 这个是我在原作者的基础上加了一个作业功能的模块。项目看起来更大了。
所以推荐去看原作者的代码，如果也想在我的基础上再次开发，可以参考下我的代码

- 代码有很多不规范之处。同时呢，我个人认为这个项目的DAO层应该使用JPA会更加适合，
毕竟项目简单。然后我已经把邮件模块加入了，但是没用应用到项目之中去，有兴趣可以加入哦
