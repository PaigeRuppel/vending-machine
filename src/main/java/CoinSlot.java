public class CoinSlot {

    public int acceptPayment(String coin) {
        if (!coin.equals("nickel") && !coin.equals("dime")) {
            return 25;
        }
        return (coin.equals("nickel") ? 5 : 10);
    }


}
