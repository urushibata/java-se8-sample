package cmds.java.se8.methoConRef;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * メソッド・コンストラクタ参照のサンプル.
 *
 * Step2
 * コンストラクタ参照
 *
 * @author 漆畑 真也
 */
public class MethoConRefStep2 {

    private Optional<String> name = Optional.empty();

    public MethoConRefStep2() { }

    public MethoConRefStep2(String name) {
        this.name = Optional.ofNullable(name);
    }

    private void sayMyName() {
        System.out.println(name.orElse(getClass().getName()));
    }

    public static void main(String... args) {

        // 引数なしコンストラクタはSupplier型に代入できます。
        Supplier<MethoConRefStep2> ref0 = MethoConRefStep2::new;
        MethoConRefStep2 in0 = ref0.get();

        in0.sayMyName();

        // 引数ありコンストラクタはその引数に合った関数型インターフェースに代入できます。
        // Function<第一引数, 戻り値（生成したインスタンス）>
        Function<String, MethoConRefStep2> ref1 = MethoConRefStep2::new;
        MethoConRefStep2 in1 = ref1.apply("HogeHoge");

        in1.sayMyName();

        // [ 実行結果 ]
        // cmds.java.se8.methoConRef.MethoConRefStep2
        // HogeHoge
    }
}
