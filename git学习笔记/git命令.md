### git init 初始化git仓库
### git status 查看git仓库状态
    参数：
    -s 或 --short 紧凑输出：
    ?? 表示未跟踪；A表示已加到暂存；M表示已修改；MM表示已加到暂存且被修改即暂存区并不是最新暂存内容
### git add 添加内容到下一次提交中即暂存区（缓存区域，临时保存改动）：未跟踪加到暂存区；已修改加到暂存区；旧暂存加到新暂存区
    参数：
    -A .来一次添加所有改变的文件
    -A表示添加所有内容， 
    . 表示添加新文件和编辑过的文件不包括删除的文件; 
    -u 表示添加编辑或者删除的文件，不包括新添加的文件
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
### git diff 工作目录中当前文件和暂存区域快照之间的差异，即只显示未暂存的改动
    参数：
    -cached或staged 查看已暂存的将要添加到下次提交里的内容，即已缓存的改动

## git状态
- Untracked 未跟踪的
- Tracked 已跟踪的
  - Staged 已暂存
  - Unmodified 未修改
  - Modified 已修改 
  
 一般状态变化如下：
 
 Untracked -(Add the file) > Staged
 
 Unmodified -(Edit the file) > Modified
 
 Modified -(Stage the file) > Staged
 
 Staged -(Commit) > Unmodified
 