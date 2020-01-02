#### git init 初始化git仓库
#### git status 查看git仓库状态
    参数：
    -s 或 --short 紧凑输出：
    ?? 表示未跟踪；A表示已加到暂存；M表示已修改；MM表示已加到暂存且被修改即暂存区并不是最新暂存内容
#### git add 添加内容到下一次提交中即暂存区（缓存区域，临时保存改动）：未跟踪加到暂存区；已修改加到暂存区；旧暂存加到新暂存区；还能用于合并时把有冲突的文件标记为已解决状态
    参数：
    -A .来一次添加所有改变的文件
    -A表示添加所有内容， 
    . 表示添加新文件和编辑过的文件不包括删除的文件; 
    -u 表示添加编辑或者删除的文件，不包括新添加的文件
#### git rm 移除文件

```
git rm file 可以把已加入到暂存且之后删除的文件（先git add再delete的文件）移除
git rm -f 直接删除（删除文件并移除跟踪）已加入到暂存的文件
git rm --cached 把文件从Git仓库中删除（亦即从暂存区域移除），但仍保留在当前工作目录。（需要再一次手动提交此次删除操作），针对误提交的情况。
```

> 对已跟踪提交的文件，若想移除跟踪可参考：<https://blog.csdn.net/timestone/article/details/78933092>

####  git mv 移动文件(重命名)
```
git mv file1 file2 把file1名字重名为file2,git status 会显示rename
PS:如果在文件系统直接重命名，则会显示已删除文件且新建一个文件。
```

#### git commit 提交 
	参数：
	无参数 打开vim编辑器编辑提交信息（这里需要用到vim命令啦）
	-m 提交信息
	-a 把已跟踪且已修改过的文件加到暂存再提交（跳过加到暂存步骤）
#### git log 查看所有产生的commit记录

```
-2 -数字，表示查看最近2次提交记录
-p 查看每次记录详情 
//示例：
git log -2 -p //查看最近2次详细提交记录
--stat 在每次提交的下面列出所有被修改过的文件、有多少文件被修改了以及被修改过
的文件的哪些行被移除或是添加了
--graph 查看到分支合并图。
```

#### git branch 查看当前分支情况
	参数：
	-d 删除分支
	-D 强制删除分支
	-r 查看远程分支


#### git branch branchName 创建branchName分支

#### git branch --set-upstream-to=origin/<branch> dev 设置本地分支与远程分支的链接

#### git push --set-upstream origin prod 本地分支推送到远程分支（远程未创建分支）

#### git checkout branchName 切换到branchName（tag）分支
#### git checkout -b newBranch 创建newBranch分支并切换新分支

#### git checkout -b branch origin/branch 创建远程origin的branch分支到本地

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



#### git tag <name> 创建标签

```
//创建标签
git tag v1.0 //在当前分支下新建标签号v1.0（版本号为1.0）
git tag //查看所有标签
git tag <name> <commit id> //在commit id处打上name标签
git show <tagname> //查看标签信息
git tag -a v0.1 -m 'version 0.1 released' commitid //-a 指定标签名，-m 指定说明信息
git tag -s v0.2 -m "signed version 0.2 released" fec145a //-s用私钥签名一个标签

//操作标签
git tag -d v0.1 //删除标签
git push origin v1.0 //推送某个标签到远程
git push origin --tags 一次性推送全部尚未推送到远程的本地标签
git push origin :refs/tags/<tagname>可以删除一个远程标签
```



#### reset 清屏
#### push 推 把本地代码推到远程仓库
	git push origin master  //把本地代码推到远程master分支
#### pull 拉 把远程仓库的最新代码拉下本地来
	git pull origin master //把远程最新的代码更新到本地，一般我们在push之前都会先pull,这样不容易冲突
	git pull //只会从远程拉取当前分支的commit
#### clone 克隆 远程仓库代码“高级”复制到本地
	git clone git@github.com:wushuwei1994/hello-world.git //ssh路径格式：git@github.com:username/project_name.git

#### git remote add 添加远程仓库
#### git remote -v 查看当前项目有哪些远程仓库
#### git config -l 查看你的Git全局设置信息 
#### git config --global user.name "wushuwei" 配置全局变量

```
git config --global color.ui true //让git显示颜色
$ git config --global alias.st status  //配置别名
```

#### git diff 工作目录中当前文件和暂存区域快照之间的差异，即只显示未暂存的改动
    参数：
    --cached或staged 查看已暂存的将要添加到下次提交里的内容，即已缓存的改动
    git diff HEAD -- readme.txt命令可以查看工作区和版本库里面最新版本的区别：
    git difftool 可通过图形化的方式输出

#### git reset 版本回退 

> Git必须知道当前版本是哪个版本，在Git中，用`HEAD`表示当前版本，也就是最新的提交`3628164...882e1e0`上一个版本就是`HEAD^`，上上一个版本就是`HEAD^^`，当然往上100个版本写100个`^`比较容易数不过来，所以写成`HEAD~100`。

```
[bob@iZwz9b0bqrkbhq5r8nvaojZ learngit]$ git reset --hard HEAD^
HEAD is now at c6b789e add distributedh
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

#### git stash 把当前工作现场“储藏”起来，即工作空间切回最新commit版本中。 

#### git stash list 查看“储藏情况”

#### git stash apply 恢复，但是恢复后，stash内容并不删除，你需要用

#### git stash drop来删除

#### git stash pop 恢复的同时把stash内容也删了

```
git stash ( pop | apply ) [--index] [-q|--quiet] [<stash>] 
[<stash>]为储藏版本号，demo: git stash apply stash@{1}
```



ps:若在本地仓库有多个分支，在其中一个分支做出修改而未commit，当切换到其他分支时候，其他分支也可以看到这些修改。




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


```

```