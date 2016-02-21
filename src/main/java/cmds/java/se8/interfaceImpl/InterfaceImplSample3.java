package cmds.java.se8.interfaceImpl;

/**
 * インターフェースの実装のサンプル3.
 *
 * @author 漆畑 真也
 */
public interface InterfaceImplSample3 {
    // デフォルトメソッドは定義できます。
    default void doSomething() {
        System.out.println("InterfaceImpleSample3 - doSomething called");
    }
}
