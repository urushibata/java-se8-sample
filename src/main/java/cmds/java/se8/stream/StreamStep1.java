package cmds.java.se8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Stream APIのサンプル.
 *
 * Step1
 * Streamの基本
 *
 * @author 漆畑 真也
 */
public class StreamStep1 {

    public static void main(String... args) {
       List<String> words = Arrays.asList("２．コンピューター", "１．Java", "３．プログラミング");

       // ■ Stremeはコレクション、配列、または、Streamインターフェースから生成できます。
       // 1. Collectionインターフェースに追加されたデフォルトメソッドstream()
       // 2. Arraysクラスに追加されたstaticメソッドstream(T[])
       // 3. 1.8より追加されたStreamインターフェースのstaticメソッドof(T), of(T...)

       System.out.println("Dump 文字列リスト");
       // forEach … Streamをループ処理する終端操作メソッドです。
       words.stream().forEach(word -> System.out.println(word));

       System.out.println();
       System.out.println("昇順ソート後、順番に表示します。");
       words.stream()
           // sorted … Streamをソートする中間操作メソッドです。
           // デフォルトは昇順です。
           .sorted()
           .forEach(System.out::println);

       System.out.println();
       System.out.println("降順ソート後、順番に表示します。");
       words.stream()
           // sortedはComparator型を引数にとることで、ソート順をカスタマイズできます。
           // reverseOrder … ComparatorクラスのstaticメソッドでStreamの型パラメータのComparatorメソッドを返します。
           .sorted(Comparator.reverseOrder())
           .forEach(System.out::println);

       int[] numbers = new int[] {9, 7, 4, 13, 0, -16, -3};

       System.out.println();
       System.out.println("Dump 数字リスト");
       Arrays.stream(numbers).forEach(System.out::println);

       System.out.println();
       System.out.println("4回表示します(5要素目以降表示しません)。");
       Arrays.stream(numbers)
           // limit … 繰り返し処理の最大回数を制限するメソッドです。
           .limit(4)
           .forEach(System.out::println);

       System.out.println();
       System.out.println("偶数のみ表示します。");
       Arrays.stream(numbers)
           // filter … 条件に一致するデータを抽出する中間操作メソッドです。
           .filter(n -> n != 0 && n % 2 == 0)
           .forEach(System.out::println);

       System.out.println();
       System.out.println("正の数の中で最小値を表示します。");
       Arrays.stream(numbers)
           .filter(n -> n > 0)
           // min … 最小値を抽出する終端操作メソッドです。戻り値はOptional型です。
           //        最大値の場合は、maxというメソッドが用意されています。
           .min()
           // ifPresent … インスタンス変数がnot nullの場合、引数のメソッドを実行するOptionalクラスのメソッドです。
           .ifPresent(System.out::println);
    }
}
