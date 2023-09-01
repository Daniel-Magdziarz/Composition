public class SmartHouse {

    private GarageDoor garageDoor;
    private OutdoorLights outdoorLights;
    private MainGate mainGate;

    public SmartHouse() {
        this.garageDoor = new GarageDoor();
        this.outdoorLights = new OutdoorLights();
        this.mainGate = new MainGate();
    }

    public GarageDoor getGarageDoor() {
        return garageDoor;
    }

    public OutdoorLights getOutdoorLights() {
        return outdoorLights;
    }

    public MainGate getMainGate() {
        return mainGate;
    }

    public void setAll(boolean garageDoor, boolean outdoorLights, boolean mainGate){//not used
        this.garageDoor.setGarageDoor(garageDoor);
        this.outdoorLights.setOutdoorLights(outdoorLights);
        this.mainGate.setMainGate(mainGate);
    }// remember to run 'runSmartHouse() once you set the smart features or the status will display wrong.

    public void runSmartHouse(){//not used
        System.out.print("1. ");
        garageDoor.openCloseGarageDoor();
        System.out.print("2. ");
        outdoorLights.turnOnOffOutdoorLights();
        System.out.print("3. ");
        mainGate.openCloseMainGate();
    }
}

class GarageDoor {

    private String garageDoorStatus;
    private boolean isGarageDoorOpen;



    public void setGarageDoor(boolean isDoorOpen) {
        this.isGarageDoorOpen = isDoorOpen;
    }

    public void openCloseGarageDoor() {
        if (isGarageDoorOpen) {
            System.out.println("\tGarage door is opening...");
            this.isGarageDoorOpen = true;
            System.out.println("\tGarage door opened.");
        } else {
            System.out.println("\tGarage door is closing...");
            this.isGarageDoorOpen = false;
            System.out.println("\tGarage door closed. ");
        }
    }

    private void garageDoorStatus() {
        if (isGarageDoorOpen) {
            this.garageDoorStatus = "\tGarage door is opened";
        } else {
            garageDoorStatus = "\tGarage door is closed.";
        }
    }

    public String getGarageDoorStatus() {
        garageDoorStatus();
        return garageDoorStatus;
    }

    public boolean isGarageDoorOpen() {
        return isGarageDoorOpen;
    }
}

class OutdoorLights {

    private String outdoorLightStatus;
    private boolean isOutdoorLightsOn;

    public void setOutdoorLights(boolean isLightON) {
        this.isOutdoorLightsOn = isLightON;
    }

    public void turnOnOffOutdoorLights() {
        if (isOutdoorLightsOn) {
            System.out.println("\tOutdoor lights ON");
            this.isOutdoorLightsOn = true;
        } else {
            System.out.println("\tOutdoor lights OFF");
            this.isOutdoorLightsOn = false;
        }
    }

    private void outdoorLightStatus() {
        if (isOutdoorLightsOn) {
            this.outdoorLightStatus = "\tOutdoor Lights are ON";
        } else {
            outdoorLightStatus = "\tOutdoor Lights are OFF.";
        }
    }

    public String getOutdoorLightStatus() {
        outdoorLightStatus();
        return outdoorLightStatus;
    }

    public boolean isOutdoorLightsOn() {
        return isOutdoorLightsOn;
    }
}

class MainGate {

    private String mainGateStatus;
    private boolean isMainGateOpen;

    public void setMainGate(boolean isDoorOpen) {
        this.isMainGateOpen = isDoorOpen;
    }

    public void openCloseMainGate() {
        if (isMainGateOpen) {
            System.out.println("\tMain gate is opening...");
            this.isMainGateOpen = true;
            System.out.println("\tMain gate opened.");
        } else {
            System.out.println("\tMain gate is closing...");
            this.isMainGateOpen = false;
            System.out.println("\tMain gate closed. ");
        }
    }

    private void mainGateStatus() {
        if (isMainGateOpen) {
            this.mainGateStatus = "\tMain Gate is opened";
        } else {
            mainGateStatus = "\tMain Gate is closed.";
        }
    }

    public String getMainGateStatus() {
        mainGateStatus();
        return mainGateStatus;
    }

    public boolean isMainGateOpen() {
        return isMainGateOpen;
    }
}