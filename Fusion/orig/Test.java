
class Test {
    public static void main(String[] args)  {

        System.out.println("ソース融合テストです");

        //////FUSIONSTART LogicA
        System.out.println("Hello World.");
        //////FUSIONEND LogicA

        //////FUSIONSTART LogicB
        if(true) {
            System.out.println("LogicB");
        }
        //////FUSIONEND LogicB

        return;
    }
    
}

