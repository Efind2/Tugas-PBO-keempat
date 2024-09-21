/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuanKeempatPBO;

/**
 *
 * @author Achmad
 */
public class CostumEX extends ArrayIndexOutOfBoundsException {

    public CostumEX(String massage) {
        super(massage);
    }
    
    public static int cek(int index) throws CostumEX {
        int[] array = {0, 1, 2, 3};
        if(index > array.length){
            throw new CostumEX("index Array diluar batas ");
        }
        return index;
    }

    public static void main(String[] args) throws CostumEX {
        
        int[] array = {0, 1, 2, 3};
        int index = 5;

        try{
            cek(index);
            System.out.println("index ke "+index+" adalah "+array.length);
        }catch(CostumEX e){
            System.out.println(""+ e.getMessage());
        }
    }

}
