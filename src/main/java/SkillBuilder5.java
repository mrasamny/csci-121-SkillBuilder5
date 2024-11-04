import java.util.Random;

public class SkillBuilder5 {
    private static Random rand = new Random(17);

    public static boolean playCraps(){
        int roll = rand.nextInt(12)+1;
        if (roll == 2 || roll == 3 || roll == 12){
            return false;
        } else if (roll == 7 || roll == 11){
            return true;
        }
        int firstRoll = roll;
        boolean isDone = false;
        while (!isDone){
            roll = rand.nextInt(12) + 1;
            isDone = roll == 7 ||
                    roll == 11 ||
                    roll == firstRoll;
        }
        if (roll == 7 || roll == 11){
            return false;
        }
        return true;
    }

    private static void generateLevel(int level, int[] a){
        a[level] = 1;
        for(int index = level-1; index > 0; index--){
            a[index] = a[index] + a[index-1];
        }
    }

    private static String generateLevelString(int level, int[] a){
        int numOfBlankFields = a.length - level - 1;
        String result = "";
        for(int count = 0; count < numOfBlankFields; count++){
            result += String.format("%5s","");
        }
        for(int index = 0; index <= level; index++){
            result += String.format("%-5d%5s",a[index],"");
        }
        result += "\n";
        return result;
    }

    public static String pascalsTriangle(int n){
        if (n <= 0){
            return "";
        }
        int[] a = new int[n];
        String result = "";

        for(int level = 0; level < n; level++){
            generateLevel(level, a);
            result += generateLevelString(level,a);
        }

        return result;
    }


}