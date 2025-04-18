/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.table.inheritance;

import java.util.logging.Logger;

/**
 * The main entry point of the application demonstrating the use of vehicles.
 *
 * <p>The Table Inheritance pattern models a class hierarchy in a relational database by creating
 * separate tables for each class in the hierarchy. These tables share a common primary key, which
 * in subclass tables also serves as a foreign key referencing the primary key of the base class
 * table. This linkage maintains relationships and effectively represents the inheritance structure.
 * This pattern enables the organization of complex data models, particularly when subclasses have
 * unique properties that must be stored in distinct tables.
 */
public class App {
  /**
   * Manages the storage and retrieval of Vehicle objects, including Cars and Trucks.
   *
   * <p>This example demonstrates the **Table Inheritance** pattern, where each vehicle type (Car
   * and Truck) is stored in its own separate table. The `VehicleDatabase` simulates a simple
   * database that manages these entities, with each subclass (Car and Truck) being stored in its
   * respective table.
   *
   * <p>The `VehicleDatabase` contains the following tables: - `vehicleTable`: Stores all vehicle
   * objects, including both `Car` and `Truck` objects. - `carTable`: Stores only `Car` objects,
   * with fields specific to cars. - `truckTable`: Stores only `Truck` objects, with fields specific
   * to trucks.
   *
   * <p>The example demonstrates: 1. Saving instances of `Car` and `Truck` to their respective
   * tables in the database. 2. Retrieving vehicles (both cars and trucks) from the appropriate
   * table based on their ID. 3. Printing all vehicles stored in the database. 4. Showing how to
   * retrieve specific types of vehicles (`Car` or `Truck`) by their IDs.
   *
   * <p>In the **Table Inheritance** pattern, each subclass has its own table, making it easier to
   * manage specific attributes of each subclass.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    final Logger logger = Logger.getLogger(App.class.getName());

    VehicleDatabase database = new VehicleDatabase();

    Car car = new Car(2020, "Toyota", "Corolla", 4, 1);
    Truck truck = new Truck(2018, "Ford", "F-150", 60, 2);

    database.saveVehicle(car);
    database.saveVehicle(truck);

    database.printAllVehicles();

    Vehicle vehicle = database.getVehicle(car.getId());
    Car retrievedCar = database.getCar(car.getId());
    Truck retrievedTruck = database.getTruck(truck.getId());

    logger.info(String.format("Retrieved Vehicle: %s", vehicle));
    logger.info(String.format("Retrieved Car: %s", retrievedCar));
    logger.info(String.format("Retrieved Truck: %s", retrievedTruck));
  }
}
