package com.kimdohee.assignment.bookstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookStoreManager {
		ArrayList<Book> books = new ArrayList<>();
		Cart cart = new Cart();
		Scanner scanner = new Scanner(System.in);

		public void main(String[] args) {
				BookStoreManager manager = new BookStoreManager();

				// 1. 도서 정보 초기화
				manager.initializeBooks();
				manager.printAllBooks();

				// 2. 사용자 정보 입력
				User user = manager.getUserInfo();
				while (true) {
						System.out.printf("""
								---------------------------------------
								오늘의 선택, 코난문고
								영원한 스테디셀러, 명탐정 코난시리즈를 만나보세요~     
								---------------------------------------
								1. 고객정보 확인하기
								2. 장바구니 상품 목록 보기
								3. 바구니에 항목 추가하기
								4. 장바구니의 항목 삭제하기
								5. 장바구니 비우기
								6. 영수증 표시하기
								7. 종료
								---------------------------------------%n
								""");
						System.out.print("메뉴 번호를 선택해주세요:");
						int menu = scanner.nextInt();

						switch (menu) {
								case 1 -> System.out.println("현재 고객 정보:" + user);  // 고객 정보 확인
								case 2 -> manager.viewCart();  // 장바구니 상품 목록 보기
								case 3 -> {
										manager.printAllBooks();
										scanner.nextLine();
										System.out.printf("추가할 도서 ID를 입력하세요: ");
										String bookId = scanner.nextLine();
										boolean validInput = false;
										while (!validInput) {
												System.out.print("장바구니에 추가하시겠습니까? Y|N: ");
												String yesOrNo = scanner.nextLine();

												if (yesOrNo.equalsIgnoreCase("y")) {
														manager.addToCart(bookId);  // 장바구니에 항목 추가하기
														manager.viewCart();
														validInput = true;
												} else if (yesOrNo.equalsIgnoreCase("n")) {
														System.out.println("장바구니에 추가하지 않았습니다.");
														validInput = true;
												} else {
														System.out.println("잘못된 입력입니다. Y 또는 N을 입력해주세요.");
												}
										}
								}
								case 4 -> {
										manager.viewCart();
										if (manager.cart.isEmpty()) {
												System.out.println("장바구니가 비어 있어 메인 메뉴로 돌아갑니다.");
												continue;  // 현재 반복을 종료하고 while 루프의 다음 반복으로 넘어갑니다.
										}
										System.out.print("장바구니에서 삭제할 도서 ID를 입력하세요: ");
										scanner.nextLine();
										String bookId = scanner.nextLine();
										manager.removeFromCart(bookId);  // 장바구니 항목 삭제하기
								}
								case 5 -> manager.clearCart();  // 장바구니 비우기
								case 6 -> {
										manager.showReceipt(user);  // 영수증 표시하기
								}
								case 7 -> {
										System.out.println("프로그램을 종료합니다.");
										scanner.close();
										return;
								}
								default -> System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 선택해주세요.");
						}

				}
		}

		public void initializeBooks() {
				books.add(new Book("ISBN1234", "셜록홈즈", 20000, "코난 도일", "그 누구도 뛰어넘지 못했던 추리 소설의 고전", "추리소설", new Date()));
				books.add(new Book("ISBN2345", "도리안 그레이의 초상", 16000, "오스카 와일드", "예술을 위한 예술", "고전소설", new Date()));
				books.add(new Book("ISBN3456", "쥐덫", 27000, "애거서 크리스티", "폭설 속에 갇힌 몽스웰 여관-네명의 손님과 주인 부부, 그리고 한 명의 형사", "추리소설",
						new Date()));
		}

		public User getUserInfo() {
				System.out.print("당신의 이름을 입력하세요: ");
				String name = scanner.nextLine();

				System.out.print("연락처를 입력하세요: ");
				String phone = scanner.nextLine();

				User user = new User(name, phone);
				return user;
		}

		public void printAllBooks() {
				System.out.println("=== 보유 도서 목록 ===");
				for (Book book : books) {
						System.out.println(book);
				}
		}

		public void addToCart(String id) {
				for (Book book : books) {
						if (book.id.equals(id)) {
								cart.addItem(book);
								return;
						}
				}
				System.out.println("해당 ID의 도서가 보유 목록에 없습니다.");
		}

		// 장바구니 항목 삭제하기
		public void removeFromCart(String id) {
				cart.removeItem(id);
		}

		// 장바구니 비우기
		public void clearCart() {
				cart.clearCart();
		}

		// 장바구니 상품 목록 보기
		public void viewCart() {
				cart.viewCart();
		}

		// 영수증 표시하기
		public void showReceipt(User currentUser) {
				cart.showReceipt(currentUser);
		}
}
