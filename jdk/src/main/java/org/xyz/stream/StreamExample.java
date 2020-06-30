package org.xyz.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StreamExample
 * @Description jdk1.8新特性stream操作示例
 * @Author xyz
 * @Date 2020/5/12 19:02
 * @Version 1.0
 **/
public class StreamExample {

    private static String[] arr = {"1", "x", "y", "te", "st", "7"};
    private static List<String> list = new ArrayList<>();

    static {
        list.add("xyz");
        list.add("abc");
        list.add("123");
        list.add("sfasaf");
        list.add("casdv");
    }

    /**
     * 中间操作符包含8种(排除了parallel,sequential,这两个操作并不涉及到对数据流的加工操作)：
     * 1、 map(mapToInt,mapToLong,mapToDouble) 转换操作符，把比如A->B，这里默认提供了转int，long，double的操作符。
     * 2、flatmap(flatmapToInt,flatmapToLong,flatmapToDouble) 拍平操作比如把 int[]{2,3,4} 拍平 变成 2，3，4
     * 也就是从原来的一个数据变成了3个数据，这里默认提供了拍平成int,long,double的操作符。
     * 3、limit 限流操作，比如数据流中有10个 我只要出前3个就可以使用。
     * 4、distint 去重操作，对重复元素去重，底层使用了equals方法。
     * 5、filter 过滤操作，把不想要的数据过滤。
     * 6、peek 挑出操作，如果想对数据进行某些操作，如：读取、编辑修改等。
     * 7、skip 跳过操作，跳过某些元素。
     * 8、sorted(unordered) 排序操作，对元素排序，前提是实现Comparable接口，当然也可以自定义比较器。
     */

}
