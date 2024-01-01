import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dish {
	String type;

	// Constructor needs to have the same name as the class
	public Dish(String type) {
		this.type = type;
	}

	public boolean isRinsed() {
		System.out.println("Washing " + type);
		return true;
	}

	public boolean isClean() {
		return true;
	}

	// Overriding toString() method to provide a meaningful representation
	@Override
	public String toString() {
		return type; // Return the 'type' of the Dish
	}
}

public class Washing {
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		// Creating a Stack using the dirty dishes
		Stack<Dish> dirtyDishes = new Stack<>();
		// Creating a queue using the linkedlist
		Queue<Dish> rinsedDishes = new LinkedList<>();

		Dish plate = new Dish("Plate");
		Dish bowl = new Dish("Bowl");
		Dish fork = new Dish("Fork");
		Dish spoon = new Dish("Spoon");
		
		dirtyDishes.push(plate);
		dirtyDishes.push(bowl);
		dirtyDishes.push(fork);
		dirtyDishes.push(spoon);

		// Display Dirty Stack
		System.out.println("Dishes in the dirty stack: " + dirtyDishes);
		
		// Init choice to 0 to enter the loop
		int choice = 0;
		
		while (choice != 5) {
			System.out.println("Select an option:\n1. Rinse one dish\n2. Rinse all dishes\n"
					+ "3. Check Dishwasher Queue\n"
					+ "4. Start Dishwasher\n"
					+ "5. Exit\n");
			
			choice = scnr.nextInt();
			
			switch (choice) {
			
			// Wash only 1 dish
			case 1:
				if (!dirtyDishes.isEmpty()) {
					Dish topDish = dirtyDishes.pop();
					topDish.isRinsed();
					rinsedDishes.add(topDish);
					System.out.println("Remaining Dishes: " + dirtyDishes);
					System.out.println("Dishes in queue: " + rinsedDishes);
				} else {
					System.out.println("No more dishes to rinse.");
				}
				break;

			// Wash all the dishes
			case 2:
				while (!dirtyDishes.isEmpty()) {
					Dish dish = dirtyDishes.pop();
					if (dish.isRinsed()) {
						System.out.println(dish + " is clean");
						rinsedDishes.add(dish);
						System.out.println("Dishes in queue: " + rinsedDishes);
					} else {
						System.out.println(dish + " is still dirty");
					}
				}
				break;
			
			// Check dishes in queue	
			case 3:
				if (!rinsedDishes.isEmpty()) {
					System.out.println("Dishes ready for diswasher:\n" + rinsedDishes);
				}else {
					System.out.println("There are no dishes in the queue");
				}
				break;
				
			//	Start dishwasher
			case 4:
				 if (!rinsedDishes.isEmpty()) {
				        System.out.println("Starting dishwasher...");
				        while (!rinsedDishes.isEmpty()) {
				            Dish clean = rinsedDishes.remove();
				            if (clean.isClean()) {
				                System.out.println(clean + " is clean");
				            } else {
				                System.out.println("Error washing dishes");
				            }
				        }
				    } else {
				        System.out.println("No dishes in the queue to start the dishwasher.");
				    }
				    break;
			
			// End loop
			case 5:
				break;
			}
		}

	}

}
