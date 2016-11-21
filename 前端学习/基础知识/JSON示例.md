#JSON示例
###创建JSON对象
	var obj = {
		id:666,
		name:'Bob'
	}
###使用JSON对象
* 使用**.**运算符`console.log(obj.id);  //666`
* 使用**[]**运算符`console.log(obj['name']);  //Bob`,**注意：方括号里面必须要为字符串，即如：'name'**

###遍历JSON数据
```
for(var c in obj){
	console.log('key=' + c + ',value=' + obj[c]);
}
结果：
key=id,value=666
key=name,value=Bob
```

###增加、修改、删除数据
```
//增加
obj.age=22;
或
obj['age'] = 22;
console.log(obj.age);  //结果：22

//修改
obj['age'] = 22 + 1;
console.log(obj.age);  //结果：23

//删除
delete obj.age;
console.log(obj.age);  //结果：undefined
```