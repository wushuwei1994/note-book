## 本地与github建立关系-SSH授权
1. 本地安装SSH（win系统Git Bash自带）
2. 输入命令：ssh-keygen -t rsa -C "youremail@example.com"（ -C "youremail@example.com"，非必填）接着三个回车键，生成密钥id_rsa（私钥）和id_rsa.pub（公钥）
3. 在GitHub添加SSH KEY（公钥）
4. 输入命令：ssh -T git@github.com 测试建立关系是否成功

## 关联远程仓库
1. 克隆远程仓库
  git clone git@github.com:wushuwei1994/hello-world.git
2. 添加远程仓库（本地仓库与远程仓库关联） 
    git remote add origin git@github.com:wushuwei1994/hello-world.git  //origin 远程仓库名字
## 向远程仓库提交代码

## 忽略文件
在仓库跟目录增加 .gitignore 文件（一般都通过gitbash上的touch .gitignore命令创建文件），然后在文件增加忽略规则(GLOB模式)
如：*.txt 所有txt格式文件； .idea/ .idea文件夹下所有文件
