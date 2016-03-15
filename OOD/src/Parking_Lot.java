import java.util.ArrayList;

public class Parking_Lot {
	public enum VehicleSize{
		Motorcycle, Compact, Large
	}
	
	public abstract class Vehicle {
		protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot> ();
		protected String licensePlate;
		protected int spotsNeeded;
		protected VehicleSize size;
		
		public int getSpotsNeeded() {
			return this.spotsNeeded;
		}
		
		public VehicleSize getSize() {
			return this.size;
		}
		
		public void parkInSpot(ParkingSpot s) {
			if (canFitInSpot(s)) {
				parkingSpots.add(s);
			}
		}
		
		public void clearSpots() {
			// ...
		}
		
		public abstract boolean canFitInSpot(ParkingSpot s);
	}
	
	public class Bus extends Vehicle{
		public Bus() {
			spotsNeeded = 5;
			size = VehicleSize.Large;
		}
		
		public boolean canFitInSpot(ParkingSpot s) {
			if (!s.isAvailable()) {
				return false;
			}
			return s.canFitVehicle(this);
		}
	}
	
	public class Car extends Vehicle {
		public Car() {
			spotsNeeded = 1;
			size = VehicleSize.Compact;
		}
		
		public boolean canFitInSpot(ParkingSpot s) {
			// ...
			return true;
		}
	}
	
	public class Motorcycle extends Vehicle {
		public Motorcycle() {
			spotsNeeded = 3;
			size = VehicleSize.Motorcycle;
		}
		
		public boolean canFitInSpot(ParkingSpot s) {
			// ...
			return true;
		}
	}
	
	public class ParkingSpot {
		private Vehicle vehicle;
		private VehicleSize spotSize;
		private int row;
		private int spotNumber;
		private Level level;
		
		public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
			this.level = lvl;
			this.row = r;
			this.spotNumber = n;
			this.spotSize = s;
		}
		
		public boolean isAvailable() {
			return vehicle == null;
		}
		
		public boolean canFitVehicle(Vehicle vehicle) {
			if (vehicle.getSpotsNeeded() <= this.spotNumber) {
				return true;
			}
			return false;
		}
		
		public boolean park(Vehicle v) {
			// ...
			return true;
		}
		
		public int getRow() {
			return this.row;
		}
		
		public int getSpotNumber() {
			return this.spotNumber;
		}
		
		public void removeVehicle() {
			this.vehicle = null;
			// ...
		}
	}
	
	public class ParkingLot {
		private Level[] levels;
		private final int NUM_LEVLES = 5;
		
		public ParkingLot() {
			// ...
		}
		
		public boolean parkVehicle(Vehicle vehicle) {
			// ...
			return true;
		}
	}
	
	public class Level {
		private int floor;
		private ParkingSpot[] spots;
		private int availableSpots = 0;
		private static final int SPOTS_PER_ROW = 10;
		
		public Level(int floor, int numberOfSpots) {
			this.floor = floor;
			this.spots = new ParkingSpot[numberOfSpots];
			// ...
		}
		
		public int availableSpots() {
			return this.availableSpots;
		}
		
		public boolean parkVehicle(Vehicle vehicle) {
			// ...
			return parkStartingAtSpot(0, vehicle);
		}
		
		private boolean parkStartingAtSpot(int num, Vehicle vehicle) {
			// ...
			return true;
		}
		
		public void spotFreed() {
			this.availableSpots++;
		}
	}
}
