/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author cadelmonterde
 */
public class JavaLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaLambda hold =  new JavaLambda();
        List<String> names = new ArrayList<>();
        names.add("Billy");
        names.add("Mark");
        names.add("Jason");
        
        /**
         * The API for forEach states that 
         * "forEach(Consumer<? super T> action)
         * Performs the given action for each element of the Iterable until all
         * elements have been processed or the action throws an exception."
         * 
         * 
         * So the parameter to iterate is a "Consumer<generic type>" with an action
         * where in our case the action will be to display the elements of the list. 
         * for that we can use the Consumer Interface accept method and overwrite it
         * to display the element.
         */
        names.forEach(new Consumer<String>()
        {
            public void accept(String name)
            {
                System.out.println(name);
            }
        });
        
        
        System.out.println();
        
        
        
            /*LAMBDAAAAAA*/
        names.forEach((name) -> System.out.println(name));
        
        OwnLink<String> link = new OwnLink<>();
        link.append("test");
        link.append("test1");
        link.append("test2");
        link.append("test3");
        link.append("test4");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(link.removeHead().toString());
        /**
         * if i had to guess another way of writing the code above that makes more sense to me will be.
         */
//        Consumer<String> it = null; // = new Comsumer<>(); // its abstract cannot be instantiated????
////        it.accept(String t){} // WRONG because we are not overwriting the interface accept method...
//        String s = "";
//        names.forEach(it);
        }
//    @Override
//        public void accept(String s)
//        {
//            System.out.println(s);
//        }   
    
    
}
