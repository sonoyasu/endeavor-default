
class Test {
    public static void main(String[] args)  {

        System.out.println("ソース融合テストです");

        //////Fused at 2024-03-26 15:57:46
        //////FUSIONSTART LogicA
        System.out.println("Hello Japan.");
        //////FUSIONEND LogicA

        //////Fused at 2024-03-26 15:57:52
        //////FUSIONSTART LogicB
        if(false) {
            System.out.println("LogicB");
        }
        //////FUSIONEND LogicB

        return;
    }
    
}

