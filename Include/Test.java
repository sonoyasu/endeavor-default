
class Test {
    public static void main(String[] args)  {

        System.out.println("ソース融合テストです");

        //////Include at 2024-03-25 15:24:06
        //////FUSIONSTART LogicA
        System.out.println("Hello Japan.");
        //////FUSIONEND LogicA

        //////Include at 2024-03-25 15:24:08
        //////FUSIONSTART LogicB
        if(false) {
            System.out.println("LogicB");
        }
        //////FUSIONEND LogicB

        return;
    }
    
}

