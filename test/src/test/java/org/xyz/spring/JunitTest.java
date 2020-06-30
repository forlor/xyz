package org.xyz.spring;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * 执行顺序
 * beforeAll annotation  不能有返回值，只能是void
 * beforeEach annotation
 * test annotation
 * afterEach annotation
 * afterAll annotation   不能有返回值，只能是void
 *
 * @BeforeAll **和 @AfterAll ，它们定义了整个测试类在开始前以及结束时的操作，只能修饰静态方法，
 * 主要用于在测试过程中所需要的全局数据和外部资源的初始化和清理。
 * 与它们不同，@BeforeEach 和 @AfterEach 所标注的方法会在每个测试用例方法开始前和结束时执行，
 * 主要是负责该测试用例所需要的运行环境的准备和销毁
 * @Disabled 禁用测试
 * @Nested 支持内部类测试，非静态内部类将运行外层的@BeforeAll等方法，静态内部类则不会运行
 *
 * Assertions 断言
 */
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("单元测试")
public class JunitTest {


    //没得@TestInstance(TestInstance.Lifecycle.PER_CLASS)，需将改方法设置为static方法
    @DisplayName("beforeAll")
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll annotation");
    }

    //没得@TestInstance(TestInstance.Lifecycle.PER_CLASS)，需将改方法设置为static方法
    @DisplayName("afterAll")
    @AfterAll
    public static void afterAll() {

        System.out.println("afterAll annotation");

    }

    @DisplayName("beforeEach")
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach annotation");

    }

    @DisplayName("afterEach")
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach annotation");

    }

    @DisplayName("test")
    @Test
    public void test() {
        System.out.println("test annotation");
    }


    @DisplayName("testDisable")
    @Disabled
    @Test
    public void testDisable() {
        System.out.println("Disabled annotation");
    }

    @DisplayName("第一个内嵌测试内")
    @Nested
    class FirstNestTest {

        @Test
        public void nestTest() {
            System.out.println("FirstNestTest ");
        }
    }

    @RepeatedTest(value = 3)
    @DisplayName("重复调用")
    @Test
    public void repeatedTest(){
        System.out.println("repeatedTest");
    }

    public String repeatedTestName(){

        return UUID.randomUUID().toString();
    }

}