import Exceptions.EmptyCollectionException;
import Stacks.LinkedListStack;

public class PostFixCalculator{
    private LinkedListStack<Double> arrayStack;

    public PostFixCalculator(){
        arrayStack = new LinkedListStack<Double>();
    }

    public double Calculate(String str) throws EmptyCollectionException {
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                arrayStack.push( (double) Character.getNumericValue(str.charAt(i)) );
            }else {
                double a=0,b=0;

                a = arrayStack.peek();
                arrayStack.pop();
                b = arrayStack.peek();
                arrayStack.pop();

                switch (str.charAt(i)){
                    case '+':
                        arrayStack.push(a+b);
                        break;
                    case '-':
                        arrayStack.push( a-b);
                        break;
                    case '*':
                        arrayStack.push(a*b);
                        break;
                    case '/':
                        arrayStack.push(a/b);
                        break;
                    default:
                        System.out.println("Invalid Character!");
                        break;
                }
            }
        }
        return arrayStack.peek();
    }

}
