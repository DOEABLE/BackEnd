package com.hana.greetings;

import org.w3c.dom.ls.LSOutput;

import com.sun.source.tree.SwitchTree;

public class Hi {
		public static void main(String[] args) {
				playSwitch();
		}

		private static void playSwitch() {

				int score = System.currentTimeMillis() % 2 == 0 ? 81 : 70;
				final String grade = score > 80 ? "A" : "C";
				switch (grade) {
						case "A":
								System.out.println('1');
								break;
						case "B":
								System.out.println('2');
								break;
						case "C":
								System.out.println('3');
								break;
						default:
								System.out.println("defalut!!");
				}
		}
}
