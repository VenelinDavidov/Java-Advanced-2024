import java.util.Scanner;

public class Iterators_Comparators_Notes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Това са записки от лекция!!!

        // 1) Variable Arguments -> сигнатура на метод, която може да подаваме 0 или множество аргумнети
        // от един и същи тип;

        // static void display (String ... values){
        // System.out.println ("display method invoke")}
        // static void main(){
        // display ()
        // display ("first")
        // display ("first", "second");


        // A) Iterable -> метод за обхождане на данни за всяко нещо!
        // Iterator -> инструмента за обхождане (как да бъде обходено)
        // -> всяка една колекция в java може да бъде обходена!!
        // * Root interface of the java collections class!

        // public interface Iterable<T>{
        // public Iterator <T> iterator()

        // B) Comparable -> метод чрез който сравняваме (нещо е сравнимо)
        // Comparator ->  инструмента чрез който сравняваме (нещо, което сравнява) два елемента от
        // един и същи тип.


    }
}