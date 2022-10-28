/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.inicio;
import view.admin;
import view.vende;
import view.cliente;
import model.lista;
import view.login;
import javax.swing.JTable;
import java.util.ArrayList;
import view.clien;
import view.vendedor;
import view.productos;
import model.listavendedor;

/**
 *
 * @author APRENDIZ SENA
 */
public class controlar implements ActionListener {

    inicio uno;

    vendedor vintro = new vendedor();

    clien clientein = new clien();

    vende vendedor = new vende();

    admin admin = new admin();

    cliente cliente = new cliente();

    login productos = new login();

    productos proin = new productos();

    ArrayList<lista> listaa = new ArrayList<lista>();
   
    private int id;
    private String nombre;
    private String apellido;
    
 

    private String name;
    private String co;

    

    public controlar(inicio uno) {
        this.uno = uno;
        this.iniciar();
        this.uno.ingresar1.addActionListener(this);
        this.vendedor.ingresar.addActionListener(this);
        this.cliente.guardarclie.addActionListener(this);
        this.vendedor.savevender.addActionListener(this);
        this.productos.guarprodu.addActionListener(this);
        this.cliente.limpiar.addActionListener(this);
        this.admin.mostracl.addActionListener(this);
        this.admin.sale.addActionListener(this);
        this.admin.producin.addActionListener(this);
        this.clientein.volverc.addActionListener(this);
        this.clientein.guardarclie.addActionListener(this);
        this.admin.SALIRADMIN.addActionListener(this);
        this.uno.salir.addActionListener(this);

    }

    public void iniciar() {
        this.uno.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.uno.ingresar1) {

            name = this.uno.nombre.getText();
            co = this.uno.contrase.getText();

            if (name.equals("admin") && co.equals("123")) {
                admin.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");

            } else if (name.equals("vendedor") && co.equals("789")) {
                vendedor.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");

            } else if (name.equals("cliente") && co.equals("456")) {
                clientein.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");

            } else if (name.equals("") && co.equals("")) {
                JOptionPane.showMessageDialog(null, "No valido");

            } else {
                JOptionPane.showMessageDialog(null, "DATO INCORRESTO");
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");
            }

        }
        if (e.getSource() == this.vendedor.ingresar) {
            uno.setVisible(true);
            vendedor.dispose();
            this.uno.nombre.setText("");
            this.uno.contrase.setText("");

        }

        if (this.admin.mostracl == e.getSource()) {
            this.admin.todo.add(cliente);
            cliente.show();
        }

        if (this.admin.sale == e.getSource()) {
            this.admin.todo.add(vintro);
            vintro.show();
        }

        if (this.admin.producin == e.getSource()) {
            this.admin.todo.add(proin);  
            proin.show();
        }

        if (e.getSource() == this.clientein.volverc) {
            uno.setVisible(true);
            clientein.dispose();
        }
        if (e.getSource() == this.admin.SALIRADMIN){
            uno.setVisible(true);
            admin.dispose();
        }
        if(e.getSource() == this.uno.salir){
            System.exit(0);
        }
        
       
        
    /*
        TABLA CLIENTE
        */
        if (e.getSource() == this.cliente.guardarclie) {
            id = Integer.parseInt(this.cliente.idcli.getText());
            nombre = this.cliente.nombreclie.getText();
            apellido = this.cliente.apecliente.getText();
            this.cliente.idcli.setText("");
            this.cliente.nombreclie.setText("");
            this.cliente.apecliente.setText("");

            listaa.add(new lista(id, nombre, apellido));
            llenarcliente(this.cliente.tablaclient, listaa);
        }
        if (e.getSource() == this.clientein.guardarclie) {
            id = Integer.parseInt(this.clientein.idcli.getText());
            nombre = this.clientein.nombreclie.getText();
            apellido = this.clientein.apecliente.getText();
            this.clientein.idcli.setText("");
            this.clientein.nombreclie.setText("");
            this.clientein.apecliente.setText("");

            listaa.add(new lista(id, nombre, apellido));
            llenarcliente(this.clientein.tablaclient, listaa);
        }
        /**
         * TABLA  VENDEDOR
         * */
        
        if (e.getSource() == this.vendedor.savevender) {
            id = Integer.parseInt(this.vendedor.idd.getText());
            nombre = this.vendedor.nombrevende.getText();
            apellido = this.vendedor.apellidovender.getText();
            this.vendedor.idd.setText("");
            this.vendedor.nombrevende.setText("");
            this.vendedor.apellidovender.setText("");

            listaa.add(new lista(id, nombre, apellido));
            llenar(this.vendedor.tablavender, listaa);
            
        }
/*
        if (e.getSource() == this.productos.guarprodu) {
            id = Integer.parseInt(this.productos.idpr.getText());
            precio = Integer.parseInt(this.productos.precio.getText());
            nombre = this.productos.nombrepr.getText();
            this.productos.idpr.setText("");
            this.productos.nombrepr.setText("");
            this.productos.precio.setText("");

            listaa.add(new lista(id, nombre, apellido, precio, usuario, contraseña));
            tablaproducto(this.productos.tablapr, listaa);

        }
        
         if (e.getSource() == this.proin.guarprodu) {
            id = Integer.parseInt(this.proin.idpr.getText());
            precio = Integer.parseInt(this.proin.precio.getText());
            nombre = this.proin.nombrepr.getText();
            this.proin.idpr.setText("");
            this.proin.nombrepr.setText("");
            this.proin.precio.setText("");

            listaa.add(new lista(id, nombre, apellido, precio, usuario, contraseña));
            tablaproducto(this.proin.tablapr, listaa);

    }
*/
    }
    public void llenarcliente(JTable tableclient, ArrayList<lista> listas) {
        for (int i = 0; i < listas.size(); i++) {
            tableclient.setValueAt(listas.get(i).getId(), i, 0);
            tableclient.setValueAt(listas.get(i).getNombre(), i, 1);
            tableclient.setValueAt(listas.get(i).getApellido(), i, 2);
        }
    }

    public void llenar(JTable tablavende, ArrayList<lista> listas) {
        for (int i = 0; i < listas.size(); i++) {
            tablavende.setValueAt(listas.get(i).getId(), i, 0);
            tablavende.setValueAt(listas.get(i).getNombre(), i, 1);
            tablavende.setValueAt(listas.get(i).getApellido(), i, 2);
        }
    }

    public void tablaproducto(JTable tablaprJTable, ArrayList<lista> lispro) {
        for (int i = 0; i < lispro.size(); i++) {
            tablaprJTable.setValueAt(lispro.get(i).getId(), i, 0);
            tablaprJTable.setValueAt(lispro.get(i).getNombre(), i, 1);
         

        }
        
    }
    
    
     public void tablapro(JTable tablapr, ArrayList<lista> lispro) {
        for (int i = 0; i < lispro.size(); i++) {
            tablapr.setValueAt(lispro.get(i).getId(), i, 0);
            tablapr.setValueAt(lispro.get(i).getNombre(), i, 1);
         

}
     
}
}