/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuanKeempatPBO;

/**
 *
 * @author Achmad
 */
public class TryCatch {
    
    public void untukTryCatch(int a){
        
        try{
            int[] array = {0,1,2,3};
            int index = a;
            System.out.println("index ke"+a+"adalah"+array[index]);
        }catch(Exception e){
            System.out.println("terjadi kesalahan "+ e.getMessage());
        }
    }
}
