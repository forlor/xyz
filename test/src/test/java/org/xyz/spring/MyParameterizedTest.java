package org.xyz.spring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @ClassName ParameterizedTest
 * @Description 参数化测试
 * @Author xyz
 * @Date 2020/5/13 17:10
 * @Version 1.0
 **/

/**
 * @ParameterizedTest 该注解代替@Test
 *  @ValueSource 支持基本数据类型、String、Class.里每个参数都会运行目标方法，
 *               一旦哪个参数运行测试失败，就意味着该测试方法不通过
 *  @CsvSource 每个逗号分隔的值来匹配一个测试方法对应的参数
 *  扩展： @EnumSource：允许我们通过参数值，给指定 Enum 枚举类型传入，构造出枚举类型中特定的值
 *         @MethodSource：指定一个返回的 Stream / Array / 可迭代对象 的方法作为数据源。
 *         需要注意的是该方法必须是静态的，并且不能接受任何参数
 *         @ArgumentSource：通过实现 ArgumentsProvider 接口的参数类来作为数据源，
 *         重写它的 provideArguments 方法可以返回自定义类型的 Stream<Arguments> ，
 *         作为测试方法所需要的数据使用。
 */
public class MyParameterizedTest {

   @ParameterizedTest
    @ValueSource(ints = {1,2,5})
    public void testNumber(String s){
       System.out.println(s);
    }

    @ParameterizedTest
    @CsvSource({"1,One", "2,Two", "3,Three"})
    void testDataFromCsv(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }
}
