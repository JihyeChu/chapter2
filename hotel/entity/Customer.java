package chapter2.hotel.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private String id;
    private String name;
    private String phoneNum;
    private float wallet;

    private List<Reservation> reservationList;

    private Room room;
    public Customer(){
        reservationList = new ArrayList<>();
        room = new Room();
    }
    public Customer(String id, String name, String phoneNum, float wallet){
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.wallet = wallet;
    }

    public String reserve(){
        // 호텔 예약하기(예약번호 반환)
        id = UUID.randomUUID().toString();
        return id;
    }

    public void checkReserve(int id){
        // 예약 번호(id)로 예약 내역 조회
    }

    public void cancelReserve(int id){
        // 예약 번호(id)로 예약 내역 취소
    }

    public void minusWallet(){
        // 숙박비를 제외한 소지금
//        wallet -= room.getRoom();
    }

}
