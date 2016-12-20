# JAVA枚举类示例

```
package com.yihuacomputer.yhcloud.service.common.enums.order;
/**
 * @ClassName: MessageSourceEnum
 * @Description:
 * @author 吴蜀威
 * @date2016年11月25日 上午11:07:46
 * @version V1.0  
 */
public enum FaultMessageSourceEnum {
	
	IBOSS_SOURCE(1,"IBOSS同步"),
	MANUAL_SOURCE(2, "手动派单");

	private FaultMessageSourceEnum(int id, String text){
		this.id = id;
		this.text = text;
	}
	private int id;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public static FaultMessageSourceEnum getById(int id){
		for(FaultMessageSourceEnum each : FaultMessageSourceEnum.values()){
			if(each.getId() == id){
				return each;
			}
		}
		throw new IllegalArgumentException(String.format("id=[%d] error", id));
	}
	
}

//使用
FaultMessageSourceEnum.MANUAL_SOURCE.getText();
```
一般步骤：
1. 创建Enum类
2. 定义枚举属性
3. **私有**构造函数
4. 定义所需枚举，格式：enumName(attr1,attr2,...)
5. 编写根据id获取枚举方法：遍历枚举，enum.values()获取所有枚举变量 
6. 使用:Enum.enumName.getAttr();
