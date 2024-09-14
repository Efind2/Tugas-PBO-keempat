/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuanKeempatPBO;

/**
 *
 * @author Achmad
 */
public class Utama {

    public static void main(String[] args) throws Exception {

        TryCatch array = new TryCatch();
        System.out.println("Ini try catch");
        array.untukTryCatch(5);

        CobaThrows array2 = new CobaThrows();
        System.out.println("Ini Throws");
        array2.untukThrows(5);

    }
}
