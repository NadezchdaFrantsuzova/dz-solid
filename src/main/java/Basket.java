import java.util.Map;

public class Basket {
    protected Purchase[] purchases;

    public Basket(int productCount) {
        purchases = new Purchase[productCount];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            long costOfProduct = (long) purchase.count * prices.get(purchase.title);
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + costOfProduct + " руб.");
            sum += costOfProduct;
        }
        return sum;
    }
}
