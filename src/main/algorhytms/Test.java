package algorhytms;

public class Test {
    public static void main(String[] args) {
        int[] x = {1, 2};
        x[0] = 42;
        int[] y = x;
        y[0] = 43; // 43, 2
        System.out.println(x[0]); // что?
        f(x);
        System.out.println(x[0]); // что?
    }
    static void f(int[] z) { //43, 2
        z[0] += 1; //44
    }
}
