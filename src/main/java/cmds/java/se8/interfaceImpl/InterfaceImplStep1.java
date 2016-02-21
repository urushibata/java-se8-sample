package cmds.java.se8.interfaceImpl;

/**
 * インターフェースの実装のサンプル1.
 *
 * Step1
 * staticメソッドとデフォルトメソッドの使い方とMixin
 *
 * @author 漆畑 真也
 */
public class InterfaceImplStep1 {

    // InterfaceImplSample1を実装します。
    public static class InterfaceImplement1
        implements InterfaceImplSample1 { }

    // InterfaceImplSample1とInterfaceImplSample2を実装します。
    static class InterfaceImplement2
        implements InterfaceImplSample1, InterfaceImplSample2 { }

    // static class InterfaceImplement3
    //    implements InterfaceImplSample1, InterfaceImplSample3 { }

    // ■上のInterfaceImplement3はコンパイルエラーになります。
    // InterfaceImplSample1とInterfaceImplSample3は両方ともデフォルトメソッドの[doSomething()]を持っているためです。
    // 以下、エラーメッセージです。
    //      Duplicate default methods named doSomething with the parameters () and ()
    //      are inherited from the types InterfaceImplSample3 and InterfaceImplSample1

    public static void main(String[] args) {
        // インターフェースのstaticメソッドは具象クラスと同じ使い方です。
        InterfaceImplSample1.doNothing();
        InterfaceImplSample2.doNothing();

        // 実装したクラスからstaticメソッドを使うことはできません。
        // 以下はコンパイルエラーになります。
        // × InterfaceImplement1.doNothing();

        // staticフィールドは実装したクラスから参照できます。
        String s = InterfaceImplement1.SOMETHING;

        System.out.println();
        InterfaceImplement1 i1 = new InterfaceImplement1();

        // InterfaceImplSample1のデフォルトメソッド[doSomething()]が使用できます。
        i1.doSomething();

        // [実行結果]
        // InterfaceImpleSample1 - doSomething called

        System.out.println();
        InterfaceImplement2 i2 = new InterfaceImplement2();

        // InterfaceImplSample1のデフォルトメソッド[doSomething()]と
        // InterfaceImplSample2のデフォルトメソッド[doSomething2()]が使用できます(Mixin)。
        i2.doSomething();
        i2.doSomething2();
    }
}
