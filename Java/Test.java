import java.util.Date;
import java.text.SimpleDateFormat;

class Test {
    public static void main(String[] args)  {

        System.out.println("標準Javaのテストです");

        // LogicA
        var now = new Date();
        System.out.println((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(now));        
        System.out.println("Hello World.");

        // LogicB
        if(true) {
            System.out.println("LogicB");
        }

        return;
    }
    
}

