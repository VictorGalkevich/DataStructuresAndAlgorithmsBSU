import java.util.Random;

public class Testing {
    public static void main(String[] args) {
        while (true) {
            try {
                Random random = new Random();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 1000; i++) {
                    int nexted = random.nextInt(50);
                    builder.append(nexted).append(" ");
                    Task33.insert(nexted);
                    ThirtyThirdTask.insert(nexted);
                }
                ThirtyThirdTask.MIN.length = 0;
                Task33.MIN.length = 0;
                Task33.MIN.min = Task33.MAX;
                ThirtyThirdTask.MIN.min = ThirtyThirdTask.MAX;
                ThirtyThirdTask.calculate(ThirtyThirdTask.ROOT);
                Task33.calculate(Task33.ROOT);
                ThirtyThirdTask.cut(ThirtyThirdTask.ROOT);
                Task33.cut(Task33.ROOT);
                ThirtyThirdTask.preOrderTraversal(ThirtyThirdTask.ROOT);
                Task33.preOrderTraversal(Task33.ROOT);
                if (!ThirtyThirdTask.builder.toString().equals(Task33.builder.toString())) {
                    System.out.println("ERROR");
                    System.out.println("NEW: " + ThirtyThirdTask.builder.toString());
                    System.out.println("OLD: " + Task33.builder.toString());
                    System.out.println("NUMBERS: " + builder);
                    System.exit(0);
                } else {
                    ThirtyThirdTask.MIN = new ThirtyThirdTask.Node();
                    ThirtyThirdTask.ROOT = null;
                    ThirtyThirdTask.builder = new StringBuilder();
                    Task33.MIN = new Task33.CringeNode();
                    Task33.ROOT = null;
                    Task33.builder = new StringBuilder();
                }
            } catch (Exception e) {
                ThirtyThirdTask.MIN = new ThirtyThirdTask.Node();
                ThirtyThirdTask.ROOT = null;
                ThirtyThirdTask.builder = new StringBuilder();
                Task33.MIN = new Task33.CringeNode();
                Task33.ROOT = null;
                Task33.builder = new StringBuilder();
            }
        }
    }
}
