public class SafeInputTest {
    public static void main(String[] args)
    {
        SafeInputObj safeInputObj = new SafeInputObj();

        String s = safeInputObj.getNonZeroLenString("str");
        System.out.println(s);

        int i = safeInputObj.getRangedInt("Number 1-100", 1, 100);
        System.out.println(i);

        i = safeInputObj.getInt("Number");
        System.out.println(i);

        double d = safeInputObj.getRangedDouble("Number 1-10", 1, 100);
        System.out.println(d);

        d = safeInputObj.getDouble("Number");
        System.out.println(d);

        boolean b = safeInputObj.getYNConfirm("Y/N");
        System.out.println(b);

        s = safeInputObj.getRegExString("Enter a letter then number", "^[a-zA-Z].*[0-9]$");
        System.out.println(s);
    }
}
