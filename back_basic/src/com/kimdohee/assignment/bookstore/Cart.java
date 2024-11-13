package com.kimdohee.assignment.bookstore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cart {
		Scanner scanner = new Scanner(System.in);
		private ArrayList<Book> cartItems = new ArrayList<>();

		//test
		public void testCart() {
				cartItems.add(new Book("123", "마루는 강쥐", 50000, "코난 도일", "그 누구도 뛰어넘지 못했던 추리 소설의 고전", "추리소설", new Date()));
				cartItems.add(new Book("234", "미래소년 코난", 16000, "오스카 와일드", "예술을 위한 예술", "고전소설", new Date()));
				cartItems.add(new Book("345", "피니핑", 27000, "애거서 크리스티", "폭설 속에 갇힌 몽스웰 여관-네명의 손님과 주인 부부, 그리고 한 명의 형사", "추리소설",
						new Date()));
		}

		@Override
		public String toString() {
				StringBuilder sb = new StringBuilder("장바구니: ");
				return "Cart{cartItems=" + cartItems + '}';
		}

		// 장바구니에 항목 추가
		public void addItem(Book book) {
				cartItems.add(book);
				System.out.println(book.title + "이(가) 장바구니에 추가되었습니다.");
		}

		// 장바구니에서 항목 삭제
		public void removeItem(String id) {
				for (Book book : cartItems) {
						if (book.id.equals(id)) {
								cartItems.remove(book);
								System.out.println(book.title + "이(가) 장바구니에서 삭제되었습니다.");
								return;
						}
				}
				System.out.println("해당 ID의 항목이 장바구니에 없습니다.");
		}

		// 장바구니 비우기
		public void clearCart() {
				cartItems.clear();
				System.out.println("장바구니가 비워졌습니다.");
		}

		// 장바구니 상품 목록 보기
		public void viewCart() {
				if (cartItems.isEmpty()) {
						System.out.println("장바구니가 비어 있습니다.\n");
				} else {
						System.out.println("=== 장바구니 상품 목록 ===");
						for (Book book : cartItems) {
								System.out.println(book);
						}
				}
		}

		public boolean isEmpty() {
				return cartItems.isEmpty();
		}

		// 영수증 표시
		public void showReceipt(User currentUser) {
				if (cartItems.isEmpty()) {
						System.out.println("구매물품을 장바구니에 담아주세요!\n");
						return;
				}

				System.out.print("배송지를 입력하세요: ");
				String address = scanner.nextLine();

				// 배송받을 사람 정보 확인
				System.out.printf("배송받을 사람이 현재 고객명(%s)과 일치합니까? (Y/N): ", currentUser.name);
				String isSameRecipient = scanner.nextLine().trim().toUpperCase();

				String recipientName = currentUser.name;
				String recipientPhone = currentUser.phone;

				if ("N".equalsIgnoreCase(isSameRecipient)) {
						System.out.print("배송받을 사람의 이름을 입력하세요: ");
						recipientName = scanner.nextLine();

						System.out.print("배송받을 사람의 연락처를 입력하세요: ");
						recipientPhone = scanner.nextLine();
				}

				//영수증 출력
				double total = 0;
				int itemCount = 0;

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String currentDate = dateFormat.format(new Date());

				System.out.println("");
				System.out.printf("""
						=== 영수증 ===
						수령인: %s  연락처: %s 
						배송지: %s  발송일: %s
						---------------------------------------
						""".formatted(recipientName, recipientPhone, address, currentDate));
				System.out.println("");

				for (Book book : cartItems) {
						System.out.printf("도서명: %s | 가격:%.0f원\n", book.title, book.price);
						total += book.price;
						itemCount++;
				}
				System.out.println("---------------------------------------");
				System.out.printf("총 품목 수량: %d개\n", cartItems.size());
				System.out.printf("총 가격: %.0f원\n", total);
		}
}
