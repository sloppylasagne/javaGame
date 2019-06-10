/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasureisland;

/**
 *
 * @author Kieran
 */
public class item
{
    private String name;
    private String desc;
    private int x;
    private int y;
    public boolean isBeingCarried = false;
    public boolean hasBeenCarried = false;

    public item(String name, String desc, int x, int y)
    {
        this.name = name;
        this.desc = desc;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    public boolean isIsBeingCarried() {
        return isBeingCarried;
    }

    public boolean isHasBeenCarried() {
        return hasBeenCarried;
    }

  
}
