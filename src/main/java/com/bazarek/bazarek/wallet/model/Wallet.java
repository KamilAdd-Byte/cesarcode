package com.bazarek.bazarek.wallet.model;

public class Wallet {
    private double myMoney;
    private static final double noMoney = 0.0;

    public Wallet() {
    }

    public double getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(double myMoney) {
        this.myMoney = myMoney;
    }

    public static double getNoMoney() {
        return noMoney;
    }

    public void addMoney(double money) {
        myMoney = money + myMoney;
    }

    public void buy (double money){
        checkYourMoney();
        if (money > myMoney){
            System.err.println("Chcesz kupić product za: "+ money+" STATUS :: Niewystarczająca ilość środków ---> masz: " + myMoney);
        }else
            myMoney = myMoney - money;
            System.out.println("Pozostało: " + myMoney);

    }

    private void checkYourMoney() {
        double price = 0;
        if (myMoney == 0){
            System.err.println("Brak środków");
        }else if (myMoney < price) {
            System.out.println("Nie masz tyle pieniędzy w portfelu");
        }
    }

    @Override
    public String toString() {
        String result = "Pieniędzy w portfelu: ";
        result += myMoney;
        return result;
    }
}




