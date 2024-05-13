import java.util.LinkedList;
import java.util.ListIterator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VehicleData {
    private LinkedList<Vehicle> vehicles;

    public VehicleData() {
        vehicles = new LinkedList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void sortByMilesPerGallon() {
        vehicles.sort((v1, v2) -> Double.compare(v1.getMilesPerGallon(), v2.getMilesPerGallon()));
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            ListIterator<Vehicle> iterator = vehicles.listIterator();
            while (iterator.hasNext()) {
                Vehicle vehicle = iterator.next();
                writer.write(vehicle.getMake() + ", " + vehicle.getModel() + ", " + vehicle.getMilesPerGallon() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
