package trythis.arraybook;

public interface GeneralBook {
    public int size();

    public String names();

    public String records();

    public void add(String name, String record);

    public void remove(String name, String record);

    public boolean nameExist(String name);

    public String get(String name);

    //단순한 삽입정렬 알고리즘
    public void sort();

    public void print();
}
