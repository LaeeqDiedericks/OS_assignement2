import java.util.concurrent.Semaphore;
import java.util.*;

public class WetDishRack {
        // add variables
        Semaphore semaphore1;
        Semaphore semaphore2;
        Semaphore semaphore3;
        int rackSize;
        int removeCounter;
        Queue<Integer> buffer_size = new LinkedList<Integer>();



        WetDishRack(int rackSize) {
            // add correct code here
            this.semaphore1 = new Semaphore(0);
            this.semaphore2 = new Semaphore(1);
            this.semaphore3 = new Semaphore(rackSize);
            this.rackSize = rackSize;
         
        }
 
        public void addDish(int dish_id)  throws InterruptedException {
                // add correct code here
                semaphore3.acquire();
                semaphore2.acquire();
                buffer_size.add(dish_id);
                semaphore2.release();
                semaphore1.release();
        }
 
        public int removeDish() throws InterruptedException {
                semaphore1.acquire();
                semaphore2.acquire();
                removeCounter = buffer_size.remove();
                semaphore2.release();
                semaphore3.release();
                return removeCounter; // replace with correct code here
        }
 
}

// references: Slides on vula (synchronization slides), a little book on semaphores and help
 


