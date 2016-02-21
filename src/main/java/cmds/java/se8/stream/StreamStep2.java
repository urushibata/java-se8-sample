package cmds.java.se8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

/**
 * Stream APIのサンプル.
 *
 * Step2
 * mapとreduce
 *
 * @author 漆畑 真也
 */
public class StreamStep2 {

    public static void main(String... args) {
       int[] numbers = new int[] {1, 17, 33, 4, 0, 3};

       System.out.println();
       System.out.println("Dump 数字リスト");
       Arrays.stream(numbers).forEach(System.out::println);

       System.out.println();
       System.out.println("各要素を1/2にする");
       Arrays.stream(numbers)

           // プリミティブ型をそのラッパークラスに変換します。
           .boxed()

           // Javascript、Ruby、Perlなどがわかる人には説明不要です。それらの言語と同じ処理です。
           // Streamを繰り返し処理し、その結果から新しいStreamを作成します。
           // 1行で終わる場合、{}とreturn句は省略できます。
           // これは、.map(n -> n.doubleValue() / 2)とも書けます。
           .map(n -> {
               return n.doubleValue() / 2;
           })
           .forEach(System.out::println);

       System.out.println();
       System.out.println("1から各要素の数値まで連続した数値を表示します");
       Arrays.stream(numbers)

           // mapToObj … 基本はmapメソッドと同じです。
           //             元のStreamの型と異なるStreamを生成する場合に使用します。
           //             新しい型はおそらく型推論されていると思われます。
           .mapToObj(n -> {
               return IntStream.rangeClosed(1, n)
                       // mapToObjでint型をString型に変換します。
                       .mapToObj(String::valueOf)

                       // reduce … これもJavascript、Ruby、Perlなどがわかる人には説明不要です。それらの言語と同じ処理です。
                       //           繰り返し処理の結果を累積し、それを使用して新しいStreamを作成します。
                       //           以下の例だと、v1には前の処理結果(v1 + "," + v2)が代入されています。
                       .reduce((v1, v2) -> v1 + "," + v2)

                       // orElse … Optionalの中の値を取り出します。引数はデフォルト値で、Optionalが空の場合に取り出す値です。
                       //           get()という同様のメソッドがありますが、空の場合例外が発生してしまいます。
                       .orElse(StringUtils.EMPTY);
           })
           .forEach(System.out::println);



    }

    private class Sales {
        private String teamName;
        private List<Integer> kojinSales;

    }
}
