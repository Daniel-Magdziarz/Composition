/*This program features Composition (SmartHouse.java)
It also features a two level menu.
It's goal is to control smart features of a house*/

import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static SmartHouse smartHouse = new SmartHouse();

    public static void main(String[] args) {

        boolean exit = false;
        mainMenu();
        int userInput;
        while (!exit) {
            System.out.print("Make Main Menu Selection: ");
            boolean isInt = keyboard.hasNextInt();
            if (isInt) {
                userInput = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                String wrongInput = keyboard.nextLine();
                System.out.println("\t\"" + wrongInput + "\" is a wrong input. Enter a numerical value only.\n");
                continue;
            }

            switch (userInput) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    mainMenu();
                    break;
                case 2:
                    if (garageDoor() == 0) {
                        exit = true;
                    }
                    break;
                case 3:
                    if (outdoorLights() == 0) {
                        exit = true;
                    }
                    break;
                case 4:
                    if (mainGate() == 0) {
                        exit = true;
                    }
                    break;
                case 5:
                    showSmartHouseStatus();
                    break;
                case 6:
                    setAllOutdoorToOnOpen();
                    break;
                case 7:
                    setAllOutdoorToOffClose();
                    break;
                default:
                    System.out.println("Wrong menu selection. Tray again.\n");
            }
        }
        System.out.println("   Application closing... Bye.");
        keyboard.close();
    }

    public static void setAllOutdoorToOnOpen() {

        if(smartHouse.getGarageDoor().isGarageDoorOpen()){
            System.out.println("Garage door already opened.");
        } else {
            smartHouse.getGarageDoor().setGarageDoor(true);
            smartHouse.getGarageDoor().openCloseGarageDoor();
        }

        if(smartHouse.getOutdoorLights().isOutdoorLightsOn()){
            System.out.println("The outdoor lights are already on");
        } else {
            smartHouse.getOutdoorLights().setOutdoorLights(true);
            smartHouse.getOutdoorLights().turnOnOffOutdoorLights();
        }

        if(smartHouse.getMainGate().isMainGateOpen()){
            System.out.println("The main gate is already opened");
        } else {
            smartHouse.getMainGate().setMainGate(true);
            smartHouse.getMainGate().openCloseMainGate();
        }
    }

    public static void setAllOutdoorToOffClose() {
        if(!smartHouse.getGarageDoor().isGarageDoorOpen()){
            System.out.println("Garage door already closed.");
        } else {
            smartHouse.getGarageDoor().setGarageDoor(false);
            smartHouse.getGarageDoor().openCloseGarageDoor();
        }

        if(!smartHouse.getOutdoorLights().isOutdoorLightsOn()){
            System.out.println("The outdoor lights are already OFF");
        } else {
            smartHouse.getOutdoorLights().setOutdoorLights(false);
            smartHouse.getOutdoorLights().turnOnOffOutdoorLights();
        }

        if(!smartHouse.getMainGate().isMainGateOpen()){
            System.out.println("The main gate is already closed");
        } else {
            smartHouse.getMainGate().setMainGate(false);
            smartHouse.getMainGate().openCloseMainGate();
        }
    }

    public static void showSmartHouseStatus() {
        System.out.println("   Smart House current status:\n" +
                "\t1. " + smartHouse.getGarageDoor().getGarageDoorStatus() +
                "\n\t2. " + smartHouse.getOutdoorLights().getOutdoorLightStatus() +
                "\n\t3. " + smartHouse.getMainGate().getMainGateStatus());
    }

    public static int garageDoor() {
        garageDoorMenu();
        boolean exit = false;
        int userMenuSelection = 2;
        while (!exit) {
            System.out.println("Select an option from the Garage Door Menu.");
            userMenuSelection = inputValidation();
            switch (userMenuSelection) {
                case 0:
                    exit = true;
                    userMenuSelection = 0;
                    break;
                case 1:
                    garageDoorMenu();
                    break;
                case 2:
                    exit = true;
                    mainMenu();
                    break;
                case 3:
                    garageDoor(3);
                    break;
                case 4:
                    garageDoor(4);
                    break;
                case 5:
                    garageDoor(5);
                    break;
                default:
                    System.out.println("\tInvalid menu selection.\n");
            }
        }
        return userMenuSelection;
    }

    private static void garageDoor(int userSelection) {

        switch (userSelection) {
            case 3: //Open garage door
                if (smartHouse.getGarageDoor().isGarageDoorOpen()) {
                    System.out.println("\tThe garage door is already OPENED\n");
                } else {
                    smartHouse.getGarageDoor().setGarageDoor(true);
                    smartHouse.getGarageDoor().openCloseGarageDoor();
                }
                break;
            case 4: //Close garage door
                if (!smartHouse.getGarageDoor().isGarageDoorOpen()) {
                    System.out.println("\tThe garage door is already CLOSED\n");
                } else {
                    smartHouse.getGarageDoor().setGarageDoor(false);
                    smartHouse.getGarageDoor().openCloseGarageDoor();
                }
                break;
            case 5: //Garage door status
                System.out.println(smartHouse.getGarageDoor().getGarageDoorStatus());
                break;
        }
    }

    public static int outdoorLights() {
        outdoorLightsMenu();
        boolean exit = false;
        int userMenuSelection = 2;
        while (!exit) {
            System.out.println("Select an option from the Outdoor Lights Menu.");
            userMenuSelection = inputValidation();
            switch (userMenuSelection) {
                case 0:
                    exit = true;
                    userMenuSelection = 0;
                    break;
                case 1:
                    outdoorLightsMenu();
                    break;
                case 2:
                    exit = true;
                    mainMenu();
                    break;
                case 3:
                    outdoorLights(3);
                    break;
                case 4:
                    outdoorLights(4);
                    break;
                case 5:
                    outdoorLights(5);
                    break;
                default:
                    System.out.println("\tInvalid menu selection.\n");
            }
        }
        return userMenuSelection;
    }

    private static void outdoorLights(int userSelection) {

        switch (userSelection) {
            case 3: //Turn on outdoor lights
                if (smartHouse.getOutdoorLights().isOutdoorLightsOn()) {
                    System.out.println("\tThe outdoor lights are already ON\n");
                } else {
                    smartHouse.getOutdoorLights().setOutdoorLights(true);
                    smartHouse.getOutdoorLights().turnOnOffOutdoorLights();
                }
                break;
            case 4: //turn off the outdoor lights
                if (!smartHouse.getOutdoorLights().isOutdoorLightsOn()) {
                    System.out.println("\tThe outdoor lights are already OFF\n");
                } else {
                    smartHouse.getOutdoorLights().setOutdoorLights(false);
                    smartHouse.getOutdoorLights().turnOnOffOutdoorLights();
                }
                break;
            case 5: //outdoor lights status
                System.out.println(smartHouse.getOutdoorLights().getOutdoorLightStatus());
                break;
        }
    }

    public static int mainGate() {
        mainGateMenu();
        boolean exit = false;
        int userMenuSelection = 2;
        while (!exit) {
            System.out.println("Select an option from the Main Gate Menu.");
            userMenuSelection = inputValidation();
            switch (userMenuSelection) {
                case 0:
                    exit = true;
                    userMenuSelection = 0;
                    break;
                case 1:
                    mainGateMenu();
                    break;
                case 2:
                    exit = true;
                    mainMenu();
                    break;
                case 3:
                    mainGate(3);
                    break;
                case 4:
                    mainGate(4);
                    break;
                case 5:
                    mainGate(5);
                    break;
                default:
                    System.out.println("\tInvalid menu selection.\n");
            }

        }
        return userMenuSelection;
    }

    private static void mainGate(int userSelection) {

        switch (userSelection) {
            case 3: //open main gate
                if (smartHouse.getMainGate().isMainGateOpen()) {
                    System.out.println("\tThe Main Gate is already OPENED.\n");
                } else {
                    smartHouse.getMainGate().setMainGate(true);
                    smartHouse.getMainGate().openCloseMainGate();
                }
                break;
            case 4: //close main gate
                if (!smartHouse.getMainGate().isMainGateOpen()) {
                    System.out.println("\tThe Main Gate is already CLOSED.\n");
                } else {
                    smartHouse.getMainGate().setMainGate(false);
                    smartHouse.getMainGate().openCloseMainGate();
                }
                break;
            case 5: //main gate status
                System.out.println(smartHouse.getMainGate().getMainGateStatus());
                break;
        }
    }

    public static int inputValidation() {
        String userInputStr = "";
        while (true) {
            System.out.print("\t\tEnter choice: ");
            try {
                userInputStr = keyboard.nextLine();
                return Integer.parseInt(userInputStr);
            } catch (NumberFormatException eft) {
                System.out.println("\t\"" + userInputStr + "\" is a wrong input. Enter a numerical value.\n");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("\tMAIN MENU\n" +
                "0 - exit\n" +
                "1 - Print Main Menu\n" +
                "2 - Enter Garage Door Menu\n" +
                "3 - Enter Outdoor Lights Menu\n" +
                "4 - Enter Main Gate Menu\n" +
                "5 - Show Smart House Status\n" +
                "6 - Set All On & Open\n" +
                "7 - Set All Off & Closed\n");
    }

    public static void garageDoorMenu() {
        System.out.println("\tGARAGE DOOR MENU\n" +
                "0 - Exit Application\n" +
                "1 - Print Garage Menu\n" +
                "2 - Move to Main Menu\n" +
                "3 - Open Garage Door\n" +
                "4 - Close Garage Door\n" +
                "5 - Show Garage Door Status\n");
    }

    public static void outdoorLightsMenu() {
        System.out.println("\tOUTDOOR LIGHTS MENU\n" +
                "0 - Exit Application\n" +
                "1 - Print Outdoor Lights Menu\n" +
                "2 - Move to Main Menu\n" +
                "3 - Turn On Outdoor Lights\n" +
                "4 - Turn Off Outdoor Lights\n" +
                "5 - Show Outdoor Lights Status\n");
    }

    public static void mainGateMenu() {
        System.out.println("\tMAIN GATE MENU\n" +
                "0 - Exit Application\n" +
                "1 - Print Main Gate Menu\n" +
                "2 - Move to Main Menu\n" +
                "3 - Open Main Gate\n" +
                "4 - Close Main Gate\n" +
                "5 - Show Main Gate Status\n");
    }
}
