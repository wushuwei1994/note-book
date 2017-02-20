### git init 初始化git仓库
### git status 查看git仓库状态
### git add 添加到暂存区（缓存区域，临时保存改动）
### git rm -cached 移除缓存（已跟踪变为未跟踪）
### git commit 提交 
	参数：
	-m 提交信息
### git log 查看所有产生的commit记录
### git branch 查看当前分支情况
	参数：
	-d 删除分支
	-D 强制删除分支
### git branch branchName 创建branchName分支
### git cheackout branchName 切换到branchName（tag）分支
### git cheackout -b newBranch 创建newBranch分支并切换新分支
### git merge a 合并分支a
### git tag v1.0 新建标签号v1.0（版本号为1.0）
### reset 清屏
### push 推 把本地代码推到远程仓库
	git push origin master  //把本地代码推到远程master分支
### pull 拉 把远程仓库的最新代码拉下本地来
	git pull origin master //把远程最新的代码更新到本地，一般我们在push之前都会先pull,这样不容易冲突
### clone 克隆 远程仓库代码“高级”复制到本地
	git clone git@github.com:wushuwei1994/hello-world.git //ssh路径格式：git@github.com:username/project_name.git

### git remote add 添加远程仓库
### git remote -v 查看当前项目有哪些远程仓库
### git config -l 查看你的Git全局设置信息 
### git config --global user.name "wushuwei" 配置全局变量

## git状态
- untracked 未跟踪的