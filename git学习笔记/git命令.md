#### git init 初始化git仓库
#### git status 查看git仓库状态
    参数：
    -s 或 --short 紧凑输出：
    ?? 表示未跟踪；A表示已加到暂存；M表示已修改；MM表示已加到暂存且被修改即暂存区并不是最新暂存内容
#### git add 添加内容到下一次提交中即暂存区（缓存区域，临时保存改动）：未跟踪加到暂存区；已修改加到暂存区；旧暂存加到新暂存区
    参数：
    -A .来一次添加所有改变的文件
    -A表示添加所有内容， 
    . 表示添加新文件和编辑过的文件不包括删除的文件; 
    -u 表示添加编辑或者删除的文件，不包括新添加的文件
#### git rm -cached 移除缓存（已跟踪变为未跟踪）

#### git rm file 从资源库删除文件

#### git commit 提交 
	参数：
	无参数 打开vim编辑器编辑提交信息（这里需要用到vim命令啦）
	-m 提交信息
	-a 把已跟踪且已修改过的文件加到暂存再提交（跳过加到暂存步骤）
#### git log 查看所有产生的commit记录

`git log --graph`命令可以看到分支合并图。

#### git branch 查看当前分支情况
	参数：
	-d 删除分支
	-D 强制删除分支
#### git branch branchName 创建branchName分支
#### git checkout branchName 切换到branchName（tag）分支
#### git checkout -b newBranch 创建newBranch分支并切换新分支

#### git checkout -- <file> 丢弃工作区的修改

#### git merge a 合并分支a

> 合并分支时，如果可能，Git会用`Fast forward`模式，但这种模式下，删除分支后，会丢掉分支信息。
>
> 如果要强制禁用`Fast forward`模式，Git就会在merge时生成一个新的commit，这样，从分支历史上就可以看出分支信息。
>
> ex:
>
> ```
> $ git merge --no-ff -m 'merge with no-ff' dev
> ```



#### git tag v1.0 新建标签号v1.0（版本号为1.0）
#### reset 清屏
#### push 推 把本地代码推到远程仓库
	git push origin master  //把本地代码推到远程master分支
#### pull 拉 把远程仓库的最新代码拉下本地来
	git pull origin master //把远程最新的代码更新到本地，一般我们在push之前都会先pull,这样不容易冲突
#### clone 克隆 远程仓库代码“高级”复制到本地
	git clone git@github.com:wushuwei1994/hello-world.git //ssh路径格式：git@github.com:username/project_name.git

#### git remote add 添加远程仓库
#### git remote -v 查看当前项目有哪些远程仓库
#### git config -l 查看你的Git全局设置信息 
#### git config --global user.name "wushuwei" 配置全局变量
#### git diff 工作目录中当前文件和暂存区域快照之间的差异，即只显示未暂存的改动
    参数：
    -cached或staged 查看已暂存的将要添加到下次提交里的内容，即已缓存的改动
    
    git diff HEAD -- readme.txt命令可以查看工作区和版本库里面最新版本的区别：

#### git reset 版本回退 

> Git必须知道当前版本是哪个版本，在Git中，用`HEAD`表示当前版本，也就是最新的提交`3628164...882e1e0`上一个版本就是`HEAD^`，上上一个版本就是`HEAD^^`，当然往上100个版本写100个`^`比较容易数不过来，所以写成`HEAD~100`。

```
[bob@iZwz9b0bqrkbhq5r8nvaojZ learngit]$ git reset --hard HEAD^
HEAD is now at c6b789e add distributed
```

同时，git也可以回到未来的版本（版本回退之前的版本）。如果命令行窗口没有关闭，可以根据commit id （可以不完整）回到未来的版本。

```
[bob@iZwz9b0bqrkbhq5r8nvaojZ learngit]$ git reset --hard 10f14
HEAD is now at 10f14cb append GPL
```

#### git reset HEAD <file>...  把暂存区的修改撤销掉（unstage），重新放回工作区

#### git reflog 记录每一次命令

```
[bob@iZwz9b0bqrkbhq5r8nvaojZ learngit]$ git reflog
10f14cb HEAD@{0}: reset: moving to 10f14
c6b789e HEAD@{1}: reset: moving to HEAD^
10f14cb HEAD@{2}: commit: append GPL
c6b789e HEAD@{3}: commit: add distributed
ce6c748 HEAD@{4}: commit (initial): wrote a readme file
```




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

