import java.util.*;

class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            if(input.length()%2==1){
                System.out.println(false);
                continue;
            }
            //Complete the code
            Stack<Character> stringStack = new Stack<>();
            char[] chars = input.toCharArray();
            boolean isBalance = true;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == "(".toCharArray()[0] || chars[i] == "[".toCharArray()[0] || chars[i] == "{".toCharArray()[0]) {
                    stringStack.push(chars[i]);
                }
                try {


                    if (chars[i] == ")".toCharArray()[0]) {
                        if (stringStack.pop() != "(".toCharArray()[0]) {
                            isBalance = false;
                            break;
                        }
                    }
                    if (chars[i] == "[".toCharArray()[0]) {
                        if (stringStack.pop() != "[".toCharArray()[0]) {
                            isBalance = false;
                            break;
                        }
                    }
                    if (chars[i] == "}".toCharArray()[0]) {
                        if (stringStack.pop() != "{".toCharArray()[0]) {
                            isBalance = false;
                            break;
                        }
                    }
                }catch (EmptyStackException e){
                    isBalance = false;
                }

            }

            System.out.println(isBalance);
        }
    }

}



