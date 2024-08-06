package program.java8stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        //Supplier
        System.out.println(stringSupplier.get());
        //Function
        System.out.println(stringFunction.apply(10));
        //Predicate
        System.out.println(predicateListEmpty.test(new ArrayList()));
        //Consumer
        stringConsumer.accept("This is consumer Functional Interface example");
    }
    static Supplier<String> stringSupplier=()-> "This is supplier Functional Interface example";

    static Function<Integer,Long> stringFunction=a->a.longValue();

    static Predicate<List> predicateListEmpty=a->a.isEmpty();

    static Consumer<String> stringConsumer=a->System.out.println(a);


}

