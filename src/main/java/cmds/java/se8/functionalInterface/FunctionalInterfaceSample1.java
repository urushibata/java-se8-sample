package cmds.java.se8.functionalInterface;

/**
 * 関数型インターフェースのサンプル.
 *
 * @author 漆畑 真也
 */
@FunctionalInterface
public interface FunctionalInterfaceSample1 {
    // 関数型インターフェースに
    // staticフィールド、デフォルトメソッド、staticメソッドは定義できます。
    String DECO = " * ";
    default void doSomething() {
        System.out.println("FunctionalInterfaceSample1 - doSomething called");
    }
    static void doNothing() {
        System.out.println("FunctionalInterfaceSample1 - doNothing called");
    }

    // 抽象クラスを1つだけ持つインターフェースです。
    // 2つ以上あると(@FunctionalInterfaceを付与しているため)コンパイルエラーになります。
    void decorateString(String original);
}
