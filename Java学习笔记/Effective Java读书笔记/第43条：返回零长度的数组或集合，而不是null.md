## 第43条：返回零长度的数组或集合，而不是null

在返回数组或集合的方法中返回null表示零长度的数组或集合，这样做会要求客户端中必须有额外的代码来处理null返回值。这样很容易出错，因为编写客户端程序时可能会忘记写这种专门的代码来处理null返回值。

标准做法：

```
public class Store {
    private final List<Cheese> chesesInStock = new ArrayList<>();
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    /**
     * 返回零长度数组的标准做法
     */
    public Cheese[] getCheeses(){
        return chesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    /**
     * 返回零长度的空集合标准做法:Collections.emptyList、emptySet、emptyMap
     */
    public List<Cheese> getCheeseList(){
        if(chesesInStock.isEmpty()){
            return Collections.emptyList();
        }else{
            return new ArrayList<Cheese>(chesesInStock);
        }
    }
}
```
