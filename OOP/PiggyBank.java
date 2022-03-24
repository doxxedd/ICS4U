package OOP;

import java.util.ArrayList;

public class PiggyBank {
    
    private ArrayList<Coin> coinList = new ArrayList<Coin>();

    public void addCoin(Coin newCoin) {
        coinList.add(newCoin);
    }

    public void removeCoins(Coin newCoin) {
        coinList.remove(newCoin);
    }

    public double totalAmount() {
        double amount = 0;
        for (Coin coin : coinList) {
            amount += coin.getValue();
        }
        return amount;
    }
}
