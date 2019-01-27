# Everlasting

# 创建用户及数据库
```sql
CREATE DATABASE IF NOT EXISTS everlasting DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE USER 'everlasting'@'localhost' IDENTIFIED BY 'everlasting';
GRANT ALL PRIVILEGES ON everlasting.* TO 'everlasting'@'localhost'; 
FLUSH PRIVILEGES;
```

# 参考项目
* https://gitee.com/stylefeng/guns
* https://gitee.com/y_project/RuoYi