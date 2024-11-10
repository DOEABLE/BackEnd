package trythis.arraybook;

public class ArrayedGeneralBook implements GeneralBook {
    String[] names;
    String[] records;

    public ArrayedGeneralBook(String[] names, String[] records) {
        this.names = names;
        this.records = records;
        this.sort();
    }

    public static void main(String[] args) {
        String[] names = {"Sam", "Rhee", "Kim"};
        String[] records = {"1111", "2222", "3333"};
        ArrayedGeneralBook gb = new ArrayedGeneralBook(names, records);
        System.out.println(gb.names());    //Sam Rhee Kim
        gb.add("Allan", "4444");
        gb.print();
        System.out.println("현재 저장된 데이터의 크기 : " + gb.size());
        gb.print();
        gb.remove("Alex", "5555");
        gb.remove("Sam", "1111");
        gb.print();
        gb.add("Alex", "5555");
        gb.print();
    }

    @Override
    public int size() {
        return this.names.length;
    }

    @Override
    public String names() {
        StringBuilder sb = new StringBuilder();
        for (String nm : this.names) {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(nm);
        }
        return sb.toString();
    }

    @Override
    public String records() {
        return String.join(" ", this.records);
    }

    @Override
    public boolean nameExist(String name) {
        for (String nm : this.names) {
            if (nm.equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(String name, String record) {
        if (this.nameExist(name)) {
            System.out.println(name + " : 이미 존재합니다!");
            return;
        }

        int len = this.size() + 1;
        String[] newNames = new String[len];
        String[] newRecords = new String[len];

        int idx = 0;
        boolean didAdd = false;
        for (String nm : this.names) {
            if (!didAdd && name.compareTo(nm) < 0) {
                System.out.println(nm + ", name = " + name + ", record = " + record);
                newRecords[idx] = record;
                newNames[idx++] = name;
                didAdd = true;
            }
            newRecords[idx] = this.records[idx - 1];
            newNames[idx++] = nm;

        }
        // if (idx < len) {
        if (!didAdd) {
            newRecords[idx] = record;
            newNames[idx] = name;
        }

        this.names = newNames;
        this.records = newRecords;
    }

    @Override
    public void remove(String name, String record) {
        if (!this.nameExist(name)) {
            System.out.println(name + " : 존재하지 않는 이름입니다!");
            return;
        }

        int len = this.size() - 1;
        String[] newNames = new String[len];
        String[] newRecords = new String[len];

        for (int i = 0; i < len + 1; i++) {
            if (names[i].equals(name)) {
                continue;
            }
            newNames[i] = names[i];
            newRecords[i] = records[i];
        }

        this.names = newNames;
        this.records = newRecords;
    }

    @Override
    public String get(String name) {
        if (!nameExist(name)) {
            System.out.println("존재하지 않는 이름입니다!");
            return "";
        }

        for (int i = 0; i < this.size(); i++) {
            if (names[i].equals(name)) {
                return records[i];
            }
        }

        return "";
    }

    private void swap(int a, int b) {
        String tmpName = names[a];
        String tmpRecord = records[a];
        names[a] = names[b];
        records[a] = records[b];
        names[b] = tmpName;
        records[b] = tmpRecord;
    }

    @Override
    public void sort() {
        int len = this.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (names[j].compareTo(names[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            if (!sb.isEmpty()) {
                sb.append('\n');
            } else {
                sb.append("\n----------------------\n");
            }
            sb.append(names[i]).append(records[i]);
        }
        sb.append("\n-------------------------\n");

        System.out.println(sb);
    }

}