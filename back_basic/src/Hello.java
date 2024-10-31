public class Hello {
    public static void main(String[] args) {
        String[] colors = new String[]{"blue", "red", "green"};

        //데이터가 있는 만큼 반복(for 문)
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }

        //for-each : 데이터가 있는 만큼 반복
        for (String s : colors) {
            System.out.println(s);

        }

    }

}
