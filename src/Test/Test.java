package Test;

public class Test {
    public static void main(String[] args){
        for(int i = 0; i < 100; i++) {
            int r = (int) (Math.random() * 5 + 1);
            System.out.println(r);
        }
    }
}
