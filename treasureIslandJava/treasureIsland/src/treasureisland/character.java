/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasureisland;

/**
 *
 * @author 10769486
 */
public class character
{
    String name;
    static int x;
    static int y;
    boolean isCarrying = false;
    
    public character(String name, int x, int y)
    {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public String getName()
    {
        return name;
    }
}
