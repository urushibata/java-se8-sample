package cmds.java.se8.interfaceImpl;

/**
 * インターフェースの実装のサンプル1.
 *
 * @author 漆畑 真也
 */
public interface InterfaceImplSample1 {
    // staticフィールドは定義できます。
    String SOMETHING = "static field";

    // デフォルトメソッドは定義できます。
    default void doSomething() {
        System.out.println("InterfaceImpleSample1 - doSomething called");
    }

    // デフォルトメソッドは複数定義できます(普通のメソッドと同じ扱いです)。
    default void doSomething2() {
        System.out.println("InterfaceImpleSample1 - doSomething2 called");
    }

    // staticメソッドは定義できます。
    static void doNothing() {
        System.out.println("FunctionalInterfaceSample1 - doNothing called");
    }
}
