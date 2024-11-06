package trythis;

public class ArrayedGeneralBook implements GeneralBook {
		private String[] names;
		private String[] records;
		private int size;

		public ArrayedGeneralBook(String[] intialNames, String[] intialRecords) {
				size = intialNames.length;
				names = new String[100];//초기 크기 변경
				records = new String[100];

				//초기 데이터 복사
				for (int i = 0; i < size; i++) {
						names[i] = intialNames[i];
						records[i] = intialRecords[i];
				}
		}

		public static void main(String[] args) {
				String[] names = {"Sam", "Rhee", "Kim"};
				String[] records = {"1111", "2222", "3333"};
				ArrayedGeneralBook gb = new ArrayedGeneralBook(names, records);
				System.out.println(gb.names());  //Sam Rhee Kim
				gb.add("Allan", "4444");
				gb.print();
				//Allan4444 \nKim3333\nRhee2222\nSam1111
				System.out.println("현재 저장된 데이터의 크기 : " + gb.size()); //4
				gb.add("Alex", "5555");
				System.out.println("현재 저장된 데이터의 크기 : " + gb.size()); //5
				gb.print();  //Alex5555\nAllan4444\nKim3333\nRhee2222\nSam1111\n
				//System.out.println(gb.nameExists("Alex")); //true
				gb.remove("Alex", "5555");
				gb.remove("Sam", "1111");
				gb.print();  //Allan4444\nKim3333\nRhee2222  String foundRecord = gb.get("Allan");  System.out.println(foundRecord); //4444
		}

		/**
		 * 추가 (add): 이름과 기록을 추가합니다.
		 * 제거 (remove): 이름과 기록을 삭제합니다.
		 * 이름 검색 (nameExists): 특정 이름이 존재하는지 확인합니다.
		 * 기록 가져오기 (get): 특정 이름에 대한 기록을 가져옵니다.
		 * 출력 (print): 배열에 저장된 데이터를 출력합니다.
		 * 크기 반환 (size): 현재 저장된 데이터의 크기를 반환합니다.
		 * intSize 함수는 name을 안 받는다.
		 */
		//names 배열에 저장된 모든 이름을 반환
		public String names() {
				return getString(names);
		}

		//records 배열에 저장된 모든 이름을 반환
		public String records() {
				return getString(records);
		}

		private String getString(String[] records) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < records.length; i++) {
						sb.append(names[i]);
						if (i < size - 1)
								sb.append("");
				}
				return sb.toString();
		}

		//추가(add)
		public void add(String name, String record) {
				if (this.nameExist(name)) {
						System.out.println(name + ": 이미 존재합니다!");
						return;
				}

				int len = this.size();
				String[] newNames = new String[len + 1];
				String[] newRecords = new String[len + 1];

				int idx = 0;
				for (String nm : this.names) {
						if (name.compareTo(nm) < 0) {
								newNames[idx++] = name;
								newRecords[idx++] = name;
						}
						newNames[idx++] = nm;
						newRecords[idx++] = nm;
				}
				if (idx < len) {
						newNames[idx] = name;
						newRecords[idx] = name;
				}
		}

		//이름이 있는지 확인한다.
		public boolean nameExist(String name) {
				for (int i = 0; i < size; i++) {
						if (names[i].equals(name))
								return true;
				}
				return false;
		}

		public void remove(String name, String record) {
				if (!this.nameExist(name)) {
						System.out.println(name + ": 존재하지 않는 이름입니다.");
						return;
				}
				int len = this.size() - 1;

				//[S]
				// for (int i = 0; i < size; i++) {
				// 		if (names[i].equals(name) && records[i].equals(record)) {
				// 				for (int j = i; j < size - 1; j++) {
				// 						names[j] = names[j + 1];
				// 						records[j] = records[j + 1];
				// 				}
				// 				names[size - 1] = null;
				// 				records[size - 1] = null;
				// 				size--;
				// 				break;
				// 		}
				// }
				//[E]
		}

		//특정 이름에 대한 '기록'가져오기
		public String get(String name) {
				for (int i = 0; i < size; i++) {
						if (names[i].equals(name))
								return records[i];
				}
				return null;
		}

		@Override
		public void print() {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < size; i++) {
						if (!sb.isEmpty()) {
								sb.append('\n');
						}
						sb.append(names[i]).append(records[i]);
				}
		}

		public void sort() {//todo 강사님 코드
				for (int i = 1; i < size; i++) {
						String keyName = names[i];                          //현재 정렬할 이름
						String keyRecord = records[i];
						int j = i - 1;                                          //이전 인덱스

						//이름을 비교해 정렬 위치를 찾음
						while (j >= 0 && names[j].compareTo(keyName) > 0) {
								names[j + 1] = names[j];                          // 오른쪽으로 이동
								records[j + 1] = records[j];                      // 오른쪽으로 이동
								j--;                                              // 이전 인덱스로 이동
						}
						names[j + 1] = keyName;
						records[j + 1] = keyRecord;
				}
		}

		@Override
		public int size() {
				return this.names.length;
		}
}
