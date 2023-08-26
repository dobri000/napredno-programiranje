/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.volleybox.common_lib.domain;

import java.io.Serializable;

/**
 *
 * @author HOME
 */
public class Hall implements Serializable{
    
    private int hallId;
    private String hallName;
    private String address;

    public Hall(int hallId, String name, String address) {
        this.hallId = hallId;
        this.hallName = name;
        this.address = address;
    }

    public Hall(String name, String address) {
        this.hallName = name;
        this.address = address;
    }
    
    public Hall() {
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
    	if(hallName == null) {
    		throw new NullPointerException("Hall name cannot be null");
    	}
    	if(hallName.isEmpty()) {
    		throw new IllegalArgumentException("Hall name cannot be empty");
    	}
        this.hallName = hallName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
    	if(address == null) {
    		throw new NullPointerException("Address cannot be null");
    	}
    	if(address.isEmpty()) {
    		throw new IllegalArgumentException("Address cannot be empty");
    	}
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hall{" + "hallId=" + hallId + ", name=" + hallName + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.hallId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hall other = (Hall) obj;
        return this.hallId == other.hallId;
    }
    
    
    
}
