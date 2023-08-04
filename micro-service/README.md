# 命令行参数
java -jar xxx.jar

java -jar xxx.jar--server.port=8888
（在运行时将server.port换成8888）

# 多环境配置
文件名格式：application-{profile}.properties

加载方法：spring.profiles.active={profile}（在application.properties中）

可以在不同的{profile}中，使用不同port方便操作

多环境和命令行一起用可以启动多个服务

# 端点

## 原生端点
### 应用配置类
/autoconfig：用于获取自动化配置报告，并列出每个候选项是否满足自动化配置的各个先决条件

/beans：获取上下文中的所有bean

# Netflix Eureka
Eureka服务端：服务注册中心

Eureka客户端：处理服务的注册与发现，向服务注册中心注册自身提供的服务并周期性发送心跳更新租约；也能获取服务端上维护的服务信息，缓存到本地并周期性刷新