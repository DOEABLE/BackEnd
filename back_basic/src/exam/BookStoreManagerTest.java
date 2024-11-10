package exam;

public class BookStoreManagerTest {
    public static void main(String[] args) {
        BookStoreManager manager = new BookStoreManager();
        manager.cart = new Cart(); // 원래의 Cart 대신 MockCart 사용

        // 도서 초기화
        manager.initializeBooks();
        manager.printAllBooks();


        // 테스트 1: 장바구니에 도서 추가
        manager.addToCart("ISBN1234");
        assert ((MockCart) manager.cart).getItemCount() == 1 : "장바구니에 1개의 아이템이 있어야 합니다.";
        assert ((MockCart) manager.cart).containsBook("ISBN1234") : "ISBN1234 도서가 장바구니에 있어야 합니다.";

        // 테스트 2: 존재하지 않는 도서 추가 시도
        manager.addToCart("INVALID_ISBN");
        assert ((MockCart) manager.cart).getItemCount() == 1 : "장바구니에 여전히 1개의 아이템만 있어야 합니다.";

        // 테스트 3: 장바구니에서 도서 제거
        manager.removeFromCart("ISBN1234");
        assert ((MockCart) manager.cart).getItemCount() == 0 : "장바구니가 비어있어야 합니다.";

        // 테스트 4: 여러 도서 추가 후 장바구니 비우기
        manager.addToCart("ISBN1234");
        manager.addToCart("ISBN2345");
        assert ((MockCart) manager.cart).getItemCount() == 2 : "장바구니에 2개의 아이템이 있어야 합니다.";
        manager.clearCart();
        assert ((MockCart) manager.cart).getItemCount() == 0 : "장바구니가 비어있어야 합니다.";

        System.out.println("모든 테스트가 통과되었습니다.");
    }
}