package demos.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

//Class representing a complex calculation task
class ComplexCalculation implements Callable<Integer> {
 private String taskName;
 private Random random;
 
 public ComplexCalculation(String taskName) {
     this.taskName = taskName;
     this.random = new Random();
 }
 
 @Override
 public Integer call() throws Exception {
     System.out.println(taskName + " starting calculation...");
     
     // Simulate complex work
     int calculationTime = random.nextInt(3000) + 1000; // 1-4 seconds
     Thread.sleep(calculationTime);
     
     // Simulate result calculation
     int result = random.nextInt(100) + 1;
     
     System.out.println(taskName + " completed after " + calculationTime + "ms");
     return result;
 }
}
