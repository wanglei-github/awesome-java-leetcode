package easy._001;

public class InnerStatic {

    private static Integer a = 1;
    private static InnerStatic innerStatic;
    private Integer b = 1;

    public static InnerStatic getInnerStatic() {
        return InnerHolder.innerStatic;
    }

    private static class InnerHolder {
        private static InnerStatic innerStatic = new InnerStatic();
    }
}
