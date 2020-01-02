> 引用gitlab命令行指南

### 命令行指令

##### Git 全局设置

```
git config --global user.name "吴蜀威"
git config --global user.email "wushuwei@doyd.cn"
```

##### 创建新版本库

```
git clone ssh://git@192.168.4.34:8081/develop-java/merchant-library/basic_shop_manager.git
cd basic_shop_manager
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master
```

##### 已存在的文件夹

```
cd existing_folder
git init
git remote add origin ssh://git@192.168.4.34:8081/develop-java/merchant-library/basic_shop_manager.git
git add .
git commit -m "Initial commit"
git push -u origin master
```

##### 已存在的 Git 版本库

```
cd existing_repo
git remote rename origin old-origin
git remote add origin ssh://git@192.168.4.34:8081/develop-java/merchant-library/basic_shop_manager.git
git push -u origin --all
git push -u origin --tags
```

