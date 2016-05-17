/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ogaz
 */
public class Department {
    int faculty;
    
    public Department(int x){
        //constructor
        faculty = x;
    }
    
    public String getSize(){
        return Integer.toString(faculty);
    }
}
