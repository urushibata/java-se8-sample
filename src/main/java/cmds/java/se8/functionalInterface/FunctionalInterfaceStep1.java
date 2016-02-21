package cmds.java.se8.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 関数型インターフェースのサンプル.
 *
 * Step1
 * 関数型インターフェースの標準API
 *
 * @author 漆畑 真也
 */
public class FunctionalInterfaceStep1 {

    public static void main(String... args) {

        // 追加された標準APIの関数型インターフェース
        // java.util.functionパッケージ以下にいろいろあります。
        // 例を記述します。

        // Supplier<T>
        // 引数なしでTを返す関数です。
        Supplier<Object> supplier = () -> new Object();
        Object obj = supplier.get();

        // Consumer<T>
        // Tを引数にvoidを返す関数です。
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Consumer");

        // Function<T, R>
        // Tを引数にRを返す関数です。
        Function<Object, String> function = o -> "function";
        System.out.println(function.apply(new Object()));
    }
}
