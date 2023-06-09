package chapter2.hotel.entity;

import java.util.List;
import java.util.Scanner;

public class Master {
    private Hotel hotel;
    private Scanner sc;

    public Master(Hotel hotel){
        this.hotel = hotel;
        sc = new Scanner(System.in);
    }

    public void displayAsset(){
        float asset = hotel.getAsset();
        System.out.println("호텔의 보유자산은 " + asset + "입니다.");
    }

    public void displayAllList(){

    }

}
