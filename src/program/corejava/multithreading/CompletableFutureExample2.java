package program.corejava.multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample2 {
    public static void main(String[] args) {
        completableSupplyAsync();
    }
    private static void completableSupplyAsync() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApplyAsync(result1 -> result1 * 2)
                .thenApplyAsync(result2 -> result2 + 5);

        future.thenAccept(finalResult -> System.out.println(finalResult));

        CompletableFuture<Integer> futureThrows = CompletableFuture.supplyAsync(() -> {
            int result = 10 / 0; // Causes an ArithmeticException
            return result;
        });

        futureThrows.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return 0; // Default value to return if there's an exception
        }).thenAccept(result -> {
            System.out.println("Result: " + result);
        });
    }
}
