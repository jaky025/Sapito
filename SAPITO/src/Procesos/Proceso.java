/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Conexion.OracleConection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SONY
 */
public class Proceso {

    public ResultSet rs;
    public Statement st;
    private float ivaven;
    private float ventas;
    private float costoVen;
    private float salaryVen;
    private float salaryCom;
    private float salaryInv;
    private float salaryCont;
    private float salaryDir;
    private float salaryRH;
    private float salaryMant;
    private float otrosGast;
    private float inventario;
    private float inmueble;
    private float sueldo;
    private float impuestos;

    public float ventas() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUBTOTAL_COMPRA) from ORDEN_COMPRAS");

        if (rs.next()) {
            ventas = Float.parseFloat(rs.getString(1));
        }
        return ventas;
    }

    public float salarioVent() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=1");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;

    }

    public float costoVen() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUBTOTAL) from VENTAS");
        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;
    }

    public float ivaAcreditable() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(IVA) from VENTAS");
        if (rs.next()) {
            ivaven = Float.parseFloat(rs.getString(1));
        }
        return ivaven;
    }
    public float ventatotal() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(TOTAL) from VENTAS");
        if (rs.next()) {
            ivaven = Float.parseFloat(rs.getString(1));
        }
        return ivaven;
    }
    public float inventario() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(PRECIO_PZA_REPOR) from INVENTARIOS");
        if (rs.next()) {
            inventario = Float.parseFloat(rs.getString(1));
        }
        return inventario;
    }
    
    public float inmueble() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(PRECIO_ACTIVO) from INVENTARIO_INMUEBLES");
        if (rs.next()) {
            inmueble = Float.parseFloat(rs.getString(1));
        }
        return inmueble;
    }
    public float nomina() throws SQLException
    {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS");
        if (rs.next()) {
            sueldo = Float.parseFloat(rs.getString(1));
        }
        return sueldo;
    }
    public float impuestos() throws SQLException
    {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(IMPUESTOS) from DETALLE_ORDENES");
        if (rs.next()) {
            impuestos = Float.parseFloat(rs.getString(1));
        }
        return impuestos;
    }
    public float salariocont() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=2");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;

    }
    public float salariocom() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=3");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;

    }
    public float salariodir() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=4");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;

    }
    public float salarioinv() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=5");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;

    }
    public float salariomant() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=6");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;

    }
     public float salarioRH() throws SQLException {
        st = OracleConection.getConexion().createStatement();
        rs = st.executeQuery("select sum(SUELDO) from NOMINAS where ID_PUESTO=7");

        if (rs.next()) {
            costoVen = Float.parseFloat(rs.getString(1));
        }
        return costoVen;
    }
    public float utilidad() throws SQLException{
       float gasto=new Proceso().costoVen();
       float ingreso=new Proceso().ventas();
       
       float utilidad=gasto-ingreso;
       return utilidad;
    }
    
}
