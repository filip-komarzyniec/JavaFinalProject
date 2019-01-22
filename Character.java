package po.crawler.web.project;

import java.awt.image.BufferedImage;

public class Character {

    private String name;
    private String img;

    private int pointer = -1;   // package private

    private int health;
    private int force;
    private int witchcraft;
    private int armor;
    private String type;
    private BufferedImage image;


    Observer observer;
    Items item = new Items();
    Boots boot = new Boots();


// konstruktor

    public Character(){}    // pusty

    public void warrior() {
        this.health = 1000;
        this.force = 500;
        this.witchcraft = 100;
        this.armor=500;
        this.type = "WARRIOR";
    }

    public void mag(){
        this.health=1500;
        this.force = 100;
        this.witchcraft=500;
        this.armor = 250;
        this.type="MAG";
    }

    public void tank(){
        this.health=1000;
        this.armor=1000;
        this.witchcraft=0;
        this.force =500;
        this.type="TANK";
    }

    public void setter(int number) {
        if(number > GetLOL.characters.size()-1 || number < 0){System.out.println("error1");}
        else{
            this.name=GetLOL.characters.get(number);

        }
    }
    public void changeup() {
        if(pointer < GetLOL.characters.size()-1){
            pointer+=1;
            setter(pointer);
            inform();       // metoda uaktualniająca obrazek w GUI
        }
        else{
            pointer= -1;
            changeup();
        }
    }

    public void changedown() {
        if(pointer > 0){
            pointer-=1;
            setter(pointer);
            inform();   // uaktualnienie oobrazka w GUI
        }
        else{
            pointer=GetLOL.characters.size()-1;
            changedown();
        }
    }

    // Observer Pattern
    public void inform(){
        observer.update();
    }

    public void subscribe(Observer o){
        observer = o;
    }
    public void unsubscribe(Observer o){
        if(o==observer){
            observer=null;
        }
    }

// gettery
    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public int getHealth() {
        return health + item.getAdd1() + boot.getAdd1();
    }

    public int getForce() {
        return force + item.getAdd2() + boot.getAdd2();
    }

    public int getWitchcraft() {
        return witchcraft + item.getAdd3() + boot.getAdd3();
    }

    public int getArmor() {
        return armor + item.getAdd4() + boot.getAdd4();
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointer() {
        return pointer;
    }

    public BufferedImage getImage() {
        return image;
    }
// settery

    public void reset(){
        this.health=0;
        this.armor=0;
        this.force = 0;
        this.witchcraft=0;
        this.item.reset();
        this.boot.reset();
        this.pointer = -1;
    }
}
