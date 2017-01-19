package chatencriptado;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class client_frame extends javax.swing.JFrame 
{
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    
    //--------------------------//
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    //--------------------------//
    
    public void userAdd(String data) 
    {
         users.add(data);
    }
    
    //--------------------------//
    
    public void userRemove(String data) 
    {
         ta_chat.append(data + " is now offline.\n");
    }
    
    //--------------------------//
    
    public void writeUsers() 
    {
         String[] tempList = new String[(users.size())];
         users.toArray(tempList);
         for (String token:tempList) 
         {
             //users.append(token + "\n");
         }
    }
    
    //--------------------------//
    
    public void sendDisconnect() 
    {
        String bye = (username + ": :Disconnect");
        try
        {
            writer.println(bye); 
            writer.flush(); 
        } catch (Exception e) 
        {
            ta_chat.append("Could not send Disconnect message.\n");
        }
    }

    //--------------------------//
    
    public void Disconnect() 
    {
        try 
        {
            ta_chat.append("Disconnected.\n");
            sock.close();
        } catch(Exception ex) {
            ta_chat.append("Failed to disconnect. \n");
        }
        isConnected = false;
        tf_username.setEditable(true);

    }
    
    public client_frame() 
    {
        initComponents();
    }
    
    //--------------------------//
    
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":");

                     if (data[2].equals(chat)) 
                     {
                        ta_chat.append(data[0] + ": " + data[1] + "\n");
                        aux=data[1];
                         System.out.println("data"+aux);
                        ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
                     } 
                     else if (data[2].equals(connect))
                     {
                        ta_chat.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        users.clear();
                     }
                }
           }catch(Exception ex) { }
        }
    }

    //--------------------------//
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_address = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        lb_port = new javax.swing.JLabel();
        tf_port = new javax.swing.JTextField();
        lb_username = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        lb_password = new javax.swing.JLabel();
        tf_password = new javax.swing.JTextField();
        b_connect = new javax.swing.JButton();
        b_disconnect = new javax.swing.JButton();
        b_anonymous = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        tf_chat = new javax.swing.JTextField();
        b_send = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Client's frame");
        setName("client"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_address.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lb_address.setText("Address : ");
        getContentPane().add(lb_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 11, 83, -1));

        tf_address.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        tf_address.setText("localhost");
        tf_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addressActionPerformed(evt);
            }
        });
        getContentPane().add(tf_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 8, 89, -1));

        lb_port.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lb_port.setText("Port :");
        getContentPane().add(lb_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 11, 83, -1));

        tf_port.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        tf_port.setText("2222");
        tf_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_portActionPerformed(evt);
            }
        });
        getContentPane().add(tf_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 8, 50, -1));

        lb_username.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lb_username.setText("Username :");
        getContentPane().add(lb_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 49, -1, -1));

        tf_username.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 45, 89, 25));

        lb_password.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lb_password.setText("Password : ");
        getContentPane().add(lb_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 49, -1, -1));

        tf_password.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        getContentPane().add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 45, 50, 25));

        b_connect.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        b_connect.setText("Connect");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });
        getContentPane().add(b_connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 45, -1, -1));

        b_disconnect.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        b_disconnect.setText("Disconnect");
        b_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_disconnectActionPerformed(evt);
            }
        });
        getContentPane().add(b_disconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 45, -1, -1));

        b_anonymous.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        b_anonymous.setText("Anonymous Login");
        b_anonymous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_anonymousActionPerformed(evt);
            }
        });
        getContentPane().add(b_anonymous, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 7, 208, -1));

        ta_chat.setColumns(20);
        ta_chat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 83, 555, 310));

        tf_chat.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        getContentPane().add(tf_chat, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 406, 198, 31));

        b_send.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        b_send.setText("ENVIAR");
        b_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sendActionPerformed(evt);
            }
        });
        getContentPane().add(b_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 406, 129, 31));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jButton2.setText("DESENCRIPTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 409, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoChat.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addressActionPerformed
       
    }//GEN-LAST:event_tf_addressActionPerformed

    private void tf_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_portActionPerformed
   
    }//GEN-LAST:event_tf_portActionPerformed

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
    
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed
        if (isConnected == false) 
        {
            username = tf_username.getText();
            tf_username.setEditable(false);

            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + ":has connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                ta_chat.append("Cannot Connect! Try Again. \n");
                tf_username.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            ta_chat.append("You are already connected. \n");
        }
    }//GEN-LAST:event_b_connectActionPerformed

    private void b_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_disconnectActionPerformed
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_b_disconnectActionPerformed

    private void b_anonymousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_anonymousActionPerformed
        tf_username.setText("");
        if (isConnected == false) 
        {
            String anon="anon";
            Random generator = new Random(); 
            int i = generator.nextInt(999) + 1;
            String is=String.valueOf(i);
            anon=anon.concat(is);
            username=anon;
            
            tf_username.setText(anon);
            tf_username.setEditable(false);

            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(anon + ":has connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                ta_chat.append("Cannot Connect! Try Again. \n");
                tf_username.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            ta_chat.append("You are already connected. \n");
        }        
    }//GEN-LAST:event_b_anonymousActionPerformed

    private void b_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sendActionPerformed
        String nothing = "";
        if ((tf_chat.getText()).equals(nothing)) {
            tf_chat.setText("");
            tf_chat.requestFocus();
        } else {
            try {
                
                msg.addKey("programacion");
                ultm = msg.encriptar(tf_chat.getText());
               writer.println(username + ":" + ultm + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                ta_chat.append("Message was not sent. \n");
            }
            tf_chat.setText("");
            tf_chat.requestFocus();
        }

        tf_chat.setText("");
        tf_chat.requestFocus();
    }//GEN-LAST:event_b_sendActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        msg.addKey("programacion");
        JOptionPane.showMessageDialog(null, msg.desencriptar(aux));
    }//GEN-LAST:event_jButton2ActionPerformed
 
    String ultm;
    String aux;
    Cifrado msg = new Cifrado();
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new client_frame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_anonymous;
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_disconnect;
    private javax.swing.JButton b_send;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_password;
    private javax.swing.JLabel lb_port;
    private javax.swing.JLabel lb_username;
    private javax.swing.JTextArea ta_chat;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_chat;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_port;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
