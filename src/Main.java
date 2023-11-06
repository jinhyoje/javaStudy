public class Main {
    public static void main(String[] args) {
        Member member = new Member();

        member.name = "홍길동";

        member.phone = 1012341344;

        member.addr = Loc.Kor + " 서울시 특별시";

        member.indroduce(); // 대한민국 서울시 특별시 사는 홍길동이고 전화번호는 010-1234-1344 입니다.
    }
}