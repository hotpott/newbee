# 命令行参数
java -jar xxx.jar

java -jar xxx.jar--server.port=8888
（在运行时将server.port换成8888）

# 多环境配置
文件名格式：application-{profile}.properties

加载方法：spring.profiles.active={profile}（在application.properties中）

可以在不同的{profile}中，使用不同port方便操作

多环境和命令行一起用可以启动多个服务
