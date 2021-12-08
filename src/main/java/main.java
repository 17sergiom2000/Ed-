import Exceptions.ElementNotComparableException;
import Exceptions.EmptyCollectionException;
import Exceptions.FullCollectionException;
import Lists.ArrayOrderedList;

import java.util.Iterator;


public class main{



    public static void main(String[] args) throws EmptyCollectionException, FullCollectionException, ElementNotComparableException {
        /*
        ArrayList<Point> a = new ArrayList<Point>();
        ArrayList<?> b;
        b = a;
        ((ArrayList<Point>) b).add(new Point(10,20));
        */

        /*
        String ola = "mfdkmfddkfdkf";
        String ola2 = "sjdhjiskjfkkdfdfdfkdfjfdh";
        String ola3 = "sjjjdh";
        String ola4 = "sjdhjiskdsjkjkjdsjksdjkkdfdffdfdkmddh";
        String ola5 = "sd";

        ArrayList<String> al = new ArrayList<String>();
        al.add(ola);
        al.add(ola2);
        al.add(ola3);
        al.add(ola4);
        al.add(ola5);

        MyComparator comparator = new MyComparator();


        Collections.sort(al,comparator);
        System.out.println(al);



        Media myMedia = new Media();

        myMedia.set(al);
        System.out.println(myMedia.get(0));
        */


    /*
        LinkedLists.LinkyList<String> list = new LinkedLists.LinkyList<String>();

        list.Add("1");
        list.Add("2");
        list.Add("3");
        list.Remove(0);
        list.printAll();

        System.out.println("---------------");

        LinkedLists.LinkyListSentinela<String> sentinelaList = new LinkedLists.LinkyListSentinela();


        sentinelaList.Add("10");
        sentinelaList.Add("11");
        sentinelaList.Add("12");

        sentinelaList.Remove("10");

        sentinelaList.printAll();

        */

        /*
        Stacks.ArrayStack<Integer> arrayStack = new Stacks.ArrayStack<>(5);

        for(int i=0;i<6;i++) {
            arrayStack.push(i);

        }



        try {
            arrayStack.pop();
            System.out.println(arrayStack.toString());
            System.out.println(arrayStack.size());
            System.out.println(arrayStack.peek());
        } catch (Exceptions.EmptyCollectionException e) {
            e.printStackTrace();
        }
        */


        /*
        Stacks.LinkedListStack<Integer> linkedListStack = new Stacks.LinkedListStack<>();


        for(int i=0;i<6;i++) {
            linkedListStack.push(i);
        }

        try {
            linkedListStack.pop();
            linkedListStack.pop();
            System.out.println(linkedListStack.size());
            System.out.println(linkedListStack.peek());
        } catch (Exceptions.EmptyCollectionException e) {
            e.printStackTrace();
        }
        */
        /*
        PostFixCalculator postFixCalculator = new PostFixCalculator();

        System.out.println(postFixCalculator.Calculate("631+/"));
        */
        /*
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<Integer>();

        linkedQueue.enqueue(1);


        linkedQueue.dequeue();





        System.out.println(linkedQueue.toString());


        CircularArrayQueue<Integer> circularArrayQueue = new CircularArrayQueue<Integer>();

        circularArrayQueue.enqueue(1);
        circularArrayQueue.enqueue(2);
        circularArrayQueue.enqueue(3);
        circularArrayQueue.enqueue(4);
        circularArrayQueue.enqueue(5);
        circularArrayQueue.enqueue(6);
        circularArrayQueue.enqueue(7);
        circularArrayQueue.enqueue(8);
        circularArrayQueue.enqueue(9);




        System.out.println(circularArrayQueue);
        */
        //EX 4
        /*
        CircularArrayQueue<Character> mensagem = new CircularArrayQueue<Character>();

        String s = "knowledge is power";
        CircularArrayQueue<Integer> chave = new CircularArrayQueue<Integer>();

        int[] arrayChave = new int[]{3,1,7,4,2,5};

        int j = 0;
        for(int i =0;i<s.length();i++) {
            mensagem.enqueue(s.charAt(i));
            if(j == arrayChave.length){
                j=0;
            }
            if(s.charAt(i) != ' '){
                chave.enqueue(arrayChave[j]);
                j++;
            }
        }

        System.out.println("Original" + mensagem);
        System.out.println("Chave" + chave);

        for(int i =0;i<s.length()-2;i++){
            //System.out.println(codificar((char)mensagem.dequeue(),(int)chave.dequeue()));
            mensagem.enqueue(codificar(mensagem.dequeue(),chave.dequeue()));
        }

        System.out.println("Codificada" + mensagem);
    }

    public static Object codificar(char character, int k) {
        if(character == ' '){
            return ' ';
        }
        for(int i = 0;i<k;i++){
            character++;
        }
        return character;
    }
    */
        ArrayOrderedList<Integer> arrayOrderedList = new ArrayOrderedList<>();

        arrayOrderedList.add(2);
        arrayOrderedList.add(0);
        arrayOrderedList.add(-2);
        arrayOrderedList.add(10);


        System.out.println(arrayOrderedList.printAll());


        Iterator it = arrayOrderedList.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());


        System.out.println(arrayOrderedList.printAll());


        //System.out.println(arrayOrderedList.printAll());
        //System.out.println(arrayOrderedList.remove(-2));



        //System.out.println(arrayOrderedList.printAll());





    }
}

