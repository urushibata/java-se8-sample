package cmds.java.se8.interfaceImpl;

/**
 * インターフェースの実装のサンプル2.
 *
 * @author 漆畑 真也
 */
public interface InterfaceImplSample2 {
    default void sayHelllo() {
        System.out.println("InterfaceImpleSample2 - Hello World!!");
    }

    // staticメソッドは定義できます。
    static void doNothing() {
        System.out.println("FunctionalInterfaceSample1 - doNothing called");
    }
}
