package com.zzzHp.cakeonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Cake {
	private int cakeid;
	private String cakename;
	private String bigimagesrc;
	private String imagesrc1;
	private String imagesrc2;
	private String imagesrc3;
	private Set<Caketype> caketypeSet = new HashSet<Caketype>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	public String getBigimagesrc() {
		return bigimagesrc;
	}
	public void setBigimagesrc(String bigimagesrc) {
		this.bigimagesrc = bigimagesrc;
	}
	public String getImagesrc1() {
		return imagesrc1;
	}
	public void setImagesrc1(String imagesrc1) {
		this.imagesrc1 = imagesrc1;
	}
	public String getImagesrc2() {
		return imagesrc2;
	}
	public void setImagesrc2(String imagesrc2) {
		this.imagesrc2 = imagesrc2;
	}
	public String getImagesrc3() {
		return imagesrc3;
	}
	public void setImagesrc3(String imagesrc3) {
		this.imagesrc3 = imagesrc3;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cakeid")
	public Set<Caketype> getCaketypeSet() {
		return caketypeSet;
	}
	public void setCaketypeSet(Set<Caketype> caketypeSet) {
		this.caketypeSet = caketypeSet;
	}
	

	
}
