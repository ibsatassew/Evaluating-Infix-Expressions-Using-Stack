/** Definition of a singly linked list node

      Source: "A Practical Introduction to Data
      Structures and Algorithm Analysis, 3rd Edition (Java)" 
      by Clifford A. Shaffer
*/

class Link<E> {
   private E element;        // Value for this node
   private Link<E> next;     // Pointer to next node in list

   // Constructors
   Link(E it, Link<E> nextval) { 
      element = it;  
      next = nextval; 
   }

   Link(Link<E> nextval) { 
      next = nextval; 
   }

   // return next Link
   Link<E> next() { 
      return next; 
   }  

   // Set next field
   Link<E> setNext(Link<E> nextval) { 
      return next = nextval; 
   }     

   // Get element field
   E element() { 
      return element; 
   }  

   // Set element field
   E setElement(E it) { 
      return element = it; 
   } 
}
