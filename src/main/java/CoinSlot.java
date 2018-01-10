public class CoinSlot {

    public int acceptPayment(String coin) {

        return (coin.equals("nickel") ? 5 : 10);
    }


}
