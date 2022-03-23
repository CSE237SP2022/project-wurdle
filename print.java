

public class Print{
    public static void main(String[] args) {
        Print pb = new Print();
        pb.board();
    }
    public void board(){
        System.out.println("|");
        for(int i = 0; i<5; i++){
            System.out.print("- ");
        }
        System.out.println("|");
        for(int i = 0; i<5; i++){
            System.out.print("|");
            for (int j = 0; j<5; j++){
                System.out.print("- ");
            }
            System.out.println("-|");
        }
    }


}