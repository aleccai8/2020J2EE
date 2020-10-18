# 2020 大连理工大学J2EE大作业

#### 如果觉着有用可以点个star

## 目录说明
* homework1-5分别对应1-5次上机作业
* database.sql 为作业中使用的数据库DDL语句

## 使用技术
* 第一二次作业使用POI进行Excel解析，使用HttpServlet进行请求处理
* 第三到五次大作业使用Springboot，无前端，使用postman+网页websocket调试器进行调试
* 使用maven进行包管理，在启动前请执行maven install命令


## 启动方法
* 第一二次作业使用IDEA导入项目，并且配置tomcat自动启动即可
* 三到五次作业请启动对应项目中的Homework*Application.java启动监听 端口8000

## 接口说明(若程序运行在本机且端口号未改变)
第一二次作业
* /search 搜索

### 第三次作业
* http://localhost:8000/search POST请求 form-data: option:搜索选项(id,name,phone,qq,email),param:搜索信息，page:页数
* http://localhost:8000/admin/login POST请求 form-data: username:管理员用户名,password:管理员密码 返回值：token
* http://localhost:8000/admin/addPerson POST请求 form-data: token:在登录请求中返回的token，id:学号/教工号，name:姓名，phone:电话，qq:qq(可选)，email:邮箱（可选）
* http://localhost:8000/admin/deletePerson POST请求 form-data: token:在登录请求中返回的token，id:需要删除人的学号/教工号
* http://localhost:8000/admin/editPerson POST请求 form-data: token:在登录请求中返回的token，id:学号/教工号，name:姓名(可选)，phone:电话(可选)，qq:qq(可选)，email:邮箱（可选）

### 第四次作业添加
* http://localhost:8000/user/login POST请求 form-data: id:学号/教工号,password:密码 返回值：用户token
* http://localhost:8000/user/updatePhoto form-data: token:用户token,file:人脸照片
* http://localhost:8000/search/face form-data: file:人脸照片

### 第五次作业添加
* ws://localhost:8000/chat/{token} token为用户登录后获得的token 用以登录聊天室
* 登录后返回json 包含信息：当前在线用户列表
* 发送信息json 格式{"to":"","data":""} to中需要发送到的用户名，data为发送的信息

## 备注
* 第三到五次在application.properties 设置数据库链接信息
* spring.datasource.url=
* spring.datasource.username=
* spring.datasource.password=
* 第四五次作业中需要配置百度人脸识别API的key application.properties APP_ID，API_KEY，SECRET_KEY 请求地址：https://ai.baidu.com/tech/face/compare
* 配置完成后需在人脸库中添加组person

