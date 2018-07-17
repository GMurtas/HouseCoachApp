package com.example.giuliam.housecoach;

public class ItemGadget {

    private String gadgetName;
    private String imageName;
    private String buttonName;

    public ItemGadget(String gadgetName, String imageName, String buttonName) {
        this.gadgetName = gadgetName;
        this.imageName = imageName;
       this.buttonName = buttonName;
    }

    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName ) {
        this.gadgetName = gadgetName;

    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }



}