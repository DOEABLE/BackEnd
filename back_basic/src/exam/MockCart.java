package exam;

import java.util.ArrayList;
import java.util.List;

public class MockCart extends Cart {
    private List<Book> items;

    public MockCart() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Book book) {
        items.add(book);
        System.out.println(book.title + "이(가) Mock 장바구니에 추가되었습니다.");
    }

    @Override
    public void removeItem(String id) {
        items.removeIf(item -> item.id.equals(id));
        System.out.println("ID가 " + id + "인 도서가 Mock 장바구니에서 삭제되었습니다.");
    }

    @Override
    public void clearCart() {
        items.clear();
        System.out.println("Mock 장바구니가 비워졌습니다.");
    }

    @Override
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Mock 장바구니가 비어있습니다.");
        } else {
            System.out.println("=== Mock 장바구니 내용 ===");
            for (Book item : items) {
                System.out.println(item);
            }
        }
    }

    // 테스트를 위한 추가 메소드
    public int getItemCount() {
        return items.size();
    }

    public boolean containsBook(String id) {
        return items.stream().anyMatch(book -> book.id.equals(id));
    }
}