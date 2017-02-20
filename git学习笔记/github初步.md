## 本地与github建立关系-SSH授权
1. 本地安装SSH（win系统Git Bash自带）
2. 输入命令：ssh-keygen -t rsa 接着三个回车键，生成密钥id_rsa（私钥）和id_rsa.pub（公钥）
3. 在GitHub添加SSH KEY（公钥）
4. 输入命令：ssh -T git@github.com 测试建立关系是否成功

## 关联远程仓库
1. 克隆远程仓库
	git clone git@github.com:wushuwei1994/hello-world.git
2. 添加远程仓库（本地仓库与远程仓库关联） 
    git remote add origin git@github.com:wushuwei1994/hello-world.git  //origin 远程仓库名字
## 向远程仓库提交代码
