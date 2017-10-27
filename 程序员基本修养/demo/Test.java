/**
 * Created by wushu on 2017/4/18.
 */
public class Test {
    public static void main(String[] args){
        short a = Byte.MIN_VALUE;
        int b = Short.MIN_VALUE;
        short c = Byte.MAX_VALUE + 1;
        byte d = (byte)(Byte.MAX_VALUE + 1);
        System.out.println("a=" + a + ";b="+ b + ";c="+ c + ";d="+ d);
    }
}
