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


//constructor that initializes the semaphores
//the initialized semaphores will be used to give access to threads, threads that place dishes in buffer and threads that keep track of empty slots in the rack
        WetDishRack(int rackSize) {
            // add correct code here
            this.semaphore1 = new Semaphore(0);
            this.semaphore2 = new Semaphore(1);
            this.semaphore3 = new Semaphore(rackSize);
            this.rackSize = rackSize;
         
        }
//producer method
//semaphores acquires threads adds them to the buffer and then releases them
        public void addDish(int dish_id)  throws InterruptedException {
                // add correct code here
                semaphore3.acquire();
                semaphore2.acquire();
                buffer_size.add(dish_id);//adds dish to queue
                semaphore2.release();
                semaphore1.release();
        }
//consumer method 
//semaphores accuires threads, removes data from buffer and then releases them
        public int removeDish() throws InterruptedException {
                semaphore1.acquire();
                semaphore2.acquire();
                removeCounter = buffer_size.remove();//removes dish from queue
                semaphore2.release();
                semaphore3.release();
                return removeCounter; // replace with correct code here
        }
 
}

// references: Slides on vula (synchronization slides), a little book on semaphores and help
 


