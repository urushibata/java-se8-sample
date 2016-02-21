package cmds.java.se8.methoConRef;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * メソッド・コンストラクタ参照のサンプル.
 *
 * Step1
 * メソッド参照
 *
 * @author 漆畑 真也
 */
public class MethoConRefStep1 {

    public static void main(String... args) {
        List<Double> nums = Arrays.asList(2.2, 1.5, -3.0);

        System.out.println();
        System.out.println("Dump 数字リスト");
        // ■ インスタンスメソッド参照
        // Systemクラスのoutインスタンスのprintln(String)メソッドのメソッド参照です。
        //      System.out::println
        // メソッドの引数はforEachから受け取るリストの各要素を使用しています。
        nums
            .forEach(System.out::println);

        // [実行結果]
        // 2.2
        // 1.5
        // -3.0

        System.out.println();
        System.out.println("絶対値を表示する。");
        // ■ staticメソッド参照
        // Mathクラスのabs(double)メソッドのメソッド参照です。
        //      Math::abs
        // メソッドの引数はforEachから受け取るリストの各要素を使用しています。
        // mapはStreamに対して同一の処理を行い、新たなStreamを作るメソッドです。
        // 詳細はStreamを参照してください。
        nums.stream()
            .map(Math::abs)
            .forEach(System.out::println);

        // [実行結果]
        // 2.2
        // 1.5
        // 3.0

        System.out.println();
        System.out.println("昇順に表示する。(メソッド参照を使用)");
        // ■ インスタンスメソッドをクラス名から参照する。
        // この場合内部的には、sortedから受け取る2つの引数(d1, d2)を
        // d1.compareTo(d2)として処理します。
        nums.stream()
            .sorted(Double::compareTo)
            .forEach(System.out::println);

        // [実行結果]
        // -3.0
        // 1.5
        // 2.2

        System.out.println();
        System.out.println("昇順に表示する。(ラムダ式を使用)");
        nums.stream()
            .sorted((d1, d2) -> d1.compareTo(d2))
            .forEach(System.out::println);

        // [実行結果]
        // -3.0
        // 1.5
        // 2.2

        // 従業員クラス
        class Employee {
            String firstName;
            String secondName;
            Integer age;
            Integer generation;

            Employee(String firstName, String secondName, Integer age) {
                this.firstName = firstName;
                this.secondName = secondName;
                this.age = age;
            }

            Integer getAge() {
                return age;
            }

            void setGeneration() {
                this.generation = new BigDecimal(age)
                                    .setScale(-1, BigDecimal.ROUND_DOWN).intValue();
            }

            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
            };
        }

        // インスタンスメソッドのクラス名参照の使いどころ
        // JavaBeanから値を取得・設定する場合便利です。
        List<Employee> employees = Arrays.asList(
                new Employee("大沢", "一郎", 44),
                new Employee("高橋", "譲二", 28),
                new Employee("北島田", "三郎", 81));

        System.out.println();
        System.out.println("Dump 従業員リスト");
        employees.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("一番高い年齢の人を表示する");
        employees.stream()
            // Comparatorクラスのcomparingメソッドを使用してソートします。
            // comparingの第一引数はソートkey、第二引数は比較に使用するComparator型です。戻り値はComparator型です。
            // sortedの括弧内にはEmployeeクラスのインスタンスが渡されます(ラムダ式で書くと(emp -> …))。
            // ソートkeyに年齢を使用するので、メソッド参照を使用します(ラムダ式で書くと
            // (emp -> Comparator.comparing(emp.getAge(), Comparator.reverseOrder()))。
            .sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder()))

            // findFirst … Streamインターフェースのメソッドで、Streamの先頭を取得します。
            //              Optionalを返すので、メソッドチェーンをしてもヌルポの心配はありません。
            .findFirst()

            // ifPresent … Optionalが値を持っていれば、括弧内の処理を行います。
            .ifPresent(System.out::println);

        // [実行結果]
        // 北島田,三郎,80

        System.out.println();
        System.out.println("従業員に世代をセットする");
        // setterも同様にできます。
        // 引数を使う場合、方法がわからないので、この例は微妙です。
        employees.stream().forEach(Employee::setGeneration);

        System.out.println();
        System.out.println("Dump 従業員リスト(世代を設定)");
        employees.stream().forEach(System.out::println);

        // [実行結果]
        // 大沢,一郎,44,40
        // 高橋,譲二,28,20
        // 北島田,三郎,81,80
    }
}
