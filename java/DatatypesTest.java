import java.util.Scanner;


class DatatypesTest {
    public static void main(String[] argh) {
        byte x = 0x7F;
        System.out.println(x);
        byte y = (byte)0xff;
        System.out.printf("%x\n",y);
        byte z = -12;
        z++;
        System.out.println(z> (byte)0x81);


//        for (byte i = -128; i <= 127 ; i++) {
//            System.out.printf("%d - %x \n",i,i);
//            System.out.println(i<128);
//            if(i==127){
//                break;
//            }
//        }

    }
}



