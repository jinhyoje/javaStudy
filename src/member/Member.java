package member;

public class Member {
    String name;
    String addr;
    int phone;

    String formatPhoneNumber(int phone) {
        String phoneNumberStr = String.valueOf(phone); // int를 문자열로 변환
        String formattedNumber = "0" + phoneNumberStr.substring(0, 2) + "-" + phoneNumberStr.substring(2, 6) + "-" + phoneNumberStr.substring(6);

        return formattedNumber;
    }



    public void indroduce() {
        System.out.println(addr + " 사는 " + name + "이고 전화번호는 " + formatPhoneNumber(phone)  + " 입니다.");
        // 대한민국 서울시 특별시 사는 홍길동이고 전화번호는 010-1234-1344 입니다.
    }

}
