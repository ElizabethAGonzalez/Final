import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleData vehicleData = new VehicleData();

        // Prompt the user for vehicle data
        while (true) {
            System.out.println("Enter vehicle make (or 'quit' to finish):");
            String make = scanner.nextLine();
            if (make.equals("quit"))
                break;

            System.out.println("Enter vehicle model:");
            String model = scanner.nextLine();

            double milesPerGallon;
            while (true) {
                System.out.println("Enter miles per gallon (numeric value):");
                String mpgInput = scanner.nextLine();
                try {
                    milesPerGallon = Double.parseDouble(mpgInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                }
            }

            vehicleData.addVehicle(new Vehicle(make, model, milesPerGallon));
        }

        // Sort the vehicles by miles per gallon
        vehicleData.sortByMilesPerGallon();

        // Save the sorted data to a text file
        vehicleData.saveToFile("sorted_vehicle_data.txt");

        System.out.println("Data saved to sorted_vehicle_data.txt");
    }
}
