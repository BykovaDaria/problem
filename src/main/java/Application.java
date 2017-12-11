public class Application{

    private static final String ERROR = "error";

    public static void main(String[] args) {
        System.out.println(new Application().run());
    }

    private int Limit = 1000000;
    private boolean[] isSquare = new boolean[Limit];

    private String run() {
        for (int i = 0; i * i < isSquare.length; i++)
            isSquare[i * i] = true;

        for (int a = 3; a < Limit; a++) {
            int minB = (a % 2 == 0) ? 2 : 1;
            for (int b = minB; b < a; b += 2) {
                int x = (a * a + b * b) / 2;
                int y = (a * a - b * b) / 2;
                if (x <= y)
                    break;
                for (int c = (int)Math.floor(Math.sqrt(y)) + 1; ; c++) {
                    int z = c * c - y;
                    if (y <= z)
                        break;
                    if (isSquare[x + z] && isSquare[x - z] && isSquare[y - z])
                        return Integer.toString(x + y + z);
                }
            }
        }
        return ERROR;
    }
}
