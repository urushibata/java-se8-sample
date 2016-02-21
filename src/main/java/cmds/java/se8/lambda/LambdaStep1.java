package cmds.java.se8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * ラムダ式のサンプル.
 *
 * Step1
 * ラムダ式の基本
 *
 * @author 漆畑 真也
 */
public class LambdaStep1 {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(100, 51, 78, 3, -13, 34);

        System.out.println("Dump 数値リスト");
        numbers.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("リストの要素の値を1/2にします。");

        Function<Integer, Integer> fnc;
        // ラムダ式の記述方法
        // 省略なし
        fnc = (Integer i) -> { return i / 2; };

        System.out.println(fnc.apply(51));

        // 引数の型を省略します(Function型の第一引数で自明です)。
        fnc = (i) -> { return i / 2; };

        System.out.println(fnc.apply(51));

        // 引数が1つなら、その括弧を省略できます。
        fnc = i -> { return i / 2; };

        System.out.println(fnc.apply(51));

        // 処理が一行なら、returnと{}とセミコロンを省略できます。
        // returnと{}とセミコロンはセットで省略します。個別で省略できません。
        fnc = i -> i / 2;

        System.out.println(fnc.apply(51));

        // [実行結果]全て
        // 25

        System.out.println();
        System.out.println("リストを降順でソートします。");
        Collections.sort(numbers, (n1, n2) -> n2 - n1);
        numbers.stream().forEach(n -> System.out.println(n));

        // [実行結果]
        // 100
        // 78
        // 51
        // 34
        // 3
        // -13

        // java7までの書き方
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        List<String> words = Arrays.asList("co", "mo", "do", "sys", "tem", "!!");

        System.out.println();
        System.out.println("Dump 文字列リスト");
        numbers.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("文字列をハイフンでつないで表示します。");
        words.stream().forEach(word -> {
            String decoWord = "-" + word;
            System.out.print(decoWord);
        });

        // [実行結果]
        // -co-mo-do-sys-tem-!!
    }
}
