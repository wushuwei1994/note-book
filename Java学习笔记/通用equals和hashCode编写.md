## 通用equals和hashCode编写 ##

#### equals 规则 ####

**自反性**:  x.equals(x) 一定是true

**对null**:  x.equals(null) 一定是false

**对称性**:  x.equals(y)  和  y.equals(x)结果一致

> 反例：类Student 继承 类Person，则 student instanceof Person 返回true，而 person instanceof Student 返回false

**传递性**:  a 和 b equals , b 和 c  equals，那么 a 和 c也一定equals。

**一致性:**  在某个运行时期间，2个对象的状态的改变不会不影响equals的决策结果，那么，在这个运行时期间，无论调用多少次equals，都返回相同的结果。

####重写equals方法

1. 判断是否为空。若为空，返回false
2. 判断是否为同一个引用。若相同，返回true
3. 判断是否为同一类型。若不是，返回false
4. 最后比较具体对象值是否相等（成员变量）。

```
// Demo:
public class TimeOfDay {
    private int hour; // 小时
    private int minute; // 分钟
    private int second; // 秒
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        TimeOfDay timeOfDay = (TimeOfDay) object;
        return this.hour == timeOfDay.getHour()
                && this.minute == timeOfDay.getMinute()
                && this.second == timeOfDay.getSecond();
    }
    
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }   
}
```

#### hashCode 规则####

1.重写了euqls方法的对象必须同时重写hashCode()方法。

2.如果2个对象通过equals调用后返回是true，那么这个2个对象的hashCode方法也必须返回同样的int型散列码
3.如果2个对象通过equals返回false，他们的hashCode返回的值**允许相同**。

#### 重写hashCode方法 ####

1、定义一个int类型的变量 hash,初始化为 7。

接下来让你认为重要的字段（equals中衡量相等的字段）参入散列运，算每一个重要字段都会产生一个hash分量，为最终的hash值做出贡献（影响）

| 重要字段var的类型              | 他生成的hash分量                               |
| ----------------------- | ---------------------------------------- |
| byte, char, short ， int | (int)var                                 |
| long                    | (int)(var ^ (var >>> 32))                |
| boolean                 | var?1:0                                  |
| float                   | Float.floatToIntBits(var)                |
| double                  | long bits = Double.doubleToLongBits(var);分量 = (int)(bits ^ (bits >>> 32)); |
| 引用类型                    | (null == var ? 0 : var.hashCode())       |

最后把所有的分量都总和起来，注意并不是简单的相加。选择一个倍乘的数字31，参与计算。然后不断地递归计算，直到所有的字段都参与了。

```
// Demo:
@Override
public int hashCode() {
  int hash = 7;
  hash = hash * 31 + hour;
  hash = hash * 31 + minute;
  hash = hash * 31 + second;
  return hash;
}
```

