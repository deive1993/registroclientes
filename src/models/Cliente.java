/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author PC12
 */
public class Cliente {
   // private int (8) pk autoin
    private Integer id = null;
    private String nombre;
    private String apellido;
    private Integer dni;
    private String email;
    private String telefono;
    private String celular;
    private String calle;
    private String altura;
    private String pisoDto;

    public Cliente(String nombre, String apellido, Integer dni, String email, String telefono, String celular, String calle, String altura, String pisoDto) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.calle = calle;
        this.altura = altura;
        this.pisoDto = pisoDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPisoDto() {
        return pisoDto;
    }

    public void setPisoDto(String pisoDto) {
        this.pisoDto = pisoDto;
    }

    
}
