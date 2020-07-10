package org.xyz.hardware;

import com.sun.jna.Library;
import com.sun.jna.Native;
/**
 * @ClassName Os
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/1 13:08
 * @Version 1.0
 **/
public class Os {
        public interface CLibrary extends Library {
            CLibrary INSTANCE = Native.load("msvcrt", CLibrary.class);

            void printf(String format, Object... args);
        }

        public static void main(String[] args) {
            CLibrary.INSTANCE.printf("Hello, World\n");
        }

}
