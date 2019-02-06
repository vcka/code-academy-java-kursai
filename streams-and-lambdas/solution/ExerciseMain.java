public class ExerciseMain {

    public static void main(String[] args) {
        ShopService service = new DefaultShopService();

        print(service.getAllShops());

        System.out.println(service
                .getShopById(1,
                        () -> new ShopView(1, "DefaultShop")));

        System.out.println(service
                .getShopById(98,
                        () -> new ShopView(98, "DefaultShop")));
    }

    private static void print(Iterable iterable) {
        for (Object object : iterable) {
            System.out.println(object);

        }
        System.out.println("-----------------------------");
    }
}
