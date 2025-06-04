    // move all 0 elements of the SLL on the begining 
    
    
    import java.util.Scanner;


    class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    class SLL<E> {
        private SLLNode<E> first;

        public SLL() {
            this.first = null;
        }

        public void deleteList() {
            first = null;
        }

        public int length() {
            int ret;
            if (first != null) {
                SLLNode<E> tmp = first;
                ret = 1;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret++;
                }
                return ret;
            } else
                return 0;

        }

        @Override
        public String toString() {
            String ret = new String();
            if (first != null) {
                SLLNode<E> tmp = first;
                ret += tmp;
                while (tmp.succ != null) {
                    tmp = tmp.succ;
                    ret += "->" + tmp;
                }
            } else
                ret = "Prazna lista!!!";
            return ret;
        }

        public void insertFirst(E o) {
            SLLNode<E> ins = new SLLNode<E>(o, first);
            first = ins;
        }

        public void insertAfter(E o, SLLNode<E> node) {
            if (node != null) {
                SLLNode<E> ins = new SLLNode<E>(o, node.succ);
                node.succ = ins;
            } else {
                System.out.println("Dadenot jazol e null");
            }
        }

        public void insertBefore(E o, SLLNode<E> before) {
            if (first != null) {
                SLLNode<E> tmp = first;
                if (first == before) {
                    this.insertFirst(o);
                    return;
                }
                while (tmp.succ != before)
                    tmp = tmp.succ;
                if (tmp.succ == before) {
                    SLLNode<E> ins = new SLLNode<E>(o, before);
                    tmp.succ = ins;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
        }

        public void insertLast(E o) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (tmp.succ != null)
                    tmp = tmp.succ;
                SLLNode<E> ins = new SLLNode<E>(o, null);
                tmp.succ = ins;
            } else {
                insertFirst(o);
            }
        }

        public E deleteFirst() {
            if (first != null) {
                SLLNode<E> tmp = first;
                first = first.succ;
                return tmp.element;
            } else {
                System.out.println("Listata e prazna");
                return null;
            }
        }

        public E delete(SLLNode<E> node) {
            if (first != null) {
                SLLNode<E> tmp = first;
                if (first == node) {
                    return this.deleteFirst();
                }
                while (tmp.succ != node && tmp.succ.succ != null)
                    tmp = tmp.succ;
                if (tmp.succ == node) {
                    tmp.succ = tmp.succ.succ;
                    return node.element;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                    return null;
                }
            } else {
                System.out.println("Listata e prazna");
                return null;
            }
        }

        public SLLNode<E> getFirst() {
            return first;
        }

        public SLLNode<E> find(E o) {
            if (first != null) {
                SLLNode<E> tmp = first;
                while (tmp.element != o && tmp.succ != null)
                    tmp = tmp.succ;
                if (tmp.element == o) {
                    return tmp;
                } else {
                    System.out.println("Elementot ne postoi vo listata");
                }
            } else {
                System.out.println("Listata e prazna");
            }
            return first;
        }
        public void mirror() {
            if (first != null) {
                //m=nextsucc, p=tmp,q=next
                SLLNode<E> tmp = first;
                SLLNode<E> newsucc = null;
                SLLNode<E> next;

                while(tmp != null){
                    next = tmp.succ;
                    tmp.succ = newsucc;
                    newsucc = tmp;
                    tmp = next;
                }
                first = newsucc;
            }
        }
    }

    public class test1java {

        public static void change(SLL<Integer> list) {
        
        SLLNode<Integer> current = list.getFirst();
        

        while (current != null) {
            SLLNode<Integer> next = current.succ;

            if (current.element.equals(0)) {
                list.delete(current);
                list.insertFirst(0);
            }
            current = next;
        }
        
        
        
        
            /* SLLNode<Integer> curr = list.getFirst();     // e deklarojm listen SLL
            int index = 0;                           // e deklarojm nji variabel index per me gjet sa elemente jan te njejta me numrin br

            while (curr != null) {                   // fillojm me iteru (kalu) ne list
                if (curr.element.equals(br)) {       // nese 1 element asht i njejt me variablen br ather indexi rritet per 1
                    index++;
                }
                curr = curr.succ;                    // kjo perdoret konstant neper lista i bje sikur ne for loop ku e bojm i++, dmth me kalu ne elementin tjeter
            }

            if(index %2 == 0 ) {                     // nese numri i elementeve tnjejte me variablen br asht cift ose tek
                return;
            }

            curr = list.getFirst();                  // e inicializojm prej fillimit listen
            while (curr != null) {
                if (curr.element.equals(br)) {       // nese ka numer tnjejt me variablen br ne list
                    list.insertBefore(br, curr);     // ather at numer e qesim perpara atij elementi ne list
                    break;                           // e bojm break se qashtu kerkon detyra (duhet vetem numri i par qe asht i njejt me dal)
                }

                curr = curr.succ;
            }

            
            */
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner input = new Scanner(System.in);

            int n = input.nextInt();

            SLL<Integer> list = new SLL<Integer>();

            for(int i = 0; i<n; i++) {
                list.insertLast(input.nextInt());
            }

            change(list);
            System.out.println(list);
            
        }
    }
