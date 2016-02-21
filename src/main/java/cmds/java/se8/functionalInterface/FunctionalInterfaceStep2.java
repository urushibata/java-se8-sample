package cmds.java.se8.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;



/**
 * 関数型インターフェースのサンプル.
 *
 * Step1
 * 合成関数
 *
 * @author 漆畑 真也
 */
public class FunctionalInterfaceStep2 {

    public static void main(String... args) {

        // 合成関数
        // 関数を合成するって何？
        Consumer<String> println = System.out::println;

        // 角括弧でくくる関数
        Function<String, String> enclose = s -> "[" + s + "]";

        // 先頭文字を大文字に変換する関数
        Function<String, String> capitalize = s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();

        // capitalize→encloseしてから表示する。
        println.accept(enclose.apply(capitalize.apply("foo")));
        // またはandThen

        // FunctionインターフェースのandThenメソッド
        // default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        //     Objects.requireNonNull(after);
        //     return (T t) -> after.apply(apply(t)); // パラメータtを自分で実行し、その結果をafterで実行する関数を返す。
        // }
        println.accept(capitalize.andThen(enclose).apply("foo"));

        // 関数を合成する！！
        // こういうことを合成関数というようです。
        // 関数型言語では基本の考え方らしい。
        Function<String, String> capEnc = capitalize.andThen(enclose);
        println.accept(capEnc.apply("bar"));

    }

    private void printDocoString(Consumer<String> c) {


    }
}
