package edu.mum.mobile.store.bean;

public class ProductDetail {
    private String cpu;
    private String memory;
    private String camera;
    private String sound;
    private String battery;
    private String os;
    private String display;
    private String timeAvailable;

    public ProductDetail() {

    }

    public ProductDetail(String cpu, String memory, String camera, String sound, String battery, String os, String display, String timeAvailable) {
        this.cpu = cpu;
        this.memory = memory;
        this.camera = camera;
        this.sound = sound;
        this.battery = battery;
        this.os = os;
        this.display = display;
        this.timeAvailable = timeAvailable;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(String timeAvailable) {
        this.timeAvailable = timeAvailable;
    }
}
