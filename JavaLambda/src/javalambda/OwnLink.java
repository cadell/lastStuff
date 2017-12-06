/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambda;

/**
 *
 * @author cadelmonterde
 */
public class OwnLink<E> 
{
    class Node
    {
        Node next;
        E t;
        public Node(E t)
        {
            this.t = t;
        }
    }
    Node head;
    public void append(E data)
    {
        if(head == null)
        {
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = new Node(data);
    }
    public void prepend(E data)
    {
        Node newHead;
        newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }
    
    public Object removeHead()
    {
        Object element;
        element = head.t;
        head = head.next;
        return element;
    }
    
}
