/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatencriptado;

/**
 *
 * @author Mateo
 */
public class ChatEncriptado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        server_frame ventanaMain = new server_frame();
        ventanaMain.setTitle("Servidor");
        ventanaMain.setLocationRelativeTo(null);
        ventanaMain.setVisible(true);
    }
    
}
